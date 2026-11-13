package com.jsp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.DTO.Merchant;
import com.jsp.DTO.Product;

public class ProductDAO {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();


	public Product addProduct(int mid, Product p) {
		// TODO Auto-generated method stub
		EntityTransaction etran=em.getTransaction();
		etran.begin();
		Merchant mdb=em.find(Merchant.class,mid);
		if(mdb!=null) {
			p.setM(mdb);
			List<Product> pl=mdb.getProd();
			pl.add(p);
			em.persist(p);
			etran.commit();
			return p;
		}
		else {
			return null;
		}
		
	}


	public List<Merchant> findMerchantByProductId(int id) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select p.m from Product p where p.id=?1");
		q.setParameter(1,id);

		List<Merchant> l= q.getResultList();
		
		return l;
		
	}


	public Product updateProduct(Product m) {
		// TODO Auto-generated method stub
		EntityTransaction etran=em.getTransaction();
		etran.begin();
		Product mdb=em.find(Product.class, m.getId());
		if(mdb!=null) {
			mdb.setName(m.getName());
			mdb.setPrice(m.getPrice());
			mdb.setBrand(m.getBrand());
			mdb.setCategory(m.getCategory());
			
			etran.commit();
			return mdb;
		}
		else {
			return null;
		}
		
	}


	public List<Product> findProductByMerchantEmailAndPass(String email, String pass) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select m.prod from Merchant m where m.email=?1 and m.pass=?2");
		q.setParameter(1,email);
		q.setParameter(2,pass);
		
		List<Product> l= q.getResultList();
		return l;
	}


	public List<Product> findProductByMerchantNameAndGstNo(String name, String gstNo) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select m.prod from Merchant m where m.name=?1 and m.gstNo=?2");
		q.setParameter(1,name);
		q.setParameter(2,gstNo);
		
		List<Product> l= q.getResultList();
		return l;
	}
	
	
	public List<Product> findProductByMerchanttId(int id) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select p from Product p where p.m.id=?1");
		q.setParameter(1,id);

		List<Product> l= q.getResultList();
		
		return l;

	}



}
