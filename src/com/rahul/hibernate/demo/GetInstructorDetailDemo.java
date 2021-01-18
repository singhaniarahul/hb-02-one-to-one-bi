package com.rahul.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.rahul.hibernate.demo.entity.Instructor;
import com.rahul.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Instructor.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
						
			session.beginTransaction();
			
			int theId = 2;
			
			InstructorDetail instructoDetail = session.get(InstructorDetail.class, theId);
			
			System.out.println(instructoDetail);
			System.out.println(instructoDetail.getInstructor());
			
			session.getTransaction().commit();

	}catch(Exception exception) {
		exception.printStackTrace();
	}finally {
		session.close();
		sessionFactory.close();
	}

  }
}
