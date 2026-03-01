package com.example.lifefill.data.bulk;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Streams NDJSON (Newline Delimited JSON) without loading the entire file into memory.
 * Use for Bulk FHIR export files to keep memory and cost low.
 * <p>
 * Usage: wrap a Reader (e.g. from OkHttp response body or file), then iterate over lines
 * and parse each line as JSON into your FHIR resource or domain model.
 */
public final class NdjsonStreamParser {

    private final BufferedReader reader;

    public NdjsonStreamParser(Reader reader) {
        this.reader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
    }

    /**
     * Returns an iterator over raw JSON lines. Caller is responsible for parsing each line
     * (e.g. with Gson) and mapping to Patient, AllergyIntolerance, etc.
     */
    @NonNull
    public Iterator<String> lineIterator() {
        return new Iterator<String>() {
            private String nextLine;
            private boolean exhausted;

            @Override
            public boolean hasNext() {
                if (nextLine != null) return true;
                if (exhausted) return false;
                try {
                    nextLine = NdjsonStreamParser.this.reader.readLine();
                    if (nextLine == null) exhausted = true;
                } catch (IOException e) {
                    throw new RuntimeException("NDJSON read error", e);
                }
                return nextLine != null;
            }

            @Override
            public String next() {
                if (!hasNext()) throw new NoSuchElementException();
                String line = nextLine;
                nextLine = null;
                return line;
            }
        };
    }

    /**
     * Closes the underlying reader. Call when done to release resources.
     */
    public void close() throws IOException {
        reader.close();
    }
}
