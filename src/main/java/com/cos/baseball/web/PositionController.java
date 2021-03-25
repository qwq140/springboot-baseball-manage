package com.cos.baseball.web;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.baseball.web.dto.PositionRespDto;


@Controller
public class PositionController {

	@PersistenceContext
	private EntityManager em;
	
	@GetMapping("/position")
	public String findByPositionPivot(Model model){
		JpaResultMapper result = new JpaResultMapper();
		Query q = em.createNativeQuery("select position, MAX(IF(teamId = 5, name, \\\"\\\")) kia, MAX(IF(teamId = 6, name, \\\"\\\")) nc, MAX(IF(teamId = 7, name, \\\"\\\")) lotte FROM player GROUP BY position");
		List<PositionRespDto> resultList = result.list(q, PositionRespDto.class);
		model.addAttribute("positions", resultList);
		
		return "position/positionList";
		
	}
}
