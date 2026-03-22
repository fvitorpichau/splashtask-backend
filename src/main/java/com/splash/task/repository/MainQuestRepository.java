package com.splash.task.repository;

import com.splash.task.enumerators.SideQuestFinishingStateEnum;
import com.splash.task.model.MainQuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainQuestRepository extends JpaRepository<MainQuestEntity, Long> {

    List<MainQuestEntity> findByStateIn(List<SideQuestFinishingStateEnum> states);

}