package com.abalog.repo.dto;

import com.abalog.repo.domain.ProgramByCopil;
import com.abalog.repo.domain.ProgramByCopilPrimaryKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProgramByCopilDTOMapper {

	@Autowired
	private ObjectMapper mapper;

	public ProgramByCopilDTO toDto(ProgramByCopil programByCopil) {
		if (programByCopil == null) {
			return null;
		} else try {
			return ProgramByCopilDTO.builder()
					.mastered(programByCopil.getMastered())
					.name(programByCopil.getNume())
					.build();
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	public ProgramByCopil toPojo(ProgramByCopilDTO dto, String copilid, String programid) {
		if (dto == null) {
			return null;
		} else try {
			return ProgramByCopil.builder()
					.primaryKey(ProgramByCopilPrimaryKey.builder()
							.copilid(copilid).programid(programid).build())
					.mastered(dto.getMastered())
					.nume(dto.getName())
					.build();
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}


}
