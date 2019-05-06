package com.nt.test;

import org.hibernate.Session;

import com.nt.utility.HibernateUtil;

//this generate value in sequence order
//this is suitable for multi-Threaded environment
//& also suitable for Cluster environment
//this is the example of multi.. Environ
public class Increment_Generator2 {

	public static void main(String[] args) {
		RequestThread t1=null,t2=null;
		Session ses=null;
       ses=HibernateUtil.getSession();
		t1=new RequestThread(ses);
		t2=new RequestThread(ses);
		t1.start();
		t2.start();
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}

}
