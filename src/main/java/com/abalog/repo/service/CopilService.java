package com.abalog.repo.service;

import com.abalog.repo.domain.Copil;
import com.abalog.repo.repository.CopilRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CopilService {

	@Autowired
	CopilRepository copilRepository;

	public final Copil findOneCopil(String copilid) {
		return copilRepository.findCopilByCopilID(copilid);
	}

	public final List<Copil> findAll() {
		return copilRepository.findAll();
	}

}
