package com.example.lifefill.core.repository;

import com.example.lifefill.core.model.Allergy;

import java.util.List;

/**
 * Contract for allergy data access.
 * Implemented by the data module; used by the app (UI) module.
 */
public interface AllergyRepository {
    List<Allergy> getAllergies();
    void saveAllergies(List<Allergy> allergies);
}
