package com.swati.hibernateRelationMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main(String[] args)
    {
    	Laptop laptop = new Laptop();
    	laptop.setLid("101");
    	laptop.setLname("Macbook");
    	
    	Student student = new Student();
    	student.setRollno(1);
    	student.setName("Rahul");
    	student.setMarks(90);
    	student.getLaptop().add(laptop);
    	
    	laptop.setStudent(student);
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
    	SessionFactory sf = con.buildSessionFactory();
    	Session session = sf.openSession();
    	session.beginTransaction();
    	
	    session.persist(laptop);
	    session.persist(student);
    	
	    session.getTransaction().commit();
    }
}
