package com.abalog.repo.schema;

import com.datastax.driver.core.SimpleStatement;
import io.smartcat.migration.SchemaMigration;
import io.smartcat.migration.exceptions.MigrationException;

public class CopilTableDefinition extends SchemaMigration {

	CopilTableDefinition(int version) {
		super(version);
	}

	@Override
	public String getDescription() {
		return "Create Copil table";
	}

	@Override
	public void execute() throws MigrationException {

		try {
			final String createCopilTable = "CREATE TABLE copil(\n" +
					" copilid text,\n" +
					" name text,\n" +
					" PRIMARY KEY (copilid));";
			executeWithSchemaAgreement(new SimpleStatement(createCopilTable));
		} catch (final Exception e) {
			throw new MigrationException("Failed Migration at CopilTableDefinition", e);
		}

	}
}
