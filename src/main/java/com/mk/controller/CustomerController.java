package com.mk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mk.domain.Customer;
import com.mk.persistence.CustomerDAO;

@RestController
@RequestMapping("api")
public class CustomerController {
	CustomerDAO customerService;
	
	@Autowired
	public CustomerController(CustomerDAO customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value="customer", method = RequestMethod.POST)
	public String createCustomer(@RequestBody Customer customer) {
		customerService.create(customer);
		return "Created Customer: " + toJSONString(customer);
	}
	
	@RequestMapping(value="customer", method=RequestMethod.GET, params="id")
	public Customer readCustomer(@RequestParam("id") int id) {
		return customerService.read(id);
	}
	
	@RequestMapping(value="customer/{id}", method = RequestMethod.GET)  
	public Customer readCustomerPath(@PathVariable int id) {
		return customerService.read(id);
	}
	
	@RequestMapping(value="customer", method = RequestMethod.GET)  
	public List readCustomerList() {
		return customerService.readAll();
	}
	
	@RequestMapping(value="customer/{id}", method = RequestMethod.PUT)
	public String updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
		customerService.update(customer);
		return "Updated Customer: " + toJSONString(customer);
	}
	
	@RequestMapping(value="customer/{id}", method = RequestMethod.DELETE)
	public String deleteCustomer(@PathVariable int id) {
		customerService.delete(id);
		return "Deleted Customer: for id : " + id;
	}

	String toJSONString(Object obj) {
		ObjectMapper om = new ObjectMapper();
		String jsonResult = "";
		try {
			jsonResult = om.writeValueAsString(obj); //om.writerWithDefaultPrettyPrinter().writeValueAsString(customer);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResult;
	}

	/*     
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping("/greeting")
    public @ResponseBody Customer greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    */
	
}
