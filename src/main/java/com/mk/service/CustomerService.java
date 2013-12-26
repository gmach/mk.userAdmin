package com.mk.service;

import com.mk.domain.Customer;

public interface CustomerService {
	public void create(Customer customer);
	public Customer read(int id);
	public void update(Customer customer);
	public void delete(int id);
}
