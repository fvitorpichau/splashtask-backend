package com.splash.task.enumerators;

public enum SideQuestUrgencyLevelEnum {

    MANAGEABLE("Manageable"),
    CAN_WAIT("Can Wait"),
    URGENT("Urgent");

    private final String value;

    SideQuestUrgencyLevelEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}