package com.nagarro.training.TicketManagementPortal.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.training.TicketManagementPortal.domain.User;

public interface UserDao extends JpaRepository<User, Integer> {

	public User findById(final int id);

	public User findByUsername(final String username);

}
