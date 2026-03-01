package com.example.lifefill.data.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "emergency_contacts")
public class EmergencyContactEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String peopleApiId;
    public String contactInfo;

    public EmergencyContactEntity(String peopleApiId, String contactInfo) {
        this.peopleApiId = peopleApiId;
        this.contactInfo = contactInfo;
    }
}
