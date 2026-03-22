package com.splash.task.repository;

import com.splash.task.enumerators.SideQuestFinishingStateEnum;
import com.splash.task.model.SideQuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SideQuestRepository extends JpaRepository<SideQuestEntity, Long> {

    List<SideQuestEntity> findByStateIn(List<SideQuestFinishingStateEnum> states);

}