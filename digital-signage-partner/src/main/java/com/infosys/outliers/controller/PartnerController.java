package com.infosys.outliers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.outliers.model.User;
import com.infosys.outliers.service.PartnerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PartnerController {

	@Autowired
	private PartnerService userService;

	@Autowired
	private AuthenticationProvider authenticationProvider;

	@PostMapping(value = "/login")
	public ResponseEntity<User> login(@RequestBody User user) {
		log.info("Trying to login with user id: {}", user.getId());

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getId(),
				user.getPassword());
		Authentication authentication = authenticationProvider.authenticate(token);
		log.info("Logging in with [{}]", token.getName());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// User response = userService.login(user);

		log.info("Login succesfull");

		return new ResponseEntity<User>(userService.getDetails(user.getId()), HttpStatus.OK);
	}

	@PostMapping(value = "/signup")
	public ResponseEntity<User> register(@RequestBody User user) {
		log.info("Trying registraion with user id: {}", user.getId());

		user = userService.register(user);
		log.info("Registraion succesfull");
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@GetMapping(value = "{id}/details")
	@PreAuthorize("#id == authentication.name")
	public ResponseEntity<User> view(@PathVariable Integer id) {

		User response = userService.getDetails(id);
		return new ResponseEntity<User>(response, HttpStatus.CREATED);
	}
}
