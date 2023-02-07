package com.bredex.teammanagement.domain.controller;

import com.bredex.teammanagement.domain.dto.TeamRestDto;
import com.bredex.teammanagement.domain.service.TeamRestService;
import com.bredex.teammanagement.persistence.exception.NoTeamFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamRestController {

    @Autowired
    private TeamRestService teamRestService;

    @GetMapping("/teams")
    public List<TeamRestDto> getAllTeams() {
        return teamRestService.getTeamList();
    }

    @GetMapping("/team/{id}")
    public TeamRestDto getTeam(@PathVariable long id) {
        return teamRestService.findTeamById(id);
    }

    @PostMapping("/team/new")
    public void registerNewTeam(@RequestBody @NonNull TeamRestDto teamRestDto) {
        teamRestService.addNewTeam(teamRestDto);
    }

    @PutMapping("/team/modify/{id}")
    public void updateTeamStatus(@RequestBody @NonNull TeamRestDto teamRestDto, @PathVariable long id) {
        try {
            teamRestService.modifyTeam(teamRestDto, id);
        } catch (NoTeamFoundException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/team/delete")
    public void deleteExistingTeam(@RequestBody @NonNull TeamRestDto teamRestDto) {
        try {
            teamRestService.deleteTeam(teamRestDto);
        } catch (NoTeamFoundException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

}
