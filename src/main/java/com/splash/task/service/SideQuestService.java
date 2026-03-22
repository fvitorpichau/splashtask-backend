package com.splash.task.service;

import com.splash.task.enumerators.SideQuestFinishingStateEnum;
import com.splash.task.model.SideQuestEntity;
import com.splash.task.repository.SideQuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SideQuestService {

    private final SideQuestRepository repository;

    public List<SideQuestEntity> findAllActive() {
        return repository.findByStateIn(Arrays.asList(
                SideQuestFinishingStateEnum.TO_BE_DONE,
                SideQuestFinishingStateEnum.DOING
        ));
    }

    public SideQuestEntity create(SideQuestEntity quest) {
        return repository.save(quest);
    }

    public SideQuestEntity update(SideQuestEntity quest) {
        return repository.save(quest);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void deleteMultiple(List<Long> ids) {
        repository.deleteAllById(ids);
    }

    public void markMultipleAsDone(List<Long> ids) {
        List<SideQuestEntity> quests = repository.findAllById(ids);
        quests.forEach(q -> q.setState(SideQuestFinishingStateEnum.DONE));
        repository.saveAll(quests);
    }
}