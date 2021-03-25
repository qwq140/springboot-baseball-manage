package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.field.Field;
import com.cos.baseball.domain.field.FieldRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FieldService {

	private final FieldRepository fieldRepository;
	
	@Transactional
	public void 구장등록(Field field) {
		fieldRepository.save(field);
	}
	
	@Transactional(readOnly = true)
	public List<Field> 구장목록(){
		return fieldRepository.findAll();
	}
	
	@Transactional
	public void 구장삭제(int id) {
		fieldRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public Field 구장한개찾기(int fieldId) {
		Field fieldEntity = fieldRepository.findById(fieldId).get();
		return fieldEntity;
	}
	
}
