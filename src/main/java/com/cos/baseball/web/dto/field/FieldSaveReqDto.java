package com.cos.baseball.web.dto.field;

import com.cos.baseball.domain.field.Field;

import lombok.Data;

@Data
public class FieldSaveReqDto {
	private String name;
	
	public Field toEntity() {
		return Field.builder()
				.name(name)
				.build();
	}
}
