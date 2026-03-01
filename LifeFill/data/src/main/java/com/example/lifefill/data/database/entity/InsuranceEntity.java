package com.example.lifefill.data.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "insurance")
public class InsuranceEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String provider;
    public double cost;

    public InsuranceEntity(String provider, double cost) {
        this.provider = provider;
        this.cost = cost;
    }
}
