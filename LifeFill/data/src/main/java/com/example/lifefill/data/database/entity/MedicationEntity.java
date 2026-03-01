package com.example.lifefill.data.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "medications")
public class MedicationEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String dose;
    public String startDate;
    public String endDate;

    public MedicationEntity(String name, String dose, String startDate, String endDate) {
        this.name = name;
        this.dose = dose;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
