package com.example.lifefill.data.api;

import com.example.lifefill.core.api.BulkExportJobStatus;
import com.example.lifefill.core.api.BulkFhirExportClient;

import java.util.Collections;
import java.util.List;

/**
 * Implementation of Bulk FHIR $export client for Epic (or other Bulk Data servers).
 * <p>
 * TODO: Replace with Retrofit/OkHttp calls to:
 * - POST [base]/Group/[id]/$export (group export) or [base]/$export (system)
 * - GET [Content-Location] for status poll (202 → keep polling, 200 → body has output file list)
 * Ensure Accept: application/fhir+json and Prefer: respond-async. Parse NDJSON output list.
 */
public class BulkFhirExportClientImpl implements BulkFhirExportClient {

    @Override
    public BulkExportJobStatus requestExport(String accessToken, String groupId, String types) {
        // TODO: POST to $export; return status with Content-Location from 202 response.
        // Prefer Group-level export: .../Group/{groupId}/$export when groupId != null.
        return new BulkExportJobStatus(
                BulkExportJobStatus.State.UNKNOWN,
                null,
                Collections.emptyList(),
                "Bulk export not implemented: add Retrofit $export call"
        );
    }

    @Override
    public BulkExportJobStatus pollStatus(String accessToken, String contentLocation) {
        // TODO: GET contentLocation; if 202 retry later, if 200 parse body for output file URLs.
        return new BulkExportJobStatus(
                BulkExportJobStatus.State.UNKNOWN,
                contentLocation,
                Collections.emptyList(),
                "Poll status not implemented: add GET to Content-Location"
        );
    }
}
