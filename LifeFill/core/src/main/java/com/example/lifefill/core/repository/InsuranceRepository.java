package com.example.lifefill.core.repository;

import com.example.lifefill.core.model.Insurance;

import java.util.List;

/**
 * Contract for insurance data access.
 * Implemented by the data module; used by the app (UI) module.
 */
public interface InsuranceRepository {
    List<Insurance> getInsurance();
    void saveInsurance(List<Insurance> insurance);
}
