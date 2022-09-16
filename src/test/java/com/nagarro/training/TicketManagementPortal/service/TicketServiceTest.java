package com.nagarro.training.TicketManagementPortal.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nagarro.training.TicketManagementPortal.dao.TicketDao;
import com.nagarro.training.TicketManagementPortal.dao.UserDao;
import com.nagarro.training.TicketManagementPortal.domain.Ticket;
import com.nagarro.training.TicketManagementPortal.domain.User;
import com.nagarro.training.TicketManagementPortal.dto.TicketDto;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {

	@Mock
	private TicketDao ticketDao;

	@Mock
	private UserDao userDao;

	@Mock
	private User user;
	@Mock
	private TicketDto ticketDto;

	@Mock
	private Ticket ticket;

	@Mock
	private List<Ticket> ticketlist;

	@InjectMocks
	private TicketServiceImpl ticketServiceImpl;

	@BeforeEach
	void setUp() {
		this.ticketServiceImpl = new TicketServiceImpl(this.ticketDao, this.userDao);
	}

	@Test
	void getAllTicketsOfAnEmployee() {

		User newUser = new User(1000, "MaxBlack", "ROLE_TRAINEE", "1234", null);
		Ticket ticket1 = new Ticket(601, "Need admin access", "Software", "Need to update JDK to 1.8", "Active",
				newUser);
		List<Ticket> newTicketList = new ArrayList<>();
		newTicketList.add(ticket1);
		newUser.setTicketList(newTicketList);

		when(this.userDao.findById(1000)).thenReturn(newUser);
		when(this.ticketDao.findByUser(newUser)).thenReturn(newTicketList);
		ticketServiceImpl.getAllTicketsOfAnEmployee(newUser.getId());
		verify(ticketDao).findByUser(newUser);
		verify(userDao).findById(newUser.getId());
	}

	@Test
	void testAddTicket() {

		User newUser = new User(1000, "MaxBlack", "ROLE_TRAINEE", "1234", null);
		TicketDto ticketDto1 = new TicketDto(601, "Need admin access", "Software", "Need to update JDK to 1.8",
				"Active", newUser.getUsername());
		ticketServiceImpl.addTicket(ticketDto1, newUser.getId());
		verify(ticketDao).save(any());

	}

	@Test
	void testUpdateTicket() {

		User newUser = new User(1000, "MaxBlack", "ROLE_TRAINEE", "1234", null);
		TicketDto ticketDto1 = new TicketDto(601, "Need admin access", "Software", "Need to update JDK to 1.8",
				"Active", newUser.getUsername());

		when(this.ticketDao.findById(601)).thenReturn(ticket);
		ticketServiceImpl.updateTicket(ticketDto1, ticketDto1.getId());
		verify(ticketDao).save(ticket);

	}

	@Test
	void testDeleteTicket() {
		ticketServiceImpl.deleteTicket(ticket.getId());
		verify(ticketDao).deleteById(ticket.getId());
	}

}