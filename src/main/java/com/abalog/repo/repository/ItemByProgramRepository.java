package com.abalog.repo.repository;

import com.abalog.repo.domain.ItemByProgram;
import com.abalog.repo.domain.ItemByProgramPrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface ItemByProgramRepository
        extends CassandraRepository<ItemByProgram, ItemByProgramPrimaryKey>, CustomItemByProgramRepository {

    @Query("SELECT * FROM itembyprogram WHERE programid=?0 AND itemid=?1")
    ItemByProgram findOne(String programid, String itemid);

    @Query("SELECT * FROM itembyprogram WHERE programid=?0")
    List<ItemByProgram> findAllByProgram(String programid);


}
