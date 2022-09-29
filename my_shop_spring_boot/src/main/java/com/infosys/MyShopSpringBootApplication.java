package com.infosys;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infosys.dto.CustomerDTO;
import com.infosys.exception.CustomerException;
import com.infosys.service.CustomerService;

@SpringBootApplication
public class MyShopSpringBootApplication implements CommandLineRunner{

	@Autowired
	private CustomerService customerService;
	public static void main(String[] args) {
		SpringApplication.run(MyShopSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 1) ADD CUSTOMERS
				addCustomers();
				// 2) DISPLAY CUSTOMERS
				displayCustomers();

		
	}

	private void displayCustomers() {
		try {
			List<CustomerDTO> customerList = customerService.displayCustomers();
			customerList.forEach(customer->System.out.println(customer.getCustomerId()+"\t"+customer.getCustomerName()+"\t"+customer.getMobileNumber()+"\t"+customer.getDateOfBirth()));
		} catch (CustomerException e) {

			System.out.println(e.getMessage());
		}
		
	}

	private void addCustomers() {

		CustomerDTO customer = new CustomerDTO("C001", "Ravi Kumar", 9876543219L, LocalDate.of(2000, 10, 15));
		String str;
		try {
			str = customerService.addCustomer(customer);
			System.out.println(str);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}

		
	}

}
