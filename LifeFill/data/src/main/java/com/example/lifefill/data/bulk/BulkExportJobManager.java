package com.example.lifefill.data.bulk;

import com.example.lifefill.core.api.BulkExportJobStatus;
import com.example.lifefill.core.api.BulkFhirExportClient;

/**
 * Orchestrates the async Bulk FHIR export flow: kick-off, poll with retry/backoff, then download.
 * <p>
 * Responsibilities:
 * <ul>
 *   <li>Call {@link BulkFhirExportClient#requestExport} to kick off.</li>
 *   <li>Poll {@link BulkFhirExportClient#pollStatus} at Content-Location with backoff (e.g. exponential).</li>
 *   <li>Honour timeouts: bulk exports can take minutes or hours.</li>
 *   <li>When status is COMPLETE, download each output file URL immediately (Epic typically keeps files 24–48h).</li>
 *   <li>Feed downloaded NDJSON to {@link NdjsonStreamParser} for streaming ingestion.</li>
 * </ul>
 * <p>
 * On Android, run this from WorkManager or a foreground service so the job survives process death.
 * TODO: Implement polling loop, retry/backoff, timeout limits, and download + parse pipeline.
 */
public class BulkExportJobManager {

    private final BulkFhirExportClient exportClient;

    public BulkExportJobManager(BulkFhirExportClient exportClient) {
        this.exportClient = exportClient;
    }

    /**
     * Start a group-level bulk export and run polling until complete or failed.
     * Caller should run this on a background thread or via WorkManager.
     *
     * @param accessToken Valid OAuth token (system/*.read or required bulk scopes).
     * @param groupId     Group ID for cohort export; null if using system export.
     * @param types       Optional resource types (e.g. "Patient,AllergyIntolerance"); null for server default.
     * @param callback    Receives status updates and, on COMPLETE, the list of output files to download.
     */
    public void runExportJob(String accessToken, String groupId, String types,
                             BulkExportJobCallback callback) {
        BulkExportJobStatus initial = exportClient.requestExport(accessToken, groupId, types);
        if (initial.getState() == BulkExportJobStatus.State.COMPLETE) {
            callback.onComplete(initial.getOutputFiles());
            return;
        }
        if (initial.getState() == BulkExportJobStatus.State.FAILED) {
            callback.onFailed(initial.getErrorMessage());
            return;
        }
        String contentLocation = initial.getContentLocation();
        if (contentLocation == null || contentLocation.isEmpty()) {
            callback.onFailed(initial.getErrorMessage() != null ? initial.getErrorMessage() : "No Content-Location");
            return;
        }
        // TODO: Implement polling loop with backoff (e.g. 1s, 2s, 4s... max interval, timeout after N minutes).
        // On each 202, callback.onProgress(); on 200 COMPLETE, callback.onComplete(outputFiles); on FAILED, callback.onFailed.
        callback.onProgress("Polling not implemented: add poll loop with retry/backoff");
    }

    /**
     * Callback for export job progress and completion.
     */
    public interface BulkExportJobCallback {
        void onProgress(String message);
        void onComplete(java.util.List<BulkExportJobStatus.BulkExportOutputFile> outputFiles);
        void onFailed(String errorMessage);
    }
}
