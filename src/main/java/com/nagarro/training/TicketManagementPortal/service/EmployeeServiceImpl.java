package com.nagarro.training.TicketManagementPortal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.TicketManagementPortal.dao.UserDao;
import com.nagarro.training.TicketManagementPortal.domain.User;
import com.nagarro.training.TicketManagementPortal.dto.UserDto;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private UserDao userDao;

	public EmployeeServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public void addEmployee(final UserDto userDto) {
		logger.trace("Service method accessed to add a new employee.");
		User user = new User();
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setRole("ROLE_TRAINEE");
		userDao.save(user);
	}

}
