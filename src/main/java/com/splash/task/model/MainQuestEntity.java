package com.splash.task.model;

import com.splash.task.enumerators.MainQuestCategoryEnum;
import com.splash.task.enumerators.SideQuestFinishingStateEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "current_value", nullable = false)
    private Integer current;

    @Column(name = "target_value", nullable = false)
    private Integer target;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private SideQuestFinishingStateEnum state;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private MainQuestCategoryEnum category = MainQuestCategoryEnum.MIND;

}
