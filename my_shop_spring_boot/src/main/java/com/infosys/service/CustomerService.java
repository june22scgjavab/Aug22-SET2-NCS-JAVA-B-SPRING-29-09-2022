package com.infosys.service;

import java.util.List;

import com.infosys.dto.CustomerDTO;
import com.infosys.exception.CustomerException;


public interface CustomerService {
	public String addCustomer(CustomerDTO customer) throws CustomerException;
    public List<CustomerDTO> displayCustomers() throws CustomerException;
}
