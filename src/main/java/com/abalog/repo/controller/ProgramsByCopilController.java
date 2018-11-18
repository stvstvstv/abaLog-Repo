package com.abalog.repo.controller;


import com.abalog.repo.domain.ProgramByCopil;
import com.abalog.repo.domain.ProgramByCopilPrimaryKey;
import com.abalog.repo.dto.ProgramByCopilDTO;
import com.abalog.repo.service.ProgramByCopilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@PutMapping("/{copilid}/{programid}")
	public ResponseEntity<String> saveBatch(@PathVariable String copilid, @PathVariable String programid,
											@RequestParam String name, @RequestParam Boolean mastered) {

		programByCopilService.saveBatch(ProgramByCopil.builder().primaryKey(
				ProgramByCopilPrimaryKey.builder()
						.copilid(copilid).programid(programid)
						.build())
				.nume(name).mastered(mastered)
				.build());
		return ResponseEntity.ok().body("worked");
	}
}
