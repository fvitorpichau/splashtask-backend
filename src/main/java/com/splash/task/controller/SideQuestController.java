package com.splash.task.controller;

import com.splash.task.dto.SideQuestDTO;
import com.splash.task.mapper.SideQuestMapper;
import com.splash.task.model.SideQuestEntity;
import com.splash.task.service.SideQuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/side-quests")
@RequiredArgsConstructor
public class SideQuestController {

    private final SideQuestService service;
    private final SideQuestMapper mapper;

    @GetMapping
    public ResponseEntity<List<SideQuestDTO>> getAllActiveSideQuests() {
        List<SideQuestDTO> dtos = service.findAllActive().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/count-done")
    public ResponseEntity<Long> getCountDone() {
        return ResponseEntity.ok(service.countCompleted());
    }

    @PostMapping
    public ResponseEntity<SideQuestDTO> createSideQuest(@RequestBody SideQuestDTO dto) {
        SideQuestEntity saved = service.create(mapper.toEntity(dto));
        return ResponseEntity.ok(mapper.toDto(saved));
    }

    @PutMapping
    public ResponseEntity<SideQuestDTO> updateSideQuest(@RequestBody SideQuestDTO dto) {
        SideQuestEntity updated = service.update(mapper.toEntity(dto), dto.getParentId());
        return ResponseEntity.ok(mapper.toDto(updated));
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

    @PostMapping("/bulk-revert")
    public ResponseEntity<Void> bulkRevert(@RequestBody List<Long> ids) {
        service.revertMultipleStatus(ids);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{parentId}/subquests")
    public ResponseEntity<SideQuestDTO> addSubQuest(@PathVariable Long parentId, @RequestBody SideQuestDTO subQuestDto) {
        SideQuestEntity saved = service.addSubQuest(parentId, mapper.toEntity(subQuestDto));
        return ResponseEntity.ok(mapper.toDto(saved));
    }

}