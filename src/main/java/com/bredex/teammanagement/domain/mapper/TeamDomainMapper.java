package com.bredex.teammanagement.domain.mapper;

import com.bredex.teammanagement.domain.dto.TeamRestDto;
import com.bredex.teammanagement.persistence.dto.TeamDomainDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamDomainMapper {
    TeamRestDto domainToRest(TeamDomainDto domainDto);

    TeamDomainDto restToDomain(TeamRestDto restDto);
}
