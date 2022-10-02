package com.infosys;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.infosys.dto.CustomerDTO;
import com.infosys.exception.CustomerException;
import com.infosys.service.CustomerService;

@SpringBootTest
class MyShopSpringBootApplicationTests {

	@Autowired
	private CustomerService customerService;

	@Test
	void addCustomerValidTest() throws CustomerException {
		// So create an object of the class
		// whose method we want to validate for the
		// return type
		CustomerDTO customerDTO = new CustomerDTO("C001", "Ravi Kumar", 9876543219L, LocalDate.of(2000, 10, 15));
		String str = customerService.addCustomer(customerDTO);
		Assertions.assertEquals("C001", str);
	}

	@Test
	void addCustomerInValidTestCustomerId() throws CustomerException {
		// So create an object of the class
		// whose method we want to validate for the
		// return type
		CustomerDTO customerDTO = new CustomerDTO("CCCC", "Ravi Kumar", 9876543219L, LocalDate.of(2000, 10, 15));
		CustomerException customerException = Assertions.assertThrows(CustomerException.class,
				() -> customerService.addCustomer(customerDTO));
		Assertions.assertEquals("Id should start with C followed by 3 digits", customerException.getMessage());
	}

	@Test
	void addCustomerInValidTestCustomerName() throws CustomerException {
		// So create an object of the class
		// whose method we want to validate for the
		// return type
		CustomerDTO customerDTO = new CustomerDTO("C001", "Ravi", 9876543219L, LocalDate.of(2000, 10, 15));
		CustomerException customerException = Assertions.assertThrows(CustomerException.class,
				() -> customerService.addCustomer(customerDTO));
		Assertions.assertEquals(
				"Name should start with uppercase and can have firstname,middlename and lastname or firstname and lastname",
				customerException.getMessage());
	}

	@Test
	void addCustomerInValidTestCustomerMobileNo() throws CustomerException {
		// So create an object of the class
		// whose method we want to validate for the
		// return type
		CustomerDTO customerDTO = new CustomerDTO("C001", "Ravi Kumar", 98765432L, LocalDate.of(2000, 10, 15));
		CustomerException customerException = Assertions.assertThrows(CustomerException.class,
				() -> customerService.addCustomer(customerDTO));
		Assertions.assertEquals("Mobile number should have 10 digits", customerException.getMessage());
	}

	@Test
	void displayCustomerValidTest() throws CustomerException {

		List<CustomerDTO> customerDTO = customerService.displayCustomers();
		CustomerDTO customer = customerDTO.get(0);
		Assertions.assertEquals("C002", customer.getCustomerId());
	}

	/*@Test
	void displayCustomerInValidTest() throws CustomerException {

		CustomerException customerException = Assertions.assertDoesNotThrow(null)
	}*/

}
