package com.cos.baseball.web.dto.team;

import com.cos.baseball.domain.field.Field;
import com.cos.baseball.domain.team.Team;

import lombok.Data;

@Data
public class TeamSaveReqDto {
	
	private String name;
	private Integer fieldId;
	
	public Team toEntity() {
		return Team.builder()
				.name(name)				
				.build();
	}

}
