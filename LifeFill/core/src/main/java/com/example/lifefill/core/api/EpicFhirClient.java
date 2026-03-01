package com.example.lifefill.core.api;

import com.example.lifefill.core.model.Patient;

import java.util.List;

/**
 * Contract for Epic FHIR API access.
 * Implemented by the data module; used by the app (UI) module for sync flows.
 */
public interface EpicFhirClient {
    Patient fetchPatient(String accessToken);
    List<com.example.lifefill.core.model.Allergy> fetchAllergies(String accessToken);
}
