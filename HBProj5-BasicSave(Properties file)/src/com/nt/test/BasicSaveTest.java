package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class BasicSaveTest
{

	@SuppressWarnings("null")
	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		EmpDetails emp=null;
		Transaction tx=null;
		int idVal=0;
		//activate HB F/W
		cfg=new Configuration();
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//add mapping file
		//cfg.addFile("src/com/nt/cfgs/Employee.hbm.xml");
		//build session factory Obj
		factory=cfg.buildSessionFactory();
		//open sesion
		ses=factory.openSession();
		//prepare domain class Obj with values
		emp.setNo(1011);
		emp.setFname("raja1");
		emp.setLname("rao9");
		emp.setMail("rao@gmain.com");
		//save obj
		ses.save(emp);
		ses.flush();
		
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
