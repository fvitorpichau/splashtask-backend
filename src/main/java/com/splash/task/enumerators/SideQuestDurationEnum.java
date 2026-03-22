package com.splash.task.enumerators;

public enum SideQuestDurationEnum {

    QUICK_ERRAND("Quick Errand"),
    A_FEW_HOURS("A few hours"),
    WEEKEND_PROJECT("Weekend project");

    private final String value;

    SideQuestDurationEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}