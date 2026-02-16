package com.splash.task.service;

import com.splash.task.model.MainQuestEntity;
import com.splash.task.repository.MainQuestRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainQuestService {

    private final MainQuestRepository repository;

    public MainQuestEntity createQuest(MainQuestEntity quest) {
        return repository.save(quest);
    }

    public List<MainQuestEntity> getAllQuests() {
        return repository.findAll();
    }

    public void deleteQuest(Long id) {
        repository.deleteById(id);
    }
}