package com.splash.task.mapper;

import com.splash.task.dto.SideQuestDTO;
import com.splash.task.model.SideQuestEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SideQuestMapper {

    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "subQuests", ignore = true)
    SideQuestEntity toEntity(SideQuestDTO dto);

    @Mapping(target = "parentId", source = "parent.id")
    SideQuestDTO toDto(SideQuestEntity entity);

}