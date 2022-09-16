package com.nagarro.training.TicketManagementPortal.mvcController;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.training.TicketManagementPortal.dao.UserDao;
import com.nagarro.training.TicketManagementPortal.domain.User;
import com.nagarro.training.TicketManagementPortal.dto.TicketDto;
import com.nagarro.training.TicketManagementPortal.exception.CustomException;
import com.nagarro.training.TicketManagementPortal.service.TicketServiceImpl;

@Controller
public class PortalController {

	Logger logger = LoggerFactory.getLogger(PortalController.class);

	@Autowired
	private TicketServiceImpl ticketService;

	@Autowired
	private UserDao userDao;

	@GetMapping("/user/welcome")
	public String welcomeGet(Model model, Principal principal, HttpServletRequest request,
			HttpServletResponse response) {
		logger.trace("Method accessed to open the welcome page.");
		String username = principal.getName();
		User user = (User) this.userDao.findByUsername(username);
		final List<TicketDto> ticketList = ticketService.getAllTicketsOfAnEmployee(user.getId());
		model.addAttribute("ticketList", ticketList);
		model.addAttribute("user", user);
		HttpSession session = request.getSession();
		session.setAttribute("userId", user.getId());
		session.setAttribute("username", username);
		session.setAttribute("ticketList", ticketList);
		session.setAttribute("user", user);
		return "welcome";
	}

	@PostMapping(value = "/user/addTicketForm")
	public String addTicketFormPost() {
		return "addTicket";

	}

	@PostMapping(value = "/user/addTicket")
	public String addTicket(@RequestParam String title, String description, String status, String department,
			HttpServletRequest request) {
		logger.trace("Method accessed to add ticket.");
		HttpSession session = request.getSession();
		final String username = (String) session.getAttribute("username");
		User user = (User) this.userDao.findByUsername(username);
		System.out.println(user.getUsername() + "adddd");
		TicketDto ticketDto = new TicketDto(0, title, department, description, status, user.getUsername());
		ticketService.addTicket(ticketDto, user.getId());
		final List<TicketDto> ticketList = ticketService.getAllTicketsOfAnEmployee(user.getId());
		session.setAttribute("ticketList", ticketList);
		System.out.println("Done adding");
		return "redirect:/user/welcome";

	}

	@GetMapping("/user/editTicketForm")
	public String editBookForm(@RequestParam("id") String id, Model model) throws CustomException {
		int ticketId = Integer.parseInt(id);
		model.addAttribute("id", id);
		TicketDto ticket = ticketService.getTicketById(ticketId);
		if (ticket == null) {
			throw new CustomException("TICKET NOT FOUND");
		}
		model.addAttribute("ticket", ticket);
		return "editTicket";
	}

	@PostMapping(value = "/user/editTicket")
	public String editTicket(@RequestParam String id, String title, String description, String status,
			String department, HttpServletRequest request) {
		logger.trace("Method accessed to update ticket.");
		int ticketId = Integer.parseInt(id);
		HttpSession session = request.getSession();
		final String username = (String) session.getAttribute("username");
		User user = (User) this.userDao.findByUsername(username);
		TicketDto ticketDto = new TicketDto();
		ticketDto.setTitle(title);
		ticketDto.setDepartment(department);
		ticketDto.setDescription(description);
		ticketDto.setStatus(status);
		ticketService.updateTicket(ticketDto, ticketId);
		final List<TicketDto> ticketList = ticketService.getAllTicketsOfAnEmployee(user.getId());
		session.setAttribute("ticketList", ticketList);
		return "redirect:/user/welcome";

	}

	@GetMapping("/user/delete")
	public String delete(Model model, Principal principal, HttpServletRequest request, HttpServletResponse response)
			throws CustomException {
		logger.trace("Method accessed to delete ticket.");
		HttpSession session = request.getSession();
		final String username = (String) session.getAttribute("username");
		System.out.println(username);
		final int ticketId = Integer.parseInt(request.getParameter("id"));
		TicketDto ticket = ticketService.getTicketById(ticketId);
		if (ticket == null) {
			throw new CustomException("TICKET NOT FOUND");
		}
		ticketService.deleteTicket(ticketId);
		User user = (User) this.userDao.findByUsername(username);
		final List<TicketDto> ticketList = ticketService.getAllTicketsOfAnEmployee(user.getId());
		session.setAttribute("ticketList", ticketList);
		session.setAttribute("user", user);
		return "redirect:/user/welcome";
	}

}
