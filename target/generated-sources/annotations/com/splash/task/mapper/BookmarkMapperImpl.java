package com.splash.task.mapper;

import com.splash.task.dto.BookmarkDTO;
import com.splash.task.model.BookmarkEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-23T20:08:54-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.8 (Homebrew)"
)
@Component
public class BookmarkMapperImpl implements BookmarkMapper {

    @Override
    public BookmarkEntity toEntity(BookmarkDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BookmarkEntity bookmarkEntity = new BookmarkEntity();

        bookmarkEntity.setId( dto.getId() );
        bookmarkEntity.setName( dto.getName() );
        bookmarkEntity.setUrl( dto.getUrl() );

        return bookmarkEntity;
    }

    @Override
    public BookmarkDTO toDto(BookmarkEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BookmarkDTO bookmarkDTO = new BookmarkDTO();

        bookmarkDTO.setId( entity.getId() );
        bookmarkDTO.setName( entity.getName() );
        bookmarkDTO.setUrl( entity.getUrl() );

        return bookmarkDTO;
    }
}
