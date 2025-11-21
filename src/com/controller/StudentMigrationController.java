package com.controller;

import com.service.StudentMigrationService;

public class StudentMigrationController {

	public void doMigration() {
		
		StudentMigrationService service = new StudentMigrationService();
		service.doMigration();
		
	}
	

}
