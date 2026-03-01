package com.example.lifefill.data.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "passwords")
public class PasswordEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String msHash;
    public String oneTimePassword;

    public PasswordEntity(String msHash, String oneTimePassword) {
        this.msHash = msHash;
        this.oneTimePassword = oneTimePassword;
    }
}
