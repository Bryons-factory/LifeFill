package com.example.lifefill.core.model;

/**
 * Domain model for insurance/coverage.
 */
public class Insurance {
    private final String id;
    private final String payerName;
    private final String memberId;
    private final String groupNumber;

    public Insurance(String id, String payerName, String memberId, String groupNumber) {
        this.id = id;
        this.payerName = payerName;
        this.memberId = memberId;
        this.groupNumber = groupNumber;
    }

    public String getId() { return id; }
    public String getPayerName() { return payerName; }
    public String getMemberId() { return memberId; }
    public String getGroupNumber() { return groupNumber; }
}
