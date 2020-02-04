package com.hcl.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.customer.dao.Customer;

/**
 * Customer Repository
 * 
 * @author HCL
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
