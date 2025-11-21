package com.service;

import java.util.List;

import com.dao.StudentMigrationDao;
import com.entity.StudentDetails;
import com.entity.StudentInfo;

public class StudentMigrationService {
	
	StudentMigrationDao dao = new StudentMigrationDao();

	public void doMigration() {
		

			//Get all students from StudentDetails
			List<StudentDetails> students = dao.getAllStudents();
			
			if(students.isEmpty()) {
				System.out.println("No data found in StudentDetails.");
				return;			// exits if no data is present in StudentDetails
			}
			//iterate over all students and migrate it to StudentInfo
			for(StudentDetails sd : students) {
				StudentInfo studentinfo = new StudentInfo();
				studentinfo.setStudentId(sd.getStudentId());
				studentinfo.setFirstName(sd.getFirstName());
				studentinfo.setLastName(sd.getLastName());
				studentinfo.setAge(sd.getAge());
				studentinfo.setCity(sd.getCity());
				studentinfo.setPhoneNumber(sd.getPhoneNumber());
				
				dao.saveStudent(studentinfo);
				
				
			}
		
	}

}
