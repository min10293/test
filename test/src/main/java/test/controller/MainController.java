package test.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.login.CustomAuthenticationProvider;
import test.login.CustomUserDetails;

@Controller
public class MainController {
	
	static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public void main(HttpSession session) {		
		CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
		logger.info("Welcome login_success! {}, {}", session.getId(), userDetails.getUsername() + "/" + userDetails.getPassword());
		session.setAttribute("userLoginInfo", userDetails);
	}
	
/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main1() {	

		System.out.println(" bb  ");
		
		return "home";
	}*/
}
