package com.cos.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.field.Field;
import com.cos.baseball.service.FieldService;
import com.cos.baseball.web.dto.CMRespDto;
import com.cos.baseball.web.dto.field.FieldSaveReqDto;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class FieldController {
	private final FieldService fieldService;
	
	@GetMapping("/field/fieldRegForm")
	public String regForm() {
		return "field/fieldReg";
	}
	
	@PostMapping("/field")
	public String save(FieldSaveReqDto fieldSaveReqDto) {
		Field fieldEntity = fieldSaveReqDto.toEntity();
		fieldService.구장등록(fieldEntity);
		return "redirect:/field";
	}
	
	@GetMapping({"/field","/"})
	public String findAll(Model model) {
		List<Field> fields = fieldService.구장목록();
		model.addAttribute("fields", fields);
		return "field/fieldList";
	}
	
	@DeleteMapping("/field/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable int id) {
		fieldService.구장삭제(id);
		return new CMRespDto<>(1,null);
	}
}
