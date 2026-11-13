package com.jsp.Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import com.jsp.DAO.MerchantDAO;
import com.jsp.DAO.ProductDAO;
import com.jsp.DTO.Merchant;
import com.jsp.DTO.Product;

public class MerchantProductController {
	static Scanner sc=new Scanner(System.in);
	static MerchantDAO  mdao=new MerchantDAO();
	static ProductDAO  pdao=new ProductDAO();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
		System.out.println("1. Save Merchant");
		System.out.println("2. Update Merchant");
		System.out.println("3. Find Merchant by id");
		System.out.println("4. Find Merchant by email and password");
		System.out.println("5. Find Merchant by Product id");

		System.out.println("6. Add Product");
		System.out.println("7. Update Product");
		System.out.println("8. Find Products By Merchant id");
		System.out.println("9. Find Products By Merchant email and password");
		System.out.println("10. Find Products By Merchant name and gst_number");
		System.out.println("11. exit");

		
		System.out.println("Enter your choice");
		
		int choice=sc.nextInt();
		switch(choice) {
		case 1: saveMerchant();
		break;
		
		case 2: updateMerchant();
		break;
		
		case 3 : findMerchantById();
		break;
		
		case 4 : findMerchantByEmailAndPass();
		break;
		
		case 5 : findMerchantByProductId();
		break;
		
		case 6 : addProduct();
		break;
		
		case 7 : updateProduct();
		break;
		
		case 8 : findProductByMerchantId();
		break;
		
		case 9 : findProductByMerchantEmailAndPass();
		break;
		
		case 10 : findProductByMerchantNameAndGstNo();
		break;
		
		case 11 : System.exit(0);
		
		default : System.err.println("invalid option");
		
		
		}
		}


	}
	
	private static void findProductByMerchantNameAndGstNo() {
		// TODO Auto-generated method stub
		System.out.println("enter merchant name and gst_no to find produts");
		String name=sc.next();
		String gstNo=sc.next();
		
		List<Product> mdb=pdao.findProductByMerchantNameAndGstNo(name,gstNo);
		if(mdb.size() >0) {
			for(Product person : mdb) {
				System.out.println(person);
			}
		}
		else {
			System.err.println("no record found");
		}
		
		
	}

	private static void findProductByMerchantEmailAndPass() {
		// TODO Auto-generated method stub
		System.out.println("enter merchant email and pass to find products");
		String email=sc.next();
		String pass=sc.next();
		
		List<Product> mdb=pdao.findProductByMerchantEmailAndPass(email,pass);
		if(mdb.size() >0) {
			for(Product person : mdb) {
				System.out.println(person);
			}
		}
		else {
			System.err.println("no record found");
		}
		
		
	}

	public static void findProductByMerchantId() {
		// TODO Auto-generated method stub
		System.out.println("enter merchant id to find products");
		int id=sc.nextInt();
		List<Product> mdb=pdao.findProductByMerchanttId(id);
		if(mdb.size() >0) {
			for(Product person : mdb) {
				System.out.println(person);
			}
		}
		else {
			System.err.println("no record found");
		}
		
	}

	private static void updateProduct() {
		// TODO Auto-generated method stub
		System.out.println("enter merchant info.. for id,name,price,brand,category");
		Product m=new Product();
		//System.out.println("enter details..name,gst no,email,phno,password");
		m.setId(sc.nextInt());
		m.setName(sc.next());
		m.setPrice(sc.nextDouble());
		m.setBrand(sc.next());
		m.setCategory(sc.next());
		
		pdao.updateProduct(m);
		
		
	}

	public static void addProduct() {
		// TODO Auto-generated method stub
		System.out.println("enter merchant id ");
		int mid=sc.nextInt();
		System.out.println("enter product infoo.... name,brand,category,price ");
		Product p=new Product();
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setCategory(sc.next());
		p.setPrice(sc.nextDouble());
		 Product pdb= pdao.addProduct(mid,p);
		 if(pdb!=null) {
				System.out.println("product is added to merchant with id: "+pdb.getId());
			}
			else {
				System.err.println("product record found");
			}
		
		
		
	}

	public static void findMerchantByProductId() {
		// TODO Auto-generated method stub
		System.out.println("enter product id to find merchant");
		int id=sc.nextInt();
		List<Merchant> mdb=pdao.findMerchantByProductId(id);
		if(mdb.size() >0) {
			for(Merchant person : mdb) {
				System.out.println(person);
			}
		}
		else {
			System.err.println("no record found");
		}
		
		
		
	}

	public static void findMerchantByEmailAndPass() {
		// TODO Auto-generated method stub
		System.out.println("enter email and pass");
		String email=sc.next();
		String pass=sc.next();
		 Merchant mdb=mdao.findMerchantByEmailAndPass(email,pass);
		 if(mdb!=null) {
				System.out.println(mdb);
			}
			else {
				System.err.println("no record found");
			}
		
		
	}

	public static void findMerchantById() {
		// TODO Auto-generated method stub
		System.out.println("enter merchant id to find merchant");
		int mid=sc.nextInt();
		Merchant mdb=mdao.findMerchantById(mid);
		if(mdb!=null) {
			System.out.println(mdb);
		}
		else {
			System.err.println("no record found");
		}
		
		
	}

	public static void updateMerchant() {
		// TODO Auto-generated method stub
		System.out.println("enter product info.. for id,name,gst no,email,phno,password");
		Merchant m=new Merchant();
		m.setId(sc.nextInt());
		m.setName(sc.next());
		m.setGstNo(sc.next());
		m.setEmail(sc.next());
		m.setPhno(sc.nextLong());
		m.setPass(sc.next());
		
		mdao.updateMerchant(m);
		
		
		
	}

	public static void saveMerchant() {
		Merchant m=new Merchant();
		System.out.println("enter details..name,gst no,email,phno,password");
		m.setName(sc.next());
		m.setGstNo(sc.next());
		m.setEmail(sc.next());
		m.setPhno(sc.nextLong());
		m.setPass(sc.next());
		
		Merchant mdb=mdao.saveMerchant(m);
		System.out.println("Merchant record is inserted");
		
	}

}
