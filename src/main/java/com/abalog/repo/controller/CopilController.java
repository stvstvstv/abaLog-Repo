package com.abalog.repo.controller;

import com.abalog.repo.domain.Copil;
import com.abalog.repo.service.CopilService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/copil")
@Api(tags = "Copil Data")
@Slf4j
public class CopilController {

	@Autowired
	CopilService copilService;

	@GetMapping("/{copilid}")
	public ResponseEntity<?> findCopilbyId(@PathVariable String copilid) {
		Copil copil = copilService.findOneCopil(copilid);
		if (copil == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok().body(copil);
		}
	}

	@GetMapping("/")
	public final List<Copil> findAll() {
		return copilService.findAll();
	}
}
