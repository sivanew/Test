package com.hcl.customer.serviceimpl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.customer.config.ConfigClass;
import com.hcl.customer.dao.Customer;
import com.hcl.customer.repository.CustomerRepository;
import com.hcl.customer.serviceImpl.CustomerServiceImpl;
import com.hcl.customer.vo.CustomerUpdateVO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ConfigClass.class)
public class CustomerServiceImplTest {

	@Autowired
	private CustomerServiceImpl custSer;

	@MockBean
	private CustomerRepository custRepo;

	/*
	 * @Test public void getCustomerByLastNameTest() { String name = "Test";
	 * when(custRepo.findByLastName(name)) .thenReturn(Stream.of(new Customer(1000L,
	 * "Test", "Test")).collect(Collectors.toList()));
	 * 
	 * assertEquals(1, custSer.getCustomerByLastName(name).size());
	 * 
	 * }
	 */

	/*
	 * @Test public void getCustomerByLastNameNotNullTest() { String name = "Test";
	 * when(custRepo.findByLastName(name)).thenReturn(Stream .of(new Customer(1000L,
	 * "Test", "Test"), new Customer(1000L, "", "")).collect(Collectors.toList()));
	 * 
	 * assertNotEquals(1, custSer.getCustomerByLastName(name).size());
	 * 
	 * }
	 */
	
	@Test
	public void saveCustomerTest() {
		CustomerUpdateVO cust=new CustomerUpdateVO();
		cust.setFirstName("firstName");
		cust.setLastName("lname");
		
		CustomerUpdateVO custVO=custSer.saveCustomer(cust);
		assertNotNull(custVO);
	}
	
	@Test
	public void updateCustomerTest() {
		CustomerUpdateVO cust=new CustomerUpdateVO();
		cust.setFirstName("firstName");
		cust.setLastName("lname");
		CustomerUpdateVO custVO=custSer.updateCustomer(cust,123456l);
		assertNotNull(custVO);
	}
	
	@Test
	public void deleteCustomerTest() {
		boolean deleteRecord = custSer.deleteCustomer(123456l);
		assertEquals(deleteRecord, true);

	}
	
}
