package com.example.routefinder.user;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.routefinder.UnauthorizedException;
import com.example.routefinder.domain.Response;
import com.example.routefinder.domain.UserDTO;
import com.example.routefinder.security.JwtTokenUtil;
import com.example.routefinder.security.JwtUser;








@RestController
@RequestMapping
public class UserController {
	

	@Value("${jwt.header}")
	private String tokenHeader;

	
	@Autowired private UserService userService;
	
	@Autowired private AuthenticationManager authenticationManager;
	@Autowired private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/registration")
	public ResponseEntity <Response> registration (@RequestBody User user ){
		try {
			User dbUser = userService.save(user);
			if(dbUser != null) {
				return new ResponseEntity<Response>(new Response( "User is saved successfully" ), HttpStatus.OK);
			}
			
		}catch(Exception e) {
			
			return new ResponseEntity<Response>(new Response( "User save failed due to: " + e), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Response>(new Response( "User save failed" ), HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/login")
	public ResponseEntity <UserDTO> login (@RequestBody User user, HttpServletRequest request, HttpServletResponse response){
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()  ) );
			final JwtUser userDetails = (JwtUser)authentication.getPrincipal();
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			final String token = jwtTokenUtil.generateToken(userDetails);
			
			response.setHeader("Token", token);
			return new ResponseEntity<UserDTO> (new UserDTO(userDetails.getUser(), token), HttpStatus.OK);
			
		}catch(Exception e) {
			throw new UnauthorizedException(e.getMessage());
		}
	}
	
	
}
