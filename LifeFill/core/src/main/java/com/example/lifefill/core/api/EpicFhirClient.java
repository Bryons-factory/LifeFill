package com.example.lifefill.core.api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Retrofit contract for Epic / FHIR API access.
 * For the hackathon demo we pull raw JSON (e.g. Medications) from the SMART on FHIR sandbox.
 */
public interface EpicFhirClient {
    @Headers("Accept: application/fhir+json")
    @GET("MedicationRequest")
    Call<JsonObject> getPatientMedications(@Query("patient") String patientId);
}
