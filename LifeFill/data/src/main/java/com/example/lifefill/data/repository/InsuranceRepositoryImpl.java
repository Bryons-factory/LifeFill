package com.example.lifefill.data.repository;

import com.example.lifefill.core.model.Insurance;
import com.example.lifefill.core.repository.InsuranceRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Stub implementation of InsuranceRepository.
 * Replace with SQLCipher/Flexpa-backed implementation.
 */
public class InsuranceRepositoryImpl implements InsuranceRepository {

    private List<Insurance> cachedInsurance = new ArrayList<>();

    @Override
    public List<Insurance> getInsurance() {
        // TODO: Load from SQLCipher database
        return new ArrayList<>(cachedInsurance);
    }

    @Override
    public void saveInsurance(List<Insurance> insurance) {
        this.cachedInsurance = insurance != null ? new ArrayList<>(insurance) : new ArrayList<>();
        // TODO: Persist to SQLCipher database
    }
}
