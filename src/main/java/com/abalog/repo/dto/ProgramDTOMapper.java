package com.abalog.repo.dto;


import com.abalog.repo.domain.Program;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProgramDTOMapper {

	@Autowired
	private ObjectMapper mapper;

	public ProgramDTO toDTO(Program program) {
		if (program == null) {
			return null;
		} else try {
			return ProgramDTO.builder()
					.name(program.getName())
					.mastered(program.getMastered())
					.build();
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

//	public Program toPojo(ProgramDTO dto){
//		if (dto==null){
//			return null;
//		}else try {
//			return Program.builder().mastered(dto.getMastered())
//					.name(dto.getName())
//					.programid(dto)
//					.build()
//		}
//	}
}
