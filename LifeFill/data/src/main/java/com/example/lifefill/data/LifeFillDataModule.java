package com.example.lifefill.data;

import com.example.lifefill.core.api.EpicFhirClient;
import com.example.lifefill.core.repository.AllergyRepository;
import com.example.lifefill.core.repository.InsuranceRepository;
import com.example.lifefill.core.repository.PatientRepository;
import com.example.lifefill.data.api.EpicFhirClientImpl;
import com.example.lifefill.data.repository.AllergyRepositoryImpl;
import com.example.lifefill.data.repository.InsuranceRepositoryImpl;
import com.example.lifefill.data.repository.PatientRepositoryImpl;

/**
 * Factory for data layer components.
 * App module uses this to obtain repository instances.
 */
public final class LifeFillDataModule {

    private static PatientRepository patientRepository;
    private static AllergyRepository allergyRepository;
    private static InsuranceRepository insuranceRepository;
    private static EpicFhirClient epicFhirClient;

    public static PatientRepository getPatientRepository() {
        if (patientRepository == null) {
            patientRepository = new PatientRepositoryImpl();
        }
        return patientRepository;
    }

    public static AllergyRepository getAllergyRepository() {
        if (allergyRepository == null) {
            allergyRepository = new AllergyRepositoryImpl();
        }
        return allergyRepository;
    }

    public static InsuranceRepository getInsuranceRepository() {
        if (insuranceRepository == null) {
            insuranceRepository = new InsuranceRepositoryImpl();
        }
        return insuranceRepository;
    }

    public static EpicFhirClient getEpicFhirClient() {
        if (epicFhirClient == null) {
            epicFhirClient = new EpicFhirClientImpl();
        }
        return epicFhirClient;
    }
}
