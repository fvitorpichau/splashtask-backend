package com.splash.task.mapper;

import com.splash.task.dto.SideQuestDTO;
import com.splash.task.model.SideQuestEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-24T20:35:16-0300",
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
        sideQuestEntity.setWeight( dto.getWeight() );

        return sideQuestEntity;
    }

    @Override
    public SideQuestDTO toDto(SideQuestEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SideQuestDTO sideQuestDTO = new SideQuestDTO();

        sideQuestDTO.setParentId( entityParentId( entity ) );
        sideQuestDTO.setId( entity.getId() );
        sideQuestDTO.setName( entity.getName() );
        sideQuestDTO.setState( entity.getState() );
        sideQuestDTO.setUrgency( entity.getUrgency() );
        sideQuestDTO.setDuration( entity.getDuration() );
        sideQuestDTO.setWeight( entity.getWeight() );
        sideQuestDTO.setSubQuests( sideQuestEntityListToSideQuestDTOList( entity.getSubQuests() ) );

        return sideQuestDTO;
    }

    private Long entityParentId(SideQuestEntity sideQuestEntity) {
        if ( sideQuestEntity == null ) {
            return null;
        }
        SideQuestEntity parent = sideQuestEntity.getParent();
        if ( parent == null ) {
            return null;
        }
        Long id = parent.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<SideQuestDTO> sideQuestEntityListToSideQuestDTOList(List<SideQuestEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<SideQuestDTO> list1 = new ArrayList<SideQuestDTO>( list.size() );
        for ( SideQuestEntity sideQuestEntity : list ) {
            list1.add( toDto( sideQuestEntity ) );
        }

        return list1;
    }
}
