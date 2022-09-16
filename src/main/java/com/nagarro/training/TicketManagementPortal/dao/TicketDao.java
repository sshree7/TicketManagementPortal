package com.nagarro.training.TicketManagementPortal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.training.TicketManagementPortal.domain.Ticket;
import com.nagarro.training.TicketManagementPortal.domain.User;

public interface TicketDao extends JpaRepository<Ticket, Integer> {

	public Ticket findById(final int id);

	public Ticket getTicketByUserId(final int id);

	public List<Ticket> findByUser(final User user);

	public List<Ticket> findByUserId(final int id);

}
