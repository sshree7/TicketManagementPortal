package com.nagarro.training.TicketManagementPortal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.nagarro.training.TicketManagementPortal.mvcController.HomeController;

@SpringBootTest
class TicketManagementPortalApplicationTests {

	@Autowired
	private HomeController homeController;

	@Test
	void testHomeControllerBeanMethod() {
		Assert.notNull(homeController.registerForm(), "Object not null");
	}

}
