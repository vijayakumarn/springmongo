package com.sahajsoft.springmongo;

import com.sahajsoft.springmongo.mongo.documents.Customer;
import com.sahajsoft.springmongo.mongo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmongoApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringmongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.deleteAll();

		//save a couple of customers.
		customerRepository.save(new Customer("Vijay", "N"));
		customerRepository.save(new Customer("Santosh", "N"));

		//find all customers
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
	}
}
