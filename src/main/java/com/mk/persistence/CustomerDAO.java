package com.mk.persistence;

import java.util.List;

import com.mk.domain.Customer;

public interface CustomerDAO {
	public void create(Customer customer);
	public Customer read(int id);
	public List readAll();
	public void update(Customer customer);
	public void delete(int id);
}
