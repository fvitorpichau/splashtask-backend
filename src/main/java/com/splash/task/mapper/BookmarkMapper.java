package com.splash.task.mapper;

import com.splash.task.dto.BookmarkDTO;
import com.splash.task.model.BookmarkEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BookmarkMapper {

    BookmarkEntity toEntity(BookmarkDTO dto);

    BookmarkDTO toDto(BookmarkEntity entity);

}