package com.nt.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class BasicSaveTest1 
{

	public static void main(String[] args) 
	{
	  Configuration cfg=null;
	  SessionFactory factory=null;
	  Session ses=null;
	  EmpDetails emp=null;
	  Transaction tx=null;
	  int idVal=0;
	  InputStream is=null;
	  Properties props=null;
	  try
	  {
		  //locate Propperties file
		  is=new FileInputStream("src/com/nt/test/hibernate.properties");
		  props=new Properties();
		  props.load(is);
	  }//try
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  //activate HB F/W
	  cfg=new Configuration();
	  
	  cfg.setProperties(props);
	  cfg.addFile("src/com/nt/cfgs/Employee.hbm.xml");
	  factory=cfg.buildSessionFactory();
	  ses=factory.openSession();
	  emp=new EmpDetails();
	  emp.setNo(116);
	  emp.setFname("naya");
	  emp.setLname("jexx");
	  emp.setMail("nayaJexx@gmail.com");
	  ses.save(emp);
	  ses.flush();
	  ses.close();
	  factory.close();

	}

}
