package com.infosys.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.infosys.dto.CustomerDTO;
import com.infosys.exception.CustomerException;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	private List<CustomerDTO> customerList = new ArrayList();

	public CustomerRepositoryImpl() {
		CustomerDTO customerDTO1 = new CustomerDTO("C002", "Suresh Kumar", 9876543291L, LocalDate.of(2000, 10, 15));
		CustomerDTO customerDTO2 = new CustomerDTO("C003", "Raman Kumar", 9876543291L, LocalDate.of(2000, 10, 15));
		customerList.add(customerDTO1);
		customerList.add(customerDTO2);
	}
	// We have to add the customers to a List(ArrayList)
	public String addCustomer(CustomerDTO customer) throws CustomerException {

		customerList.add(customer);
		// We need to return the id of the customer which got added
		return customer.getCustomerId();
	}

	public List<CustomerDTO> displayCustomers() throws CustomerException {
		
		return customerList;
	}

}
