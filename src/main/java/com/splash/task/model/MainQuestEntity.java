package com.splash.task.model;

import com.splash.task.enumerators.SideQuestFinishingStateEnum;
import com.splash.task.enumerators.SideQuestUrgencyLevelEnum;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainQuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private SideQuestUrgencyLevelEnum urgencyLevel;

    @Enumerated(EnumType.STRING)
    private SideQuestFinishingStateEnum state;

}