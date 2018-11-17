package com.abalog.repo.service;

import com.abalog.repo.dto.ProgramByCopilDTO;
import com.abalog.repo.dto.ProgramByCopilDTOMapper;
import com.abalog.repo.repository.ProgramByCopilRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProgramByCopilService {

	@Autowired
	ProgramByCopilRepository programByCopilRepository;

	@Autowired
	ProgramByCopilDTOMapper mapper;

	public final ProgramByCopilDTO findOne(String copilid, String programid) {
		return mapper.toDto(programByCopilRepository.findOne(copilid, programid));
	}


}
