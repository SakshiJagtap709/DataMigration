package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.configuration.HibernateConfiguration;
import com.entity.StudentDetails;
import com.entity.StudentInfo;

public class StudentMigrationDao {
	
	public List<StudentDetails>  getAllStudents(){
		List<StudentDetails> students =null;
		
		try( Session session = HibernateConfiguration.getSessionFactory().openSession()){
			
			//using Criteria get all student from StudentDetails
			Criteria criteria = session.createCriteria(StudentDetails.class);
			students = criteria.list();
			
		}catch (Exception e) {
			System.out.println("Not able to get the students: " +e.getMessage());
		}
		
		return students;
		
	}
	
	public boolean saveStudent(StudentInfo student) {
		
		try(Session session = HibernateConfiguration.getSessionFactory().openSession()){
			
			//check if a student with the same Id already exists
			StudentInfo existing = session.get(StudentInfo.class, student.getStudentId());
			
			if(existing == null) {
				//only save if not exists
				session.save(student);
				session.beginTransaction().commit();
				System.out.println("Student is inserted with Id : "+student.getStudentId());
				return true;
				
			}else {
				System.out.println("Skipped duplicate data");
			}
			
			session.beginTransaction().commit();
		}catch(Exception e) {
			System.out.println("Error saving student info: " + e.getMessage());
		}
		
		return false;
	}

}
