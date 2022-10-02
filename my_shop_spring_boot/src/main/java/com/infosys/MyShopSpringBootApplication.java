package com.infosys;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infosys.dto.CustomerDTO;
import com.infosys.exception.CustomerException;
import com.infosys.service.CustomerService;

@SpringBootApplication
public class MyShopSpringBootApplication implements CommandLineRunner{
	private static final Log LOGGER = LogFactory.getLog(MyShopSpringBootApplication.class);
	//private final Log LOGGER = LogFactory.getLog(this.getClass());
	@Autowired
	private CustomerService customerService;
	public static void main(String[] args) {
		SpringApplication.run(MyShopSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// ADD CUSTOMERS
			     addCustomers();
				// 2) DISPLAY CUSTOMERS
				//displayCustomers();
		
	}
	private void displayCustomers() {
		try {
			List<CustomerDTO> customerList = customerService.displayCustomers();
			customerList.forEach(customer->LOGGER.info(customer.getCustomerId()+"\t"+customer.getCustomerName()+"\t"+customer.getMobileNumber()+"\t"+customer.getDateOfBirth()));
		} catch (CustomerException e) {

			LOGGER.error(e.getMessage());
		}
		
	}

	private void addCustomers() {

		CustomerDTO customer = new CustomerDTO("E001", "Ravi Kumar", 9876543219L, LocalDate.of(2000, 10, 15));
		String str;
		try {
			str = customerService.addCustomer(customer);
			LOGGER.info(str);
			
	} catch(Exception exception) {
		LOGGER.error(exception.getMessage());
	}
	

		
	}

}
