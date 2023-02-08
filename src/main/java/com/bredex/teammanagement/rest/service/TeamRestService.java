package com.bredex.teammanagement.rest.service;

import com.bredex.teammanagement.rest.dto.TeamRestDto;
import com.bredex.teammanagement.rest.mapper.TeamRestMapper;
import com.bredex.teammanagement.domain.dto.TeamDomainDto;
import com.bredex.teammanagement.domain.service.TeamDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamRestService {

    @Autowired
    TeamDomainService teamDomainService;

    @Autowired
    TeamRestMapper mapper;
    public List<TeamRestDto> getTeamList() {
        List<TeamDomainDto> domainDto = teamDomainService.getTeams();
        return domainDto.stream().map(domain -> mapper.domainToRest(domain)).collect(Collectors.toList());
    }

    public TeamRestDto findTeamById(Long id) {
        TeamDomainDto domainDto = teamDomainService.findTeam(id);
        return mapper.domainToRest(domainDto);
    }

    public void addNewTeam(TeamRestDto teamRestDto) {
        TeamDomainDto domainDto = mapper.restToDomain(teamRestDto);
        teamDomainService.saveTeam(domainDto);
    }

    public void modifyTeam(TeamRestDto teamRestDto, Long id) {
        TeamDomainDto domainDto = mapper.restToDomain(teamRestDto);
        teamDomainService.updateTeam(domainDto, id);
    }

    public void deleteTeam(TeamRestDto teamRestDto) {
        TeamDomainDto domainDto = mapper.restToDomain(teamRestDto);
        teamDomainService.removeTeam(domainDto);
    }
}
