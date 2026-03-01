package com.example.lifefill.core.model;

/**
 * Domain model for allergy/intolerance.
 */
public class Allergy {
    private final String id;
    private final String substance;
    private final String reaction;
    private final String criticality;

    public Allergy(String id, String substance, String reaction, String criticality) {
        this.id = id;
        this.substance = substance;
        this.reaction = reaction;
        this.criticality = criticality;
    }

    public String getId() { return id; }
    public String getSubstance() { return substance; }
    public String getReaction() { return reaction; }
    public String getCriticality() { return criticality; }
}
