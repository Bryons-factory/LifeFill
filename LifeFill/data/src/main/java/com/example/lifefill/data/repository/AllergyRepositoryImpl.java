package com.example.lifefill.data.repository;

import com.example.lifefill.core.model.Allergy;
import com.example.lifefill.core.repository.AllergyRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Stub implementation of AllergyRepository.
 * Replace with SQLCipher/API-backed implementation.
 */
public class AllergyRepositoryImpl implements AllergyRepository {

    private List<Allergy> cachedAllergies = new ArrayList<>();

    @Override
    public List<Allergy> getAllergies() {
        // TODO: Load from SQLCipher database
        return new ArrayList<>(cachedAllergies);
    }

    @Override
    public void saveAllergies(List<Allergy> allergies) {
        this.cachedAllergies = allergies != null ? new ArrayList<>(allergies) : new ArrayList<>();
        // TODO: Persist to SQLCipher database
    }
}
