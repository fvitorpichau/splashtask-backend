package com.splash.task.dto;

import com.splash.task.enumerators.SideQuestFinishingStateEnum;
import com.splash.task.enumerators.SideQuestUrgencyLevelEnum;
import lombok.Data;

@Data
public class MainQuestDTO {

    private Long id;

    private String name;

    private SideQuestUrgencyLevelEnum urgencyLevel;

    private SideQuestFinishingStateEnum state;

}