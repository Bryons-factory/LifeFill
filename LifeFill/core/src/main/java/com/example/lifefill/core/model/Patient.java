package com.example.lifefill.core.model;

import java.util.List;

/**
 * Domain model for patient demographics.
 */
public class Patient {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String dateOfBirth;
    private final String mrn;
    private final String email;
    private final String phone;

    public Patient(String id, String firstName, String lastName, String dateOfBirth,
                   String mrn, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.mrn = mrn;
        this.email = email;
        this.phone = phone;
    }

    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDateOfBirth() { return dateOfBirth; }
    public String getMrn() { return mrn; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}
