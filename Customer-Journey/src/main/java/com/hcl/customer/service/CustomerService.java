package com.hcl.customer.service;

import java.util.List;

import com.hcl.customer.dao.Customer;
import com.hcl.customer.vo.CustomerUpdateVO;

public interface CustomerService {

	boolean deleteCustomer(Long id);

	CustomerUpdateVO saveCustomer(CustomerUpdateVO custVO);

	CustomerUpdateVO updateCustomer(CustomerUpdateVO custVO, Long custId);

	Customer getCustomer(Long id);

	List<Customer> getCustomers(String lastname);

}
