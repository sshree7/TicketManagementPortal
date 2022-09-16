package com.nagarro.training.TicketManagementPortal.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.training.TicketManagementPortal.domain.Ticket;
import com.nagarro.training.TicketManagementPortal.domain.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@Transactional
public class TicketDaoTest {

	@Autowired
	private TicketDao ticketDao;

	@Autowired
	private UserDao userDao;

	List<Ticket> ticketList;
	User user;

	@Test
	@Order(1)
	public void createTicket() {
		User newUser = new User(1000, "MaxBlack", "ROLE_TRAINEE", "1234", null);
		Ticket ticket1 = new Ticket(601, "Need admin access", "Software", "Need to update JDK to 1.8", "Active",
				newUser);
		List<Ticket> newTicketList = new ArrayList<>();
		newTicketList.add(ticket1);
		newUser.setTicketList(newTicketList);
		Ticket savedTicket = (Ticket) this.ticketDao.save(ticket1);
		Ticket currentTicket = (Ticket) this.ticketDao.findById(savedTicket.getId());
		assertThat(currentTicket.getId()).isEqualTo(savedTicket.getId());
		// assertThat(currentTicket.getId()).isEqualTo(1);
	}

	@Test
	@Order(2)
	public void getAllTicketsOfAnEmployee() {

		User newUser = new User(1000, "MaxBlack", "ROLE_TRAINEE", "1234", null);
		Ticket ticket1 = new Ticket(601, "Need admin access", "Software", "Need to update JDK to 1.8", "Active",
				newUser);
		List<Ticket> newTicketList = new ArrayList<>();
		newTicketList.add(ticket1);
		newUser.setTicketList(newTicketList);
		User savedUser = this.userDao.save(newUser);
		// Ticket savedTicket = (Ticket) this.ticketDao.save(ticket1);
		List<Ticket> currentTicketList = (List<Ticket>) this.ticketDao.findByUser(savedUser);
		assertThat(currentTicketList.size()).isEqualTo(newTicketList.size());
		// assertThat(currentTicketList.size()).isEqualTo(100000);

	}

	@Test
	@Order(3)
	public void getTicketById() {

		User newUser = new User(1000, "MaxBlack", "ROLE_TRAINEE", "1234", null);
		Ticket ticket1 = new Ticket(601, "Need admin access", "Software", "Need to update JDK to 1.8", "Active",
				newUser);
		List<Ticket> newTicketList = new ArrayList<>();
		newTicketList.add(ticket1);
		newUser.setTicketList(newTicketList);
		Ticket savedTicket = this.ticketDao.save(ticket1);
		Ticket currentTicket = (Ticket) this.ticketDao.findById(savedTicket.getId());
		assertThat(currentTicket.getId()).isEqualTo(savedTicket.getId());
		// assertThat(currentTicket.getId()).isEqualTo(-90);
	}

	@Test
	@Order(4)
	public void updateTicketById() {
		User newUser = new User(1000, "MaxBlack", "ROLE_TRAINEE", "1234", null);
		Ticket ticket1 = new Ticket(601, "Need admin access", "Software", "Need to update JDK to 1.8", "Active",
				newUser);
		List<Ticket> newTicketList = new ArrayList<>();
		newTicketList.add(ticket1);
		newUser.setTicketList(newTicketList);
		Ticket savedTicket = this.ticketDao.save(ticket1);
		savedTicket.setStatus("Tested");
		Ticket currentTicket = (Ticket) this.ticketDao.findById(savedTicket.getId());
		assertThat(currentTicket.getStatus()).isEqualTo("Tested");
		// assertThat(currentTicket.getStatus()).isEqualTo("Active");

	}

	@Test
	@Order(5)
	public void deleteTicketById() {
		List<Ticket> currentList = ticketDao.findByUser(user);
		for (Ticket ticket : currentList) {
			int ticketId = ticket.getId();
			ticketDao.deleteById(ticketId);
			assertThat(ticketDao.existsById(ticketId)).isFalse();
		}

	}
}
