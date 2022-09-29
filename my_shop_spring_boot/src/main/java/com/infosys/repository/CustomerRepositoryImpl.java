package com.infosys.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.infosys.dto.CustomerDTO;
import com.infosys.exception.CustomerException;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	private List<CustomerDTO> customerList = new ArrayList();

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
