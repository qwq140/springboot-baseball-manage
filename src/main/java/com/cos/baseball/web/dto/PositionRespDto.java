package com.cos.baseball.web.dto;

import java.util.List;

import com.cos.baseball.domain.team.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PositionRespDto {
	private String position;
	private String kia;
	private String nc;
	private String lotte;
}
