package com.splash.task.repository;

import com.splash.task.model.MainQuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainQuestRepository extends JpaRepository<MainQuestEntity, Long> {
}
