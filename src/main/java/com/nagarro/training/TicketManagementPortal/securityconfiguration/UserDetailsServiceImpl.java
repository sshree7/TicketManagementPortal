package com.nagarro.training.TicketManagementPortal.securityconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.nagarro.training.TicketManagementPortal.dao.UserDao;
import com.nagarro.training.TicketManagementPortal.domain.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// fetching user from the DB
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		return customUserDetails;
	}

}