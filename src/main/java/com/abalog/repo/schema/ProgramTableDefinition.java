package com.abalog.repo.schema;

import com.datastax.driver.core.SimpleStatement;
import io.smartcat.migration.SchemaMigration;
import io.smartcat.migration.exceptions.MigrationException;

public class ProgramTableDefinition extends SchemaMigration {

	ProgramTableDefinition(int version) {
		super(version);
	}

	@Override
	public String getDescription() {
		return "Create Program Table";
	}

	@Override
	public void execute() throws MigrationException {
		try {
			final String createProgramTable = "CREATE TABLE program(\n" +
					" programID text,\n" +
					" name text,\n" +
					" mastered boolean,\n" +
					" PRIMARY KEY (programID));";
			executeWithSchemaAgreement(new SimpleStatement(createProgramTable));
		} catch (final Exception e) {
			throw new MigrationException("Failed Migration at ProgramTableDefinition");
		}
	}
}
