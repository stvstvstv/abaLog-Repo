package com.abalog.repo.service;

import com.abalog.repo.domain.Program;
import com.abalog.repo.repository.ProgramRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProgramService {

    @Autowired
    ProgramRepository programRepository;

    public final Program findOneProgram(String programid){
        return programRepository.findOne(programid);
    }

    //TODO: adauga copil, findAll dupa copil !
    public final List<Program> findAllPrograms(){
        return programRepository.findAll();
    }

}
