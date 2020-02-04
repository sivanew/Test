package com.hcl.customer.service;

import com.hcl.customer.dao.Customer;
import com.hcl.customer.vo.CustomerUpdateVO;

public interface CustomerService {

	boolean deleteCustomer(Long id);

	CustomerUpdateVO saveCustomer(CustomerUpdateVO custVO);

	CustomerUpdateVO updateCustomer(CustomerUpdateVO custVO, Long custId);

	Customer getCustomer(Long id);

}
