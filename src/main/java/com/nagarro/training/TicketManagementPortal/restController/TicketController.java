package com.nagarro.training.TicketManagementPortal.restController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.TicketManagementPortal.dto.TicketDto;
import com.nagarro.training.TicketManagementPortal.exception.CustomException;
import com.nagarro.training.TicketManagementPortal.service.TicketServiceImpl;

@Profile("dev")
@RestController
@RequestMapping("/api/employees")
public class TicketController {
	@Autowired
	private TicketServiceImpl ticketService;

	Logger logger = LoggerFactory.getLogger(TicketController.class);

	@GetMapping("/{employeeId}/tickets")
	public ResponseEntity<List<TicketDto>> getAllTicketsOfAnEmployee(@PathVariable("employeeId") int id) {
		logger.trace("Rest api method accessed to get all tickets of an employee");
		final List<TicketDto> ticketList = ticketService.getAllTicketsOfAnEmployee(id);
		if (ticketList.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(ticketList);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping("{employeeId}/tickets/{id}")
	public ResponseEntity<TicketDto> getTicketById(@PathVariable("id") int id,
			@PathVariable("employeeId") int employeeId) throws CustomException {
		logger.trace("Rest api method accessed to get a ticket by id.");
		final TicketDto ticket = ticketService.getTicketById(id);
		if (null == ticket) {
			throw new CustomException("TICKET NOT FOUND");
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(ticket);
		}

	}

	@PutMapping("{employeeId}/tickets/{id}")
	public ResponseEntity<TicketDto> updateTicket(@RequestBody TicketDto ticketDto, @PathVariable("id") int id,
			@PathVariable("employeeId") int employeeId) {
		logger.trace("Rest api method accessed to update a ticket.");
		try {
			ticketService.updateTicket(ticketDto, id);
			return ResponseEntity.ok().body(ticketDto);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PostMapping(value = "{employeeId}/tickets")
	public ResponseEntity<TicketDto> addTicket(@Validated @RequestBody TicketDto ticketDto,
			@PathVariable("employeeId") int employeeId) {
		logger.trace("Rest api method accessed to add a ticket.");
		try {
			ticketService.addTicket(ticketDto, employeeId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

		}
	}

	@DeleteMapping("{employeeId}/tickets/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id, @PathVariable("employeeId") int employeeId) {
		logger.trace("Rest api method accessed to delete a ticket.");
		try {
			ticketService.deleteTicket(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
