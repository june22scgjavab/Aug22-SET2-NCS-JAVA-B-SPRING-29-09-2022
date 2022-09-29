package com.infosys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.dto.CustomerDTO;
import com.infosys.exception.CustomerException;
import com.infosys.repository.CustomerRepository;
import com.infosys.validator.Validator;



@Service
public class CustomerServiceImpl implements CustomerService {
// We should create a reference variable of interface
// and object of the class which has implemented the interface
	@Autowired
	private CustomerRepository customerDAO;//=new CustomerRepositoryImpl();
	
	public String addCustomer(CustomerDTO customer) throws CustomerException {
		Validator validate=new Validator();
		validate.validate(customer);
		return customerDAO.addCustomer(customer);
	}

	public List<CustomerDTO> displayCustomers() throws CustomerException {
		if(customerDAO.displayCustomers().isEmpty())
		{
			throw new CustomerException("The List is empty");
		}
		return customerDAO.displayCustomers();
	}

}
