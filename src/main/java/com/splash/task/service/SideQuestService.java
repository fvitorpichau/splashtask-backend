package com.splash.task.service;

import com.splash.task.enumerators.SideQuestFinishingStateEnum;
import com.splash.task.model.SideQuestEntity;
import com.splash.task.repository.SideQuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SideQuestService {

    private final SideQuestRepository repository;

    public List<SideQuestEntity> findAllActive() {
        return repository.findByStateInAndParentIsNull(Arrays.asList(
                SideQuestFinishingStateEnum.TO_BE_DONE,
                SideQuestFinishingStateEnum.DOING
        ));
    }

    public long countCompleted() {
        return repository.countByState(SideQuestFinishingStateEnum.DONE);
    }

    @Transactional
    public SideQuestEntity create(SideQuestEntity quest) {
        return repository.save(quest);
    }

    @Transactional
    public SideQuestEntity update(SideQuestEntity quest, Long parentId) {
        if (parentId != null) {
            SideQuestEntity parent = repository.findById(parentId)
                    .orElseThrow(() -> new RuntimeException("Parent not found"));
            quest.setParent(parent);
        } else if (quest.getId() != null) {
            repository.findById(quest.getId()).ifPresent(existing -> {
                quest.setParent(existing.getParent());
            });
        }

        SideQuestEntity updated = repository.save(quest);
        checkParentCompletion(updated.getParent());
        return updated;
    }

    private void checkParentCompletion(SideQuestEntity parent) {
        if (parent == null) return;

        boolean allDone = parent.getSubQuests().stream()
                .allMatch(sq -> sq.getState() == SideQuestFinishingStateEnum.DONE);

        if (allDone && !parent.getSubQuests().isEmpty()) {
            parent.setState(SideQuestFinishingStateEnum.DONE);
            repository.save(parent);
            checkParentCompletion(parent.getParent());
        }
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
        List<SideQuestEntity> quests = repository.findAllById(ids);
        quests.forEach(q -> {
            q.setState(SideQuestFinishingStateEnum.DONE);
            checkParentCompletion(q.getParent());
        });
        repository.saveAll(quests);
    }

    @Transactional
    public void revertMultipleStatus(List<Long> ids) {
        List<SideQuestEntity> quests = repository.findAllById(ids);
        quests.forEach(q -> {
            q.setState(SideQuestFinishingStateEnum.TO_BE_DONE);
            revertParentCompletion(q.getParent());
        });
        repository.saveAll(quests);
    }

    private void revertParentCompletion(SideQuestEntity parent) {
        if (parent == null) return;
        if (parent.getState() == SideQuestFinishingStateEnum.DONE) {
            parent.setState(SideQuestFinishingStateEnum.TO_BE_DONE);
            repository.save(parent);
            revertParentCompletion(parent.getParent());
        }
    }

    @Transactional
    public SideQuestEntity addSubQuest(Long parentId, SideQuestEntity subQuest) {
        SideQuestEntity parent = repository.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent not found"));
        
        subQuest.setParent(parent);
        SideQuestEntity saved = repository.save(subQuest);
        
        return saved;
    }
}