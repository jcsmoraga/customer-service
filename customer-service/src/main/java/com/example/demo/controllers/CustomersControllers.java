package com.example.demo.controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.clients.AccountRestTemplateClient;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Account;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
public class CustomersControllers {

	protected Logger logger = Logger.getLogger(CustomersControllers.class.getName());
	protected CustomerRepository customerRepository;

	@Autowired
	AccountRestTemplateClient accountRestTemplateClient;

	@Autowired
	public CustomersControllers(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;

		logger.info("CustomerRepository says system has " + customerRepository.countCustomers() + " customers");
	}

	@RequestMapping("/customers/{customerId}")
	public Customer byCustomerId(@PathVariable("customerId") Long customerId) {

		logger.info("customers-service byNumber() invoked: " + customerId);
		Customer customer = customerRepository.findByCustomerId(customerId);
		logger.info("customers-service byNumber() found: " + customerId);

		if (customer == null)
			throw new CustomerNotFoundException(customerId);
		else {
			//Account customerAccount = accountRestTemplateClient.getAccount(customer.getAccountNumber());
			//customer.setBalance(customerAccount.getBalance());
			return customer;
		}

	}
	
	

	@RequestMapping(method = RequestMethod.POST,value ="/customers")
	public Customer insertCustomer(@RequestBody Customer customer){
		logger.info("accounts-service insertCustomer() invoked: " + customerRepository.getClass().getName() + " for "
				+ customer.getName());
		Date date = new Date();
		Long accountNumber = date.getTime();
		accountNumber+=1;
		customer.setAccountNumber(String.valueOf(accountNumber).substring(0, 8));
		Customer customerInserted= customerRepository.save(customer);
		if(customerInserted == null){
			throw new RuntimeException();
		}
		else{
			Account account=new Account();
			account.setNumber(customerInserted.getAccountNumber());
			account.setOwner(customerInserted.getName());
			account.setBalance(customer.getBalance());
			accountRestTemplateClient.saveAccount(account);
			return customerInserted;
		}
	}

}
