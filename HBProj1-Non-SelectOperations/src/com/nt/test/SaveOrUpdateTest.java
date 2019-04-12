package com.nt.test;
//Executed successfully only problem in Boolean values
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Product;

public class SaveOrUpdateTest 
{
   public static void main(String[] args) 
	{
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Product prod=null;
		Transaction tx=null;
		//Bootstrap hibernate
		cfg=new Configuration();
		//load cfg file
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//build session factory
		factory=cfg.buildSessionFactory();
		//create session
		ses=factory.openSession();
		//create domain class object
		prod=new Product();
		//set the value
		
		prod.setPid(105);
		prod.setPname("Soa milk");
		prod.setPrice(55);
		prod.setQty(5);
		prod.setIsExpire("true");
		
		try{
			tx=ses.beginTransaction();
			ses.save(prod);
			tx.commit();
			System.out.println("Object is save");
		}
		catch(Exception se){
			tx.rollback();
			se.printStackTrace();
			System.out.println("Object is not save");
		}
		//close obj
		ses.close();
		factory.close();
	}//main
}//class
