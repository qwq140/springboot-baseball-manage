package com.cos.baseball.web;

import java.util.ArrayList;
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
import com.cos.baseball.service.FieldService;
import com.cos.baseball.service.PlayerService;
import com.cos.baseball.service.TeamService;
import com.cos.baseball.web.dto.CMRespDto;
import com.cos.baseball.web.dto.player.PlayerSaveReqDto;
import com.cos.baseball.web.dto.team.TeamSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamController {

	private final TeamService teamService;
	private final FieldService fieldService;
	
	@GetMapping("/team/teamRegForm")
	public String regForm(Model model) {
		List<Field> fieldList = new ArrayList<>();
		List<Field> fields = fieldService.구장목록();
		for (Field field : fields) {
			if(field.getTeam()==null) {
				fieldList.add(field);
			}
		}
		
		model.addAttribute("fields", fieldList);
		return "team/teamReg";
	}
	
	@PostMapping("/team")
	public String save(TeamSaveReqDto teamSaveReqDto) {
		Team teamEntity = teamSaveReqDto.toEntity();
		Field fieldEntity = fieldService.구장한개찾기(teamSaveReqDto.getFieldId());
		teamEntity.setField(fieldEntity);
		teamService.팀등록(teamEntity);
		return "redirect:/team";
	}
	
	@GetMapping("/team")
	public String findAll(Model model) {
		List<Team> teams = teamService.팀목록();
		model.addAttribute("teams", teams);
		return "team/teamList";
	}
	
	@DeleteMapping("/team/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable int id) {
		teamService.팀삭제(id);
		return new CMRespDto<>(1,null);
	}
	
}
