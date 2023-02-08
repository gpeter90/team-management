package com.bredex.teammanagement.rest.mapper;

import com.bredex.teammanagement.rest.dto.TeamRestDto;
import com.bredex.teammanagement.domain.dto.TeamDomainDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamRestMapper {
    TeamRestDto domainToRest(TeamDomainDto domainDto);

    TeamDomainDto restToDomain(TeamRestDto restDto);
}
