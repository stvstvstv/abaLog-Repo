package com.abalog.repo.schema;

import com.datastax.driver.core.SimpleStatement;
import io.smartcat.migration.SchemaMigration;
import io.smartcat.migration.exceptions.MigrationException;

public class ItemByProgramTableDefinition extends SchemaMigration {

	ItemByProgramTableDefinition(int version) {
		super(version);
	}

	@Override
	public String getDescription() {
		return "Create ItemByProgram table";
	}

	@Override
	public void execute() throws MigrationException {
		try {
			final String createItemByProgramTable = "CREATE TABLE itemByProgram(\n" +
					" programID text,\n" +
					" itemId text,\n" +
					" value text,\n" +
					" PRIMARY KEY ((programID), itemID))\n" +
					" WITH CLUSTERING ORDER BY (itemID ASC);\n";
			executeWithSchemaAgreement(new SimpleStatement(createItemByProgramTable));
		} catch (final Exception e) {
			throw new MigrationException("Failed Migration at itemByProgramDefinition", e);
		}
	}
}
