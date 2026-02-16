package com.splash.task.controller;

import com.splash.task.dto.MainQuestDTO;
import com.splash.task.mapper.MainQuestMapper;
import com.splash.task.model.MainQuestEntity;
import com.splash.task.service.MainQuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quests")
@RequiredArgsConstructor
public class MainQuestController {

    private final MainQuestService service;
    private final MainQuestMapper mapper;

    @PostMapping
    public ResponseEntity<MainQuestEntity> createQuest(@RequestBody MainQuestDTO quest) {
        MainQuestEntity savedQuest = service.createQuest(mapper.toEntity(quest));
        return ResponseEntity.ok(savedQuest);
    }

    @GetMapping
    public ResponseEntity<List<MainQuestEntity>> getAllQuests() {
        return ResponseEntity.ok(service.getAllQuests());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuest(@PathVariable Long id) {
        service.deleteQuest(id);
        return ResponseEntity.noContent().build();
    }

}