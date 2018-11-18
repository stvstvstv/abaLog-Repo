package com.abalog.repo.repository;

import com.abalog.repo.domain.ProgramByCopil;
import com.abalog.repo.domain.ProgramByCopilPrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface ProgramByCopilRepository
		extends CassandraRepository<ProgramByCopil, ProgramByCopilPrimaryKey>, CustomProgramByCopilRepository {

	@Query("SELECT * FROM programbycopil WHERE copilid=?0 AND programid=?1")
	ProgramByCopil findOne(String copilid, String programid);

	@Query("SELECT * FROM programbycopil WHERE copilid=?0")
	List<ProgramByCopil> findAllByCopil(String copilid);

}
