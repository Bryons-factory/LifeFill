package com.example.lifefill.data.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "allergies")
public class AllergyEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String symptoms;
    public String cause;

    public AllergyEntity(String symptoms, String cause) {
        this.symptoms = symptoms;
        this.cause = cause;
    }
}
