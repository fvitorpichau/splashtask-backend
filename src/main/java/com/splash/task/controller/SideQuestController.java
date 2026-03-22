package com.splash.task.controller;

import com.splash.task.dto.SideQuestDTO;
import com.splash.task.mapper.SideQuestMapper;
import com.splash.task.model.SideQuestEntity;
import com.splash.task.service.SideQuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/side-quests")
@RequiredArgsConstructor
public class SideQuestController {

    private final SideQuestService service;
    private final SideQuestMapper mapper;

    @GetMapping
    public ResponseEntity<List<SideQuestEntity>> getAllActiveSideQuests() {
        return ResponseEntity.ok(service.findAllActive());
    }

    @PostMapping
    public ResponseEntity<SideQuestEntity> createSideQuest(@RequestBody SideQuestDTO dto) {
        SideQuestEntity saved = service.create(mapper.toEntity(dto));
        return ResponseEntity.ok(saved);
    }

    @PutMapping
    public ResponseEntity<SideQuestEntity> updateSideQuest(@RequestBody SideQuestDTO dto) {
        SideQuestEntity updated = service.update(mapper.toEntity(dto));
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSideQuest(@PathVariable Long id) {
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

}