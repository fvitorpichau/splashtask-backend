package com.splash.task.mapper;

import com.splash.task.dto.MainQuestDTO;
import com.splash.task.model.MainQuestEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-23T20:08:54-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.8 (Homebrew)"
)
@Component
public class MainQuestMapperImpl implements MainQuestMapper {

    @Override
    public MainQuestEntity toEntity(MainQuestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MainQuestEntity mainQuestEntity = new MainQuestEntity();

        mainQuestEntity.setId( dto.getId() );
        mainQuestEntity.setName( dto.getName() );
        mainQuestEntity.setUrgencyLevel( dto.getUrgencyLevel() );
        mainQuestEntity.setState( dto.getState() );

        return mainQuestEntity;
    }

    @Override
    public MainQuestDTO toDto(MainQuestEntity entity) {
        if ( entity == null ) {
            return null;
        }

        MainQuestDTO mainQuestDTO = new MainQuestDTO();

        mainQuestDTO.setId( entity.getId() );
        mainQuestDTO.setName( entity.getName() );
        mainQuestDTO.setUrgencyLevel( entity.getUrgencyLevel() );
        mainQuestDTO.setState( entity.getState() );

        return mainQuestDTO;
    }
}
