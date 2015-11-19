package test.login;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.slf4j.Logger;

public class CustomAuthenticationProvider implements AuthenticationProvider{

	static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String userId = (String) authentication.getPrincipal();
		String userPw =(String) authentication.getCredentials();
		
		logger.info("user : "+userId +" , password : "+userPw);
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		 UsernamePasswordAuthenticationToken result = 
				 	new UsernamePasswordAuthenticationToken(userId, userPw, roles);
	        
		 result.setDetails(new CustomUserDetails(userId, userPw));
		 
		return result;
	}

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
