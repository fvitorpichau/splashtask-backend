package com.splash.task.mapper;

import com.splash.task.dto.SideQuestDTO;
import com.splash.task.model.SideQuestEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-22T15:26:03-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.8 (Homebrew)"
)
@Component
public class SideQuestMapperImpl implements SideQuestMapper {

    @Override
    public SideQuestEntity toEntity(SideQuestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SideQuestEntity sideQuestEntity = new SideQuestEntity();

        sideQuestEntity.setId( dto.getId() );
        sideQuestEntity.setName( dto.getName() );
        sideQuestEntity.setState( dto.getState() );
        sideQuestEntity.setUrgency( dto.getUrgency() );
        sideQuestEntity.setDuration( dto.getDuration() );

        return sideQuestEntity;
    }

    @Override
    public SideQuestDTO toDto(SideQuestEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SideQuestDTO sideQuestDTO = new SideQuestDTO();

        sideQuestDTO.setId( entity.getId() );
        sideQuestDTO.setName( entity.getName() );
        sideQuestDTO.setState( entity.getState() );
        sideQuestDTO.setUrgency( entity.getUrgency() );
        sideQuestDTO.setDuration( entity.getDuration() );

        return sideQuestDTO;
    }
}
