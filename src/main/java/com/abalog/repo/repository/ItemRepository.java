package com.abalog.repo.repository;

import com.abalog.repo.domain.Item;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ItemRepository extends CassandraRepository<Item, String> {

}
