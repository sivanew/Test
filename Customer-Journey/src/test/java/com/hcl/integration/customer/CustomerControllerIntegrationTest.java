package com.hcl.integration.customer;
  

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.customer.config.ConfigClass;
import com.hcl.customer.dao.Customer;
import com.hcl.customer.service.CustomerService;
  
@RunWith(SpringRunner.class)
@SpringBootTest(classes=ConfigClass.class)
@AutoConfigureMockMvc
public class CustomerControllerIntegrationTest {

	@MockBean
	private transient CustomerService custService;

	private transient MockMvc mockMvc;

	@Autowired
	public WebApplicationContext context;

	private transient Customer cust;

	@Autowired
	public ObjectMapper mapper;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		cust = new Customer();
		cust.setFirstName("test");
		cust.setLastName("test");

	}

	@Test
	public void findByCustomer() throws Exception {
		mockMvc.perform(get("/customer/getCustomer/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void saveCustomer() throws Exception {
		mockMvc.perform(
				post("/customer/save").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(cust)))
				.andExpect(status().isCreated());

	}

	@Test
	public void updateCustomer() throws Exception {
		mockMvc.perform(put("/customer/update/1").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(cust))).andExpect(status().isOk());

	}
	@Test
	public void deleteCustomer() throws Exception {
		mockMvc.perform(delete("/customer/deleteCustomer/1").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(cust))).andExpect(status().isOk());

	}
}
 