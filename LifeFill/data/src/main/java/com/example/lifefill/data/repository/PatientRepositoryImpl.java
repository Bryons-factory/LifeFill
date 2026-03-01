package com.example.lifefill.data.repository;

import com.example.lifefill.core.model.Patient;
import com.example.lifefill.core.repository.PatientRepository;

/**
 * Stub implementation of PatientRepository.
 * Replace with SQLCipher/API-backed implementation.
 */
public class PatientRepositoryImpl implements PatientRepository {

    private Patient cachedPatient;

    @Override
    public Patient getPatient() {
        if (cachedPatient != null) {
            return cachedPatient;
        }
        // TODO: Load from SQLCipher database
        return null;
    }

    @Override
    public void savePatient(Patient patient) {
        this.cachedPatient = patient;
        // TODO: Persist to SQLCipher database
    }
}
