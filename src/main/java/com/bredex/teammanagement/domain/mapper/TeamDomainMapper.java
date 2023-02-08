package com.bredex.teammanagement.domain.mapper;

import com.bredex.teammanagement.domain.dto.TeamDomainDto;
import com.bredex.teammanagement.domain.entity.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamDomainMapper {
    TeamDomainDto entityToDto(Team team);

    Team dtoToEntity(TeamDomainDto teamDomainDto);
}
