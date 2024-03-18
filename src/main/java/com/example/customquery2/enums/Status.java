package com.example.customquery2.enums;

public enum Status {
    ONTIME("On time"),
    DELAYED("Delayed"),
    CANCELLED("Canceled");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}