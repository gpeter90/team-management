package com.bredex.teammanagement.persistence.mapper;

import com.bredex.teammanagement.persistence.dto.TeamDomainDto;
import com.bredex.teammanagement.persistence.entity.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    TeamDomainDto entityToDto(Team team);

    Team dtoToEntity(TeamDomainDto teamDomainDto);
}
