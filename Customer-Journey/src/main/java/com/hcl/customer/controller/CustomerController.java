package com.hcl.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.customer.dao.Customer;
import com.hcl.customer.service.CustomerService;
import com.hcl.customer.vo.CustomerUpdateVO;

/**
 * Customer controller to handle request
 * 
 * @author HCL
 *
 */
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService custService;
	
	@GetMapping(value = "custList/{lastname}")
	public ResponseEntity<List<Customer>> getCustomers(@PathVariable("lastname") String lastname){
		List<Customer> custList=null;
		if(lastname!=null) {
			custList = custService.getCustomers(lastname);
		}
		return new ResponseEntity<>(custList, HttpStatus.OK);
	}

	@GetMapping(value = "getCustomer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
		Customer custDetails = null;
		if (id != null) {
			custDetails = custService.getCustomer(id);
		}
		return new ResponseEntity<>(custDetails, HttpStatus.OK);

	}

	@DeleteMapping(value = "/deleteCustomer/{id}")
	public ResponseEntity<Boolean> deleteCustomer(@PathVariable("id") Long id) {

		return new ResponseEntity<>(this.custService.deleteCustomer(id), HttpStatus.OK);

	}

	@PutMapping(value = "/update/{custId}")
	public ResponseEntity<CustomerUpdateVO> updateCustomer(@RequestBody CustomerUpdateVO custVO,
			@PathVariable Long custId) {
		return new ResponseEntity<>(this.custService.updateCustomer(custVO, custId), HttpStatus.OK);
	}

	@PostMapping(value = "/save")
	public ResponseEntity<CustomerUpdateVO> saveCustomer(@RequestBody CustomerUpdateVO custVO) {
		return new ResponseEntity<>(this.custService.saveCustomer(custVO), HttpStatus.CREATED);
	}

}
