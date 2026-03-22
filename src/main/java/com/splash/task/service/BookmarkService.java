package com.splash.task.service;

import com.splash.task.model.BookmarkEntity;
import com.splash.task.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository repository;

    public List<BookmarkEntity> findAll() {
        return repository.findAll();
    }

    public List<BookmarkEntity> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public BookmarkEntity create(BookmarkEntity bookmark) {
        return repository.save(bookmark);
    }

    public BookmarkEntity update(BookmarkEntity bookmark) {
        return repository.save(bookmark);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}