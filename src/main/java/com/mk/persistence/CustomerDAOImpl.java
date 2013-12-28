package com.mk.persistence;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.mk.domain.Customer;

@Service
public class CustomerDAOImpl implements CustomerDAO {

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
		Customer customer = (Customer) session. get(Customer.class, id);
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

	@Override
	public List readAll() {
		System.out.println("Reading all customer records...");
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		session.beginTransaction();
		Criteria cr = session.createCriteria(Customer.class);
		List results = cr.list();
		session.getTransaction().commit();
		return results;
	}

}
