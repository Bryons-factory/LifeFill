package com.example.lifefill.data.api;

import com.example.lifefill.core.api.EpicFhirClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Builds the Retrofit instance and exposes the FHIR API for the hackathon demo.
 * Points to the open SMART on FHIR sandbox.
 */
public final class EpicFhirClientImpl {

    private final EpicFhirClient api;

    public EpicFhirClientImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://r4.smarthealthit.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.api = retrofit.create(EpicFhirClient.class);
    }

    public EpicFhirClient getApi() {
        return api;
    }
}
