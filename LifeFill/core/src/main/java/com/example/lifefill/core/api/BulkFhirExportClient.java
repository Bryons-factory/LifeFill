package com.example.lifefill.core.api;

/**
 * Contract for FHIR Bulk Data Export (async $export pattern).
 * <p>
 * Flow: (1) requestExport → 202 + Content-Location, (2) poll status at Content-Location,
 * (3) when complete, obtain NDJSON file URLs and download before they expire (24–48h).
 */
public interface BulkFhirExportClient {

    /**
     * Kick-off a bulk export. Use Group-level export for specific cohorts when possible.
     *
     * @param accessToken SMART/OAuth access token (must include system/*.read or required bulk scopes).
     * @param groupId     Optional Group ID for group-level export; null for system export (if allowed).
     * @param types       Optional resource types (e.g. "Patient,AllergyIntolerance"); null = server default.
     * @return Status containing Content-Location to poll, or error state.
     */
    BulkExportJobStatus requestExport(String accessToken, String groupId, String types);

    /**
     * Poll the status of an in-progress export.
     *
     * @param accessToken     Valid access token.
     * @param contentLocation URL from the 202 response (Content-Location header).
     * @return Current status (IN_PROGRESS, COMPLETE with output files, or FAILED).
     */
    BulkExportJobStatus pollStatus(String accessToken, String contentLocation);
}
