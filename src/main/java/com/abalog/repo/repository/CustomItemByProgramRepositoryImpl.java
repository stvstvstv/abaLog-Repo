package com.abalog.repo.repository;

import com.abalog.repo.domain.Item;
import com.abalog.repo.domain.ItemByProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraBatchOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

public class CustomItemByProgramRepositoryImpl implements CustomItemByProgramRepository {

	@Autowired
	CassandraTemplate template;

	@Autowired
	ItemRepository itemRepository;

	@Override
	public void saveBatch(ItemByProgram itemByProgram) {
		final CassandraBatchOperations batchOperations = template.batchOps();
		insertItem(itemByProgram,batchOperations);
		batchOperations.insert(itemByProgram);
		batchOperations.execute();


	}


	private void insertItem(ItemByProgram itemByProgram, final CassandraBatchOperations batchOperations) {
		batchOperations.insert(
				Item.builder().itemid(itemByProgram.getPrimaryKey().getItemid())
						.value(itemByProgram.getValue()).build()
		);

	}
}
