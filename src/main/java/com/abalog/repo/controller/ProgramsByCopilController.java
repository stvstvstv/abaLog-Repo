package com.abalog.repo.controller;


import com.abalog.repo.dto.ProgramByCopilDTO;
import com.abalog.repo.service.ProgramByCopilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/programbycopil")
public class ProgramsByCopilController {

	@Autowired
	private ProgramByCopilService programByCopilService;

	@GetMapping("/{copilid}/{programid}")
	public ResponseEntity<ProgramByCopilDTO> findOne(@PathVariable String copilid, @PathVariable String programid) {

		ProgramByCopilDTO dto = programByCopilService.findOne(copilid, programid);
		if (dto == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(dto);
		}
	}
}
