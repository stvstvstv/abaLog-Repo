package com.abalog.repo.repository;

import com.abalog.repo.domain.Program;
import com.abalog.repo.domain.ProgramByCopil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraBatchOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

public class CustomProgramByCopilRepositoryImpl implements CustomProgramByCopilRepository {

	@Autowired
	CassandraTemplate template;

	@Autowired
	ProgramRepository programRepository;

	@Override
	public void saveBatch2(ProgramByCopil programByCopil) {
		final CassandraBatchOperations batchOperations = template.batchOps();
		insertitem(programByCopil, batchOperations);
		batchOperations.insert(programByCopil);
		batchOperations.execute();
	}

	private void insertitem(ProgramByCopil programByCopil, final CassandraBatchOperations batchOperations) {
		batchOperations.insert(
				Program.builder().programid(programByCopil.getPrimaryKey().getProgramid())
						.mastered(programByCopil.getMastered())
						.name(programByCopil.getNume())
						.build()
		);
	}
}
