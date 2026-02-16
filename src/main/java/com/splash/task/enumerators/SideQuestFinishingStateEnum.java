package com.splash.task.enumerators;

public enum SideQuestFinishingStateEnum {

    TO_BE_DONE("TO_BE_DONE"),
    DOING("DOING"),
    DONE("DONE");

    private final String value;

    SideQuestFinishingStateEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}