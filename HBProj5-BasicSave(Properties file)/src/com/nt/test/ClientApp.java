package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;
//SUCCESSFULLY EXECUTED
public class ClientApp {

	public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		EmpDetails emp=null;
		Transaction tx=null;
	    //Activate hibernate F/W
		 cfg=new Configuration();
		//read & store HB cfg file,mapping file data into Configuration obj
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//set hibernate connection ,mapping file info
		cfg.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
		cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
		cfg.setProperty("hibernate.connection.username", "system");
		cfg.setProperty("hibernate.connection.password", "password");
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		cfg.setProperty("hibernate.show_sql", "true");
		cfg.setProperty("hibernate.format_sql", "true");
		//add mapping file
		cfg.addFile("src/com/nt/cfgs/Employee.hbm.xml");
		
		
		//Create Sessionfactory Obj
		factory=cfg.buildSessionFactory();
		//Create Session Obj
		 ses=factory.openSession();
		//create Domain class Obj with data
		 emp=ses.get(EmpDetails.class,101);
		 if(emp!=null)
			 System.out.println(emp);
		 
		 //close objs
		ses.close();
		factory.close();

	}//main

}//class
