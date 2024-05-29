package com.swati.demoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	
	public static void setStudentDetails(Student student, Session session1, Transaction transaction) {
    	StudentName studentName = new StudentName();
    	studentName.setFname("Hari");
    	studentName.setMname("Kumar");
    	studentName.setLname("Chaurasia");
		
		student.setId(1);
    	student.setName(studentName);
    	student.setColor("White");

    	session1.persist(student);
    	transaction.commit();
    	session1.close();
	}
	
	public static void getStudentDetails(Student student, Session session2) {
    	student = session2.get(Student.class, 1);
    	System.out.println(student);
    	session2.close();
	}
	
    public static void main(String[] args)
    {
    	Student student = new Student();
    	Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
    	SessionFactory sf = con.buildSessionFactory();
    	Session session1 = sf.openSession();
    	Transaction transaction = session1.beginTransaction();
    	setStudentDetails(student, session1, transaction);
    	
    	Session session2 = sf.openSession();
    	getStudentDetails(student, session2);
    }
}
