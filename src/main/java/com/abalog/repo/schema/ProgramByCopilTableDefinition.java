package com.abalog.repo.schema;

import com.datastax.driver.core.SimpleStatement;
import io.smartcat.migration.SchemaMigration;
import io.smartcat.migration.exceptions.MigrationException;

public class ProgramByCopilTableDefinition extends SchemaMigration {

	ProgramByCopilTableDefinition(int version) {
		super(version);
	}

	@Override
	public String getDescription() {
		return "create Program By Copil Table";
	}

	@Override
	public void execute() throws MigrationException {
		try {
			final String createProgramByCopilTable = "CREATE TABLE programByCopil(\n" +
					" copilid text,\n" +
					" programid text,\n" +
					" nume text,\n" +
					" descriere text,\n" +
					" mastered boolean,\n" +
					" PRIMARY KEY ((copilid), programid))\n" +
					" WITH CLUSTERING ORDER BY (programid ASC);";
			executeWithSchemaAgreement(new SimpleStatement(createProgramByCopilTable));
		} catch (final Exception e) {
			throw new MigrationException("Failed Migration at ProgramByCopilDefinition");
		}
	}
}
