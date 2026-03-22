package com.splash.task.mapper;

import com.splash.task.dto.SideQuestDTO;
import com.splash.task.model.SideQuestEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SideQuestMapper {

    SideQuestEntity toEntity(SideQuestDTO dto);

    SideQuestDTO toDto(SideQuestEntity entity);

}