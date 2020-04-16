package com.model;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.pojo.File;

public class BLManager {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();

	public void save(File f) {
	    Session s=sf.openSession();
	    Transaction t=s.beginTransaction();
	    s.save(f);
	    t.commit();
	    s.close();
		
	}
	
	;
	
	public List<File> getallfiles()
	{ 
	    Session s=sf.openSession();
	    Transaction t=s.beginTransaction();
		Criteria cr=s.createCriteria(File.class);
        List<File> l=cr.list();
        return l;
	}

	public void updatename(File f) {
		Session s1=sf.openSession();
	Transaction t1=s1.beginTransaction();
	s1.update(f);
	t1.commit();
	 s1.close();
	
	}

	public File searchfilebyid(String pid){

	    Session s=sf.openSession();
	    Transaction t=s.beginTransaction();
		int id=Integer.parseInt(pid);
		Criteria cr=s.createCriteria(File.class);
		cr.add(Restrictions.eq("id",id));
		  File f= (File)cr.uniqueResult();
		return f;
		
	}

	public void deletefile(File f) {
		Session s1=sf.openSession();
		Transaction t1=s1.beginTransaction();
		s1.delete(f);
		t1.commit();
		 s1.close();
			
	}

}
