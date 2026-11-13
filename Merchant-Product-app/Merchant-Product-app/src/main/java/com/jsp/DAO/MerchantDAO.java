package com.jsp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.DTO.Merchant;
import com.jsp.DTO.Product;

public class MerchantDAO {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	
	public Merchant saveMerchant(Merchant m) {
		EntityTransaction etran=em.getTransaction();
		etran.begin();
		em.persist(m);
		etran.commit();
		
		return m;
	}

	public Merchant updateMerchant(Merchant m) {
		// TODO Auto-generated method stub
		EntityTransaction etran=em.getTransaction();
		etran.begin();
		Merchant mdb=em.find(Merchant.class, m.getId());
		if(mdb!=null) {
			mdb.setName(m.getName());
			mdb.setGstNo(m.getGstNo());
			mdb.setEmail(m.getEmail());
			mdb.setPhno(m.getPhno());
			mdb.setPass(m.getPass());
			
			etran.commit();
			return mdb;
		}
		else {
			System.out.println("no record found");
			return null;
		}
		
		
		
	}

	public Merchant findMerchantById(int mid) {
		// TODO Auto-generated method stub
		return em.find(Merchant.class, mid);
		
	}

	public Merchant findMerchantByEmailAndPass(String email, String pass) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select m from Merchant m where m.email=?1 and m.pass=?2");
		q.setParameter(1,email);
		q.setParameter(2,pass);
		try {
			Merchant mdb=(Merchant)q.getSingleResult();
			return mdb;
		}
		catch(NoResultException e) {
			return null;
		}
		
		
		
	}

	}



