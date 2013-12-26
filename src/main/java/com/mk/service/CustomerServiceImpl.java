package com.mk.service;


import org.hibernate.Session;
import org.springframework.stereotype.Service;
import com.mk.domain.Customer;
import com.mk.persistence.HibernateUtil;

@Service
public class CustomerServiceImpl implements CustomerService {

	String[] names = {"Nikolaus Otto", "Robert Ford", "Gottlieb Daimler", "Lt. General Masaharu Homma"};
	
	@Override
	public void create(Customer user) {
		System.out.println("Creating customer record...");
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	@Override
	public Customer read(int id) {
		System.out.println("Reading customer record...");
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, id);
		System.out.println(customer.getId() + " - " + customer.getName());
		session.getTransaction().commit();
		return customer;
	}

	@Override
	public void update(Customer customer) {
		System.out.println("Updating customer record...");
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		session.beginTransaction();
		session.update(customer);
		session.getTransaction().commit();		
	}
	
	@Override
	public void delete(int id) {
		System.out.println("Deleting customer record...");
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, id);
		session.delete(customer);
		session.getTransaction().commit();		
	}

}
