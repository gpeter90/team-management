package com.bredex.teammanagement.domain.service;

import com.bredex.teammanagement.domain.dto.TeamRestDto;
import com.bredex.teammanagement.domain.mapper.TeamDomainMapper;
import com.bredex.teammanagement.persistence.dto.TeamDomainDto;
import com.bredex.teammanagement.persistence.service.TeamPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamRestService {

    @Autowired
    TeamPersistenceService teamPersistenceService;

    @Autowired
    TeamDomainMapper mapper;
    public List<TeamRestDto> getTeamList() {
        List<TeamDomainDto> domainDto = teamPersistenceService.getTeams();
        return domainDto.stream().map(domain -> mapper.domainToRest(domain)).collect(Collectors.toList());
    }

    public TeamRestDto findTeamById(Long id) {
        TeamDomainDto domainDto = teamPersistenceService.findTeam(id);
        return mapper.domainToRest(domainDto);
    }

    public void addNewTeam(TeamRestDto teamRestDto) {
        TeamDomainDto domainDto = mapper.restToDomain(teamRestDto);
        teamPersistenceService.saveTeam(domainDto);
    }

    public void modifyTeam(TeamRestDto teamRestDto, Long id) {
        TeamDomainDto domainDto = mapper.restToDomain(teamRestDto);
        teamPersistenceService.updateTeam(domainDto, id);
    }

    public void deleteTeam(TeamRestDto teamRestDto) {
        TeamDomainDto domainDto = mapper.restToDomain(teamRestDto);
        teamPersistenceService.removeTeam(domainDto);
    }
}
