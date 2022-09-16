package com.nagarro.training.TicketManagementPortal.service;

import java.util.List;

import com.nagarro.training.TicketManagementPortal.dto.TicketDto;

public interface TicketService {
	public List<TicketDto> getAllTicketsOfAnEmployee(final int id);

	public TicketDto getTicketById(final int id);

	public void updateTicket(final TicketDto ticketDto, final int ticketId);

	public void addTicket(final TicketDto ticketDto, final int employeeId);

	public void deleteTicket(final int ticketId);

}
