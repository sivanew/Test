package com.hcl.customer.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.customer.dao.Customer;
import com.hcl.customer.exception.CustomerException;
import com.hcl.customer.repository.CustomerRepository;
import com.hcl.customer.service.CustomerService;
import com.hcl.customer.vo.CustomerUpdateVO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository custRepo;

	@Override
	public boolean deleteCustomer(Long id) {
		custRepo.deleteById(id);
		return true;
	}

	@Override
	public CustomerUpdateVO updateCustomer(CustomerUpdateVO custVO, Long custId) {
		Optional<Customer> customer = custRepo.findById(custId);
		CustomerUpdateVO cust = null;
		if (customer != null) {
			custVO.setId(custId);
			cust = saveCustomerData(custVO);
		} else {
			throw new CustomerException("Invalid Cutomer");
		}
		return cust;
	}

	@Override
	public CustomerUpdateVO saveCustomer(CustomerUpdateVO custVO) {
		CustomerUpdateVO cust = saveCustomerData(custVO);
		return cust;
	}

	public CustomerUpdateVO saveCustomerData(CustomerUpdateVO custVO) {
		Customer customerEntity = new Customer();
		customerEntity.setFirstName(custVO.getFirstName());
		customerEntity.setLastName(custVO.getLastName());
		customerEntity.setId(custVO.getId());
		custRepo.save(customerEntity);
		return custVO;
	}

	@Override
	public Customer getCustomer(Long id) {
		return this.custRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("The id is invalid"));
	}

	@Override
	public List<Customer> getCustomers(String lastname) {
		
		List<Customer> custList = custRepo.findByLastName(lastname);
		
		return custList;
	}

}
