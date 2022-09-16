package com.nagarro.training.TicketManagementPortal.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nagarro.training.TicketManagementPortal.dao.UserDao;
import com.nagarro.training.TicketManagementPortal.dto.UserDto;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Mock
	private UserDao userDao;

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;

	@Mock
	private UserDto userDto;

	@BeforeEach
	void setUp() {
		this.employeeServiceImpl = new EmployeeServiceImpl(this.userDao);
	}

	@Test
	void testAddEmployee() {
		UserDto newUser = new UserDto(1000, "MaxBlack", "1234");
		employeeServiceImpl.addEmployee(newUser);
		verify(userDao).save(any());
	}
}
