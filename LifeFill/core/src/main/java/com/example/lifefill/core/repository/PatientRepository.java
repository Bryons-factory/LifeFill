package com.example.lifefill.core.repository;

import com.example.lifefill.core.model.Patient;

/**
 * Contract for patient data access.
 * Implemented by the data module; used by the app (UI) module.
 */
public interface PatientRepository {
    Patient getPatient();
    void savePatient(Patient patient);
}
