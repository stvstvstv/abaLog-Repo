package com.abalog.repo.controller;

import com.abalog.repo.domain.Program;
import com.abalog.repo.service.ProgramService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/programs")
@Api(tags = "Repository Program data")
@Slf4j
public class ProgramsController {

    @Autowired
    ProgramService programService;


    @GetMapping("/{programid}")
    public ResponseEntity<?> findOneProgram(@PathVariable String programid){

        Program program = programService.findOneProgram(programid);
        if (program == null){
            return ResponseEntity.noContent().header("No content").build();
        }else {
            return ResponseEntity.ok().header("header").body(program);
        }
    }

    @GetMapping("/")
    public final List<Program> findAllPrograms(){
        return programService.findAllPrograms();
    }

	@PutMapping("/{programid}")
	public void addProgram(@PathVariable String programid, @RequestParam String name, @RequestParam Boolean mastered) {
		programService.addProgram(programid, name, mastered);
	}
}
