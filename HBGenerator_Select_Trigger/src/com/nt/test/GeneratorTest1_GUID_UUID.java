package com.nt.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.BankTxDetails;
import com.nt.utility.HibernateUtil;
public class GeneratorTest1_GUID_UUID {
	public static void main(String[] args) {
          Session ses=null;
          boolean flag=false;
          Transaction tx=null;
//          String idVal=null;
          int idVal=0;
          BankTxDetails B1=null;
          //get session
          ses=HibernateUtil.getSession();
          try{
        	  //begin TX
        	  tx=ses.beginTransaction();
        	  //prepare domain class object
        	  B1=new BankTxDetails();
        	 // B1.setTxid(43);
        	  B1.setTxName("select1");
        	  B1.setTxAmount(6000);
        	  B1.setTxDate(new Date());
        	  //idVal=(int)ses.save(B1);
        	  idVal=(int)ses.save(B1);
        	  System.out.println("Generated id value is ::"+idVal);
        	  flag=true;
          }
          catch(HibernateException he){
        	  he.printStackTrace();
        	  flag=false;
          }
          catch(Exception e){
        	  e.printStackTrace();
        	  flag=false;
          }
          finally{
        	  if(flag)
        		  tx.commit();
        	  else
        		  tx.rollback();
        	  HibernateUtil.closeSession(ses);
        	  HibernateUtil.closeSessionFactory();
          }//finally
	}//main
}//class
