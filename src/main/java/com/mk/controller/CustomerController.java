package com.mk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mk.domain.Customer;
import com.mk.service.CustomerService;

@Controller
@RequestMapping("api")
public class CustomerController {
	CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value="customer", method=RequestMethod.POST)
	@ResponseBody
	public String createCustomer(Customer customer) {
		customerService.create(customer);
		return "Created Customer: " + toJSONString(customer);
	}
	
	@RequestMapping(value="customer", method=RequestMethod.GET, params="id")
	@ResponseBody
	public Customer readCustomer(@RequestParam("id") int id) {
		return customerService.read(id);
	}
	
	@RequestMapping(value="customer", method=RequestMethod.PUT)
	@ResponseBody
	public String updateCustomer(Customer customer) {
		customerService.update(customer);
		return "Updated Customer: " + toJSONString(customer);
	}
	
	@RequestMapping(value="customer", method=RequestMethod.DELETE, params="id")
	@ResponseBody
	public String deleteCustomer(@RequestParam("id") int id) {
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
