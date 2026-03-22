package com.splash.task.dto;

import com.splash.task.enumerators.SideQuestDurationEnum;
import com.splash.task.enumerators.SideQuestFinishingStateEnum;
import com.splash.task.enumerators.SideQuestUrgencyLevelEnum;
import lombok.Data;

import java.util.List;

@Data
public class SideQuestDTO {

    private Long id;

    private String name;

    private SideQuestFinishingStateEnum state;

    private SideQuestUrgencyLevelEnum urgency;

    private SideQuestDurationEnum duration;

    private Long parentId;

    private List<SideQuestDTO> subQuests;

}