package com.splash.task.controller;

import com.splash.task.dto.MainQuestDTO;
import com.splash.task.mapper.MainQuestMapper;
import com.splash.task.model.MainQuestEntity;
import com.splash.task.service.MainQuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/main-quests")
@RequiredArgsConstructor
public class MainQuestController {

    private final MainQuestService service;
    private final MainQuestMapper mapper;

    @GetMapping
    public ResponseEntity<List<MainQuestDTO>> getAllActiveMainQuests() {
        List<MainQuestDTO> dtos = service.findAllActive().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    public ResponseEntity<MainQuestDTO> createMainQuest(@RequestBody MainQuestDTO dto) {
        MainQuestEntity saved = service.create(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDto(saved));
    }

    @PutMapping
    public ResponseEntity<MainQuestDTO> updateMainQuest(@RequestBody MainQuestDTO dto) {
        MainQuestEntity updated = service.update(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMainQuest(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/bulk-delete")
    public ResponseEntity<Void> bulkDelete(@RequestBody List<Long> ids) {
        service.deleteMultiple(ids);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/bulk-done")
    public ResponseEntity<Void> bulkDone(@RequestBody List<Long> ids) {
        service.markMultipleAsDone(ids);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/bulk-revert")
    public ResponseEntity<Void> bulkRevert(@RequestBody List<Long> ids) {
        service.revertMultipleStatus(ids);
        return ResponseEntity.noContent().build();
    }
}
