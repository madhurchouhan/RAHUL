package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

  public class RequestThread extends Thread {
	SessionFactory factory=null;
	public RequestThread(Session ses) {
	       this.factory=factory;
	}
	public void run(){

		Configuration cfg=null;
		EmpDetails emp=null,emp1=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0,idVal1=0;
		
		emp=new EmpDetails();
		//emp.setNo(101);
		emp.setFname("Tommy");
		emp.setLname("curien");
		emp.setMail("Tomy@gmail.com");
		
          factory= new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		     ses=factory.openSession();
		try{
			tx=ses.beginTransaction();
			idVal=(int) ses.save(emp);
			//idVal1=(int) ses.save(emp);
			System.out.println("Generated id Value is::idVal::"+idVal);

			System.out.println("thread going for sleep...");
			Thread.sleep(30000);      //at the time of sleeping execute one more time
			
		
			tx.commit();
			flag=true;
			System.out.println("Object is saved");
		}
		catch (Exception e) {
			System.out.println("Object Not saved");
			flag=false;
		}
	}
}
