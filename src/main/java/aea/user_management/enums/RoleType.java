package aea.user_management.enums;

public enum RoleType {

    ADMIN(""),
    USER("");


    private final String description;

    private RoleType(String description) {
        this.description = description;
    }


    private String getDescription() {
        return description;
    }

}
