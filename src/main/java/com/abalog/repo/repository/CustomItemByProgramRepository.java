package com.abalog.repo.repository;

import com.abalog.repo.domain.ItemByProgram;

public interface CustomItemByProgramRepository {

	void saveBatch(ItemByProgram itemByProgram);
}
