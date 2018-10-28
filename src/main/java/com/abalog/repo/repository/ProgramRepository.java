package com.abalog.repo.repository;

import com.abalog.repo.domain.Program;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface ProgramRepository extends CassandraRepository<Program, String> {

    @Query("SELECT * FROM program WHERE programid=?0")
    Program findOne(String programid);

    @Query("SELECT * FROM program")
    List<Program> findAll();
}
