package com.nagarro.training.TicketManagementPortal.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.training.TicketManagementPortal.domain.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@Transactional
public class EmployeeDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	User user;
	
	@Test
	@Order(1)
	public void createUser() {
		User newUser = new User(1000, "MaxBlack", "ROLE_TRAINEE", "1234", null);
		user = userDao.save(newUser);
		assertNotNull(userDao.findByUsername(newUser.getUsername()));
	}

}
