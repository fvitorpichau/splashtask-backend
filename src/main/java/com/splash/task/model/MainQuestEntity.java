package com.splash.task.model;

import com.splash.task.enumerators.SideQuestFinishingStateEnum;
import com.splash.task.enumerators.SideQuestUrgencyLevelEnum;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "main_quest")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MainQuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "urgency_level")
    private SideQuestUrgencyLevelEnum urgencyLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private SideQuestFinishingStateEnum state;

}