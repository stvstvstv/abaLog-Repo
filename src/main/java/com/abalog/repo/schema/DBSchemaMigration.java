package com.abalog.repo.schema;

import io.smartcat.migration.MigrationEngine;
import io.smartcat.migration.MigrationResources;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.cql.SessionCallback;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DBSchemaMigration implements CommandLineRunner {

	private CassandraTemplate cassandraTemplate;

	@Override
	public void run(String... args) {
		final MigrationResources resources = new MigrationResources();
		resources.addMigration(new CopilTableDefinition(1));
		resources.addMigration(new ProgramTableDefinition(2));
		resources.addMigration(new ItemTableDefinition(3));
		resources.addMigration(new ProgramByCopilTableDefinition(4));
		resources.addMigration(new ItemByProgramTableDefinition(5));



		cassandraTemplate.getCqlOperations().execute((SessionCallback<Boolean>) session ->
				MigrationEngine.withSession(session).migrate(resources));
	}
}
