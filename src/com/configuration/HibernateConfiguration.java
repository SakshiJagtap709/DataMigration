package com.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.StudentDetails;
import com.entity.StudentInfo;

public class HibernateConfiguration {
	public static SessionFactory getSessionFactory() {
		
		//create Configuration object
		Configuration cfg = new Configuration();
		
		//load hibernate.cfg.xml
		cfg.configure();
		
		//Annoted entity classes
		cfg.addAnnotatedClass(StudentDetails.class);
		cfg.addAnnotatedClass(StudentInfo.class);
		
		//Build SessionFactory
		SessionFactory sf = cfg.buildSessionFactory();
		return sf;
	 }

}
