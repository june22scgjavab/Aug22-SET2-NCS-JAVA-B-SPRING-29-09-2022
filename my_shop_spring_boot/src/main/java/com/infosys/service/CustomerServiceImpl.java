package com.infosys.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.MyShopSpringBootApplication;
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
	private static final Log LOGGER = LogFactory.getLog(CustomerServiceImpl.class);
	public String addCustomer(CustomerDTO customer) throws CustomerException {
		Validator validate=new Validator();
		validate.validate(customer);
		return customerDAO.addCustomer(customer);
	}

	public List<CustomerDTO> displayCustomers() throws CustomerException {
		//try
		//{
		if(customerDAO.displayCustomers().isEmpty())
		{
			throw new CustomerException("The List is empty");
		}
		//}catch(CustomerException exception) {
		 //  LOGGER.error(exception.getMessage(),exception);
		  // throw exception;
		//}
		
		return customerDAO.displayCustomers();
	}

}
