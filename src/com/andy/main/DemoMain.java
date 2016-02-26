package com.andy.main;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jbarcode.JBarcode;
import org.jbarcode.encode.EAN8Encoder;
import org.jbarcode.encode.InvalidAtributeException;
import org.jbarcode.paint.EAN8TextPainter;
import org.jbarcode.paint.WidthCodedPainter;

import com.andy.bean.Food;
import com.andy.bean.Product;
import com.andy.scan.CodeReader;
import com.andy.util.HibernateUtil;

public class DemoMain {
	
	public static void main(String args[]){
		
	System.out.println("Maven + Hibernate + MySQL+Swing");
	
    
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	session.beginTransaction();
	//Product product = new Product();
	//product.setBarCode("8852008300420");
	//product.setName("Lotte Koala Strawberry Biscuuit (family pack)");

	
      // session.save(product);
	String barCode = CodeReader.decodeBarcode("/Users/Andy-Chan/Desktop/1.png");
	String hql = "from Product where barcode=?";
	ArrayList<Product> result  = (ArrayList<Product>) session.createQuery(hql).setParameter(0, barCode).list();
	Product product = result.get(0);
	session.close();
	
	System.out.println(product);

	}
	
	public Product runScan(){
		System.out.println("Maven + Hibernate + MySQL+Swing");
		
	    
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		String barCode = CodeReader.decodeBarcode("/Users/Andy-Chan/Desktop/2.png");
		String hql = "from Product where barcode=?";
		ArrayList<Product> result  = (ArrayList<Product>) session.createQuery(hql).setParameter(0, barCode).list();
		Product product = result.get(0);
		session.close();
		System.out.println(product);
		return product;
	}
	
	

}
