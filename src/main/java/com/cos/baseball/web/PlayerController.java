package com.cos.baseball.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.field.Field;
import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.service.PlayerService;
import com.cos.baseball.service.TeamService;
import com.cos.baseball.web.dto.CMRespDto;
import com.cos.baseball.web.dto.PositionRespDto;
import com.cos.baseball.web.dto.player.PlayerSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {

	private final PlayerService playerService;
	private final TeamService teamSerivce;
	
	@GetMapping("/player/playerRegForm")
	public String regForm(Model model) {
		List<Team> teams = teamSerivce.팀목록();
		model.addAttribute("teams", teams);
		return "player/playerReg";
	}
	
	@PostMapping("/player")
	public String save(PlayerSaveReqDto playerSaveReqDto) {
		Player playerEntity = playerSaveReqDto.toEntity();
		Team teamEntity = teamSerivce.팀한개찾기(playerSaveReqDto.getTeamId());
		playerEntity.setTeam(teamEntity);
		playerService.플레이어등록(playerEntity);
		return "redirect:/player";
	}
	
	@GetMapping({"/player"})
	public String findAll(Model model) {
		List<Player> players = playerService.선수목록();
		model.addAttribute("players", players);
		return "player/playerList";
	}
	
	@DeleteMapping("/player/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable int id) {
		playerService.선수삭제(id);
		return new CMRespDto<>(1,null);
	}
	
	@GetMapping("/player/positionList")
	public String positionList(Model model) {
		List<PositionRespDto> dtos = playerService.포지션별선수리스트();
		model.addAttribute("dtos", dtos);
		return "player/positionList";
	}
	
}
