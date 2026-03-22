package com.splash.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.splash.task.enumerators.SideQuestDurationEnum;
import com.splash.task.enumerators.SideQuestFinishingStateEnum;
import com.splash.task.enumerators.SideQuestUrgencyLevelEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "side_quest")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SideQuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private SideQuestFinishingStateEnum state;

    @Enumerated(EnumType.STRING)
    @Column(name = "urgency", nullable = false)
    private SideQuestUrgencyLevelEnum urgency;

    @Enumerated(EnumType.STRING)
    @Column(name = "duration", nullable = false)
    private SideQuestDurationEnum duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    @ToString.Exclude
    private SideQuestEntity parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SideQuestEntity> subQuests = new ArrayList<>();

}