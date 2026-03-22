package com.splash.task.service;

import com.splash.task.enumerators.SideQuestFinishingStateEnum;
import com.splash.task.model.MainQuestEntity;
import com.splash.task.repository.MainQuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainQuestService {

    private final MainQuestRepository repository;

    public List<MainQuestEntity> findAllActive() {
        return repository.findByStateIn(Arrays.asList(
                SideQuestFinishingStateEnum.TO_BE_DONE,
                SideQuestFinishingStateEnum.DOING
        ));
    }

    @Transactional
    public MainQuestEntity create(MainQuestEntity quest) {
        if (quest.getState() == null) quest.setState(SideQuestFinishingStateEnum.TO_BE_DONE);
        return repository.save(quest);
    }

    @Transactional
    public MainQuestEntity update(MainQuestEntity quest) {
        return repository.save(quest);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void deleteMultiple(List<Long> ids) {
        repository.deleteAllById(ids);
    }

    @Transactional
    public void markMultipleAsDone(List<Long> ids) {
        List<MainQuestEntity> quests = repository.findAllById(ids);
        quests.forEach(q -> q.setState(SideQuestFinishingStateEnum.DONE));
        repository.saveAll(quests);
    }

    @Transactional
    public void revertMultipleStatus(List<Long> ids) {
        List<MainQuestEntity> quests = repository.findAllById(ids);
        quests.forEach(q -> q.setState(SideQuestFinishingStateEnum.TO_BE_DONE));
        repository.saveAll(quests);
    }
}