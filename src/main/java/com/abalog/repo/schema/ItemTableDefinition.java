package com.abalog.repo.schema;

import com.datastax.driver.core.SimpleStatement;
import io.smartcat.migration.SchemaMigration;
import io.smartcat.migration.exceptions.MigrationException;

public class ItemTableDefinition extends SchemaMigration {

	ItemTableDefinition(int version) {
		super(version);
	}

	@Override
	public String getDescription() {
		return "Create Item table";
	}

	@Override
	public void execute() throws MigrationException {

		try {
			final String createItemTable = "CREATE TABLE item(\n" +
					" itemid text,\n" +
					" value text,\n" +
					" PRIMARY KEY (itemid));";
			executeWithSchemaAgreement(new SimpleStatement(createItemTable));

		} catch (final Exception e) {
			throw new MigrationException("Failed Migration at ItemTableDefinition", e);
		}
	}
}
