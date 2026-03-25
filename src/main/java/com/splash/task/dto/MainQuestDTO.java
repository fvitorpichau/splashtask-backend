package com.splash.task.dto;

import com.splash.task.enumerators.MainQuestCategoryEnum;
import com.splash.task.enumerators.SideQuestFinishingStateEnum;
import lombok.Data;

@Data
public class MainQuestDTO {

    private Long id;

    private String name;

    private Integer current;

    private Integer target;

    private SideQuestFinishingStateEnum state;

    private MainQuestCategoryEnum category;

}
