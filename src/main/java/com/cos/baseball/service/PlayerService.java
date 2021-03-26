package com.cos.baseball.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.player.PlayerRepository;
import com.cos.baseball.web.dto.PositionRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {

	private final PlayerRepository playerRepository;
	private final EntityManager em;
	
	@Transactional
	public void 플레이어등록(Player player) {
		playerRepository.save(player);
	}
	
	@Transactional(readOnly = true)
	public List<Player> 선수목록(){
		return playerRepository.findAll();
	}
	
	@Transactional
	public void 선수삭제(int id) {
		playerRepository.deleteById(id);
	}
	
	@Transactional
	public List<PositionRespDto> 포지션별선수리스트(){
		StringBuffer sb = new StringBuffer(); // 여러명에서 같이 쓸 때는 버퍼 아닐때는 빌더
		sb.append("SELECT ");
		sb.append("position, ");
		sb.append("MAX(IF(teamId = 1, name, \"\")) kia, ");
		sb.append("MAX(IF(teamId = 2, name, \"\")) nc, ");
		sb.append("MAX(IF(teamId = 3, name, \"\")) lotte ");
		sb.append("FROM player ");
		sb.append("GROUP BY position ");
		Query q = em.createNativeQuery(sb.toString());
		JpaResultMapper result = new JpaResultMapper();
		List<PositionRespDto> resultList = result.list(q, PositionRespDto.class);
		return resultList;
	}
}
