package com.bredex.teammanagement.domain.service;

import com.bredex.teammanagement.domain.dto.TeamDomainDto;
import com.bredex.teammanagement.domain.entity.Team;
import com.bredex.teammanagement.domain.exception.NoTeamFoundException;
import com.bredex.teammanagement.domain.mapper.TeamDomainMapper;
import com.bredex.teammanagement.domain.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamDomainService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamDomainMapper mapper;

    public List<TeamDomainDto> getTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(team -> mapper.entityToDto(team)).collect(Collectors.toList());
    }

    public TeamDomainDto findTeam(Long id) {
        Optional<Team> optionalTeam = teamRepository.findById(id);

        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();
            return mapper.entityToDto(team);
        } else {
            throw new NoTeamFoundException();
        }
    }

    @Transactional
    public void saveTeam(TeamDomainDto domainDto) {
        Team team = mapper.dtoToEntity(domainDto);
        teamRepository.save(team);
    }

    @Transactional
    public void updateTeam(TeamDomainDto domainDto, Long id) throws NoTeamFoundException {
        Team team = mapper.dtoToEntity(domainDto);
        Optional<Team> teamFound = teamRepository.findById(id);

        if (teamFound.isPresent()) {
            team.setId(id);
            teamRepository.save(team);
        } else {
            throw new NoTeamFoundException();
        }
    }

    @Transactional
    public void removeTeam(TeamDomainDto domainDto) {
        Team team = mapper.dtoToEntity(domainDto);
        Optional<Team> teamFound = teamRepository.findByName(team.getName());

        if (teamFound.isPresent()) {
            teamRepository.delete(team);
        } else {
            throw new NoTeamFoundException();
        }
    }
}
