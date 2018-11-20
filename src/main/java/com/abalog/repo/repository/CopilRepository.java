package com.abalog.repo.repository;

import com.abalog.repo.domain.Copil;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface CopilRepository extends CassandraRepository<Copil, String> {

	@Query("Select * from copil where copilid=?0")
	Copil findCopilByCopilID(String copilid);

	@Query("SELECT * FROM copil")
	List<Copil> findAll();
}
