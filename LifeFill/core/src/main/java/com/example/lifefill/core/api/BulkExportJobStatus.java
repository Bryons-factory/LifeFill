package com.example.lifefill.core.api;

import java.util.List;

/**
 * Result of a Bulk FHIR export job status poll.
 * Aligns with FHIR Bulk Data $export async pattern (Content-Location polling).
 */
public final class BulkExportJobStatus {

    public enum State {
        /** Export request accepted; poll again later. */
        IN_PROGRESS,
        /** Export complete; output file URLs are available. */
        COMPLETE,
        /** Export failed or was cancelled. */
        FAILED,
        /** Status could not be determined (e.g. network error). */
        UNKNOWN
    }

    private final State state;
    private final String contentLocation;
    private final List<BulkExportOutputFile> outputFiles;
    private final String errorMessage;

    public BulkExportJobStatus(State state, String contentLocation,
                               List<BulkExportOutputFile> outputFiles, String errorMessage) {
        this.state = state;
        this.contentLocation = contentLocation;
        this.outputFiles = outputFiles != null ? outputFiles : List.of();
        this.errorMessage = errorMessage;
    }

    public State getState() {
        return state;
    }

    public String getContentLocation() {
        return contentLocation;
    }

    public List<BulkExportOutputFile> getOutputFiles() {
        return outputFiles;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * A single NDJSON file produced by the bulk export.
     */
    public static final class BulkExportOutputFile {
        private final String type;   // e.g. "Patient", "AllergyIntolerance"
        private final String url;

        public BulkExportOutputFile(String type, String url) {
            this.type = type;
            this.url = url;
        }

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }
    }
}
