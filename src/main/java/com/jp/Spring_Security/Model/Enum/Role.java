package com.jp.Spring_Security.Model.Enum;

public enum Role {
    ADMIN("admin"),
    USER("user");

    private String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
