package test.controller;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.login.CustomUserDetails;

@Controller
public class LoginController {

	static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void login(HttpSession session) {
		logger.info("Welcome login! {}", session.getId());
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public void logout(HttpSession session) {
		CustomUserDetails userDetails = (CustomUserDetails)session.getAttribute("userLoginInfo");
		logger.info("Welcome logout! {}, {}", session.getId(), userDetails.getUsername());
		session.invalidate();
	}
	
/*	@RequestMapping(value = "main", method = RequestMethod.GET)
	public void login_success(HttpSession session) {
		CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
		logger.info("Welcome login_success! {}, {}", session.getId(), userDetails.getUsername() + "/" + userDetails.getPassword());
		session.setAttribute("userLoginInfo", userDetails);
	}*/
	
	@RequestMapping(value = "login_duplicate", method = RequestMethod.GET)
	public void login_duplicate() {		
		logger.info("Welcome login_duplicate!");
	}
}
