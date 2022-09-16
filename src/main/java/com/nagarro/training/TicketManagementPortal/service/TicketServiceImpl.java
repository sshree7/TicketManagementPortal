package com.nagarro.training.TicketManagementPortal.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nagarro.training.TicketManagementPortal.dao.TicketDao;
import com.nagarro.training.TicketManagementPortal.dao.UserDao;
import com.nagarro.training.TicketManagementPortal.domain.Ticket;
import com.nagarro.training.TicketManagementPortal.domain.User;
import com.nagarro.training.TicketManagementPortal.dto.TicketDto;

@Service
public class TicketServiceImpl implements TicketService {

	Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

	@Autowired
	private TicketDao ticketDao;

	@Autowired
	private UserDao userDao;

	public TicketServiceImpl(TicketDao ticketDao, UserDao userDao) {
		super();
		this.ticketDao = ticketDao;
		this.userDao = userDao;
	}

	public TicketServiceImpl() {
		super();
	}

	// @Cacheable("data")
	// @Cacheable(cacheNames = "tickets", key = "#id")
	public List<TicketDto> getAllTicketsOfAnEmployee(final int id) {
		logger.trace("Service method accessed to get all tickets of an Employee.");
		User user = null;
		user = (User) this.userDao.findById(id);
		final List<Ticket> ticketList = (List<Ticket>) this.ticketDao.findByUser(user);
		List<TicketDto> ticketListDto = new ArrayList<>();
		for (Ticket ticket : ticketList) {
			ticketListDto.add(new TicketDto(ticket.getId(), ticket.getTitle(), ticket.getDepartment(),
					ticket.getDescription(), ticket.getStatus(), ticket.getUser().getUsername()));
		}
		return ticketListDto;
	}

	@Cacheable(cacheNames = "ticket", key = "#id")
	public TicketDto getTicketById(final int id) {
		logger.trace("Service method accessed to get a ticket by id.");
		Ticket ticket = null;
		TicketDto ticketDto = null;
		try {
			ticket = (Ticket) this.ticketDao.findById(id);
			ticketDto = new TicketDto(ticket.getId(), ticket.getTitle(), ticket.getDepartment(),
					ticket.getDescription(), ticket.getStatus(), ticket.getUser().getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticketDto;
	}

	@CachePut(cacheNames = "ticket", key = "#ticketId")
	public void updateTicket(final TicketDto ticketDto, final int ticketId) {
		logger.trace("Service method accessed to update a ticket.");
		Ticket ticket = this.ticketDao.findById(ticketId);
		ticket.setId(ticketId);
		ticket.setTitle(ticketDto.getTitle());
		ticket.setDepartment(ticketDto.getDepartment());
		ticket.setDescription(ticketDto.getDescription());
		ticket.setStatus(ticketDto.getStatus());
		ticketDao.save(ticket);
	}

	public void addTicket(final TicketDto ticketDto, final int employeeId) {
		logger.trace("Service method accessed to add a ticket.");
		User currentEmployee = (User) this.userDao.findById(employeeId);
		Ticket ticket = new Ticket();
		ticket.setDepartment(ticketDto.getDepartment());
		ticket.setUser(currentEmployee);
		ticket.setTitle(ticketDto.getTitle());
		ticket.setDescription(ticketDto.getDescription());
		ticket.setStatus(ticketDto.getStatus());
		ticketDao.save(ticket);
	}

	@CacheEvict(cacheNames = "ticket", key = "#ticketId")
	public void deleteTicket(final int ticketId) {
		logger.trace("Service method accessed to delete a ticket.");
		ticketDao.deleteById(ticketId);
	}

}
