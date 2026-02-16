package com.splash.task.mapper;

import com.splash.task.dto.MainQuestDTO;
import com.splash.task.model.MainQuestEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MainQuestMapper {

    MainQuestEntity toEntity(MainQuestDTO dto);

    MainQuestDTO toDto(MainQuestEntity entity);

}