package com.betbull.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betbull.team.model.DefaultTeamResponse;
import com.betbull.team.model.MultiTeamRequest;
import com.betbull.team.model.MultiTeamResponse;
import com.betbull.team.service.TeamService;

@RestController
@RequestMapping("/api/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@PostMapping("/create")
	public DefaultTeamResponse createPlayer(@RequestBody MultiTeamRequest request) {
		return teamService.createTeam(request);
	}
	
	@GetMapping("/getteambyname")
	public MultiTeamResponse getTeamByName(@RequestParam("name") String name) {
		return teamService.getTeamByName(name);
	}
	
	@GetMapping("/getallteams")
	public MultiTeamResponse getAllTeams() {
		return teamService.getAllTeams();
	}
	
	@GetMapping("/getallactiveteams")
	public MultiTeamResponse getAllActiveTeams() {
		return teamService.getAllActiveTeams();
	}
	
	@GetMapping("/getallpassiveteams")
	public MultiTeamResponse getAllPassiveTeams() {
		return teamService.getAllPassiveTeams();
	}
	
	@PostMapping("/activate")
	public DefaultTeamResponse activateTeam(@RequestParam("id") Long id) {
		return teamService.activateTeamById(id);
	}
	
	@PostMapping("/passivate")
	public DefaultTeamResponse passivateTeam(@RequestParam("id") Long id) {
		return teamService.passivateTeamById(id);
	}
	
	@DeleteMapping("/deleteteambyid")
	public DefaultTeamResponse deleteTeamByName(@RequestParam("id") Long id){
		return teamService.deleteTeamById(id);
    }
	
	@DeleteMapping("/deletepassiveteams")
	public DefaultTeamResponse deletePassiveTeams(){
		return teamService.deleteAllPassiveTeams();
    }
}