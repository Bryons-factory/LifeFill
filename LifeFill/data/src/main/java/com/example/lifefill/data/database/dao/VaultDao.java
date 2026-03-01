package com.example.lifefill.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.lifefill.data.database.entity.AllergyEntity;
import com.example.lifefill.data.database.entity.EmergencyContactEntity;
import com.example.lifefill.data.database.entity.InsuranceEntity;
import com.example.lifefill.data.database.entity.MedicationEntity;
import com.example.lifefill.data.database.entity.PasswordEntity;

import java.util.List;

@Dao
public interface VaultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertInsurance(InsuranceEntity insurance);

    @Query("SELECT * FROM insurance")
    List<InsuranceEntity> getAllInsurance();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEmergencyContact(EmergencyContactEntity contact);

    @Query("SELECT * FROM emergency_contacts")
    List<EmergencyContactEntity> getAllEmergencyContacts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllergy(AllergyEntity allergy);

    @Query("SELECT * FROM allergies")
    List<AllergyEntity> getAllAllergies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPassword(PasswordEntity password);

    @Query("SELECT * FROM passwords")
    List<PasswordEntity> getAllPasswords();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMedication(MedicationEntity medication);

    @Query("SELECT * FROM medications")
    List<MedicationEntity> getAllMedications();
}
