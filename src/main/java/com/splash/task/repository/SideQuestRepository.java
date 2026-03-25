package com.splash.task.repository;

import com.splash.task.enumerators.SideQuestFinishingStateEnum;
import com.splash.task.model.SideQuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SideQuestRepository extends JpaRepository<SideQuestEntity, Long> {

    List<SideQuestEntity> findByStateInAndParentIsNull(List<SideQuestFinishingStateEnum> states);

    long countByState(SideQuestFinishingStateEnum state);

    @Query("SELECT COALESCE(SUM(q.weight), 0) FROM SideQuestEntity q WHERE q.state = com.splash.task.enumerators.SideQuestFinishingStateEnum.DONE")
    long sumWeightByStateDone();

}