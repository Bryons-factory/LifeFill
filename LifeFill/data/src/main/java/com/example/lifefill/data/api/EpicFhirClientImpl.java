package com.example.lifefill.data.api;

import com.example.lifefill.core.api.EpicFhirClient;
import com.example.lifefill.core.model.Allergy;
import com.example.lifefill.core.model.Patient;

import java.util.Collections;
import java.util.List;

/**
 * Stub implementation of EpicFhirClient.
 * Replace with Retrofit + AppAuth + FHIR parsing.
 */
public class EpicFhirClientImpl implements EpicFhirClient {

    @Override
    public Patient fetchPatient(String accessToken) {
        // TODO: Retrofit call to Epic FHIR Patient endpoint
        return null;
    }

    @Override
    public List<Allergy> fetchAllergies(String accessToken) {
        // TODO: Retrofit call to Epic FHIR AllergyIntolerance endpoint
        return Collections.emptyList();
    }
}
