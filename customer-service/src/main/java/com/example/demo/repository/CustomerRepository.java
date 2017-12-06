package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public Customer findByCustomerId(Long customerId);
	
	@Query("SELECT count(*) from Customer")
	public int countCustomers();
	


}
