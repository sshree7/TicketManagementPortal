package com.nagarro.training.TicketManagementPortal.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.nagarro.training.TicketManagementPortal.restController.TicketController;

@SpringBootTest
public class RestController {

	@Autowired
	private TicketController ticketController;

	@Test
	void contextLoads() {
		Assert.notNull(ticketController, "Object not null");
	}

}
