package com.splash.task.controller;

import com.splash.task.dto.BookmarkDTO;
import com.splash.task.mapper.BookmarkMapper;
import com.splash.task.model.BookmarkEntity;
import com.splash.task.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService service;
    private final BookmarkMapper mapper;

    @GetMapping
    public ResponseEntity<List<BookmarkEntity>> getAllBookmarks() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookmarkEntity>> getBookmarksByName(@RequestParam String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @PostMapping
    public ResponseEntity<BookmarkEntity> createBookmark(@RequestBody BookmarkDTO bookmark) {
        BookmarkEntity savedBookmark = service.create(mapper.toEntity(bookmark));
        return ResponseEntity.ok(savedBookmark);
    }

    @PutMapping
    public ResponseEntity<BookmarkEntity> updateBookmark(@RequestBody BookmarkDTO bookmark) {
        BookmarkEntity updatedBookmark = service.update(mapper.toEntity(bookmark));
        return ResponseEntity.ok(updatedBookmark);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookmark(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}