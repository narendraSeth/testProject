package com.nt.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Employee;

public class SaveObjectTest {	

	public static void main(String [] args) {
		Configuration cfg=null;
		Transaction tx=null;
		SessionFactory factory=null;
		Session ses=null;
		Employee emp=null;
		// Active HB framework(Bootstrap hibernate)
		cfg=new Configuration() ;
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//build session factory object
		factory=cfg.buildSessionFactory();
		//open session with data db s/w
		 ses=factory.openSession();
		
		//create object for domain class
		emp=new Employee();
		emp.setEid(1001);
		emp.setEmailId("ram@gmail.com");
		emp.setFirstName("ram");
		emp.setLastName("donald");
		try{
			tx=ses.beginTransaction();
			ses.save(emp);
			tx.commit();
			System.out.println("object is saved/record is inserted");		
		}
		catch(Exception e)
		{
			tx.rollback();
		}
		//close object
		ses.close();
		factory.close();
	}
}
	