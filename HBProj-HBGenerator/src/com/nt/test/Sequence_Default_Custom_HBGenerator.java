package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class Sequence_Default_Custom_HBGenerator {

	public static void main(String[] args) {
		EmpDetails emp=null;
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		ses=HibernateUtil.getSession();
		emp=new EmpDetails();
		emp.setNo(101);
		emp.setFname("Tommy");
		emp.setLname("curien");
		emp.setMail("Tomy@gmail.com");
		try{
			tx=ses.beginTransaction();
			idVal=(int) ses.save(emp);
			System.out.println("Generated id Value is:: "+idVal);
			tx.commit();
			flag=true;
			System.out.println("Object is saved");
		}
		catch (Exception e) {
			System.out.println("Object Not saved");
			flag=false;
		}
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}

}
