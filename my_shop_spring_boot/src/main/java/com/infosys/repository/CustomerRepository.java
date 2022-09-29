package com.infosys.repository;

import java.util.List;

import com.infosys.dto.CustomerDTO;
import com.infosys.exception.CustomerException;

public interface CustomerRepository {

	
	public String addCustomer(CustomerDTO customer) throws CustomerException;
    public List<CustomerDTO> displayCustomers() throws CustomerException;
    
}
