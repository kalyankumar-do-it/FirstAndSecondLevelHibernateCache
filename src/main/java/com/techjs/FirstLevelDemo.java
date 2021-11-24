package com.techjs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.techjs.entity.Account;


public class FirstLevelDemo 
{

	public static void main(String[] args)
	{
		Account acc = new Account();
		acc.setAccNo(1001);
		acc.setAccName("Kalyan Kumar");
		
		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(Account.class);
		
		SessionFactory sf = config.buildSessionFactory();
		Session session1 = sf.openSession();
		
		Transaction tn1 = session1.beginTransaction();
		//session.save(acc);
		
		Account ac1 = session1.get(Account.class,1001);
		System.out.println("Acc No:"+ac1.getAccNo()+" Acc Name:"+ac1.getAccName());
		
		tn1.commit();
		session1.close();
		
		sf.close();
	}

}
