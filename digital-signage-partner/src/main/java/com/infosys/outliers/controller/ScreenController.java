package com.infosys.outliers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.outliers.model.GenericResponse;
import com.infosys.outliers.model.Screen;
import com.infosys.outliers.service.ScreenService;

@RestController
public class ScreenController {

	@Autowired
	private ScreenService screenService;

	@GetMapping(value = "/screens")
	public ResponseEntity<List<Screen>> getAllScreens() {

		return new ResponseEntity<List<Screen>>(screenService.getAllScreens(), HttpStatus.OK);

	}

	@GetMapping(value = "/user/screens")
	public ResponseEntity<List<Screen>> getScreens() {
		Integer id = Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
		return new ResponseEntity<List<Screen>>(screenService.getAllScreensPartners(id), HttpStatus.OK);

	}

	@DeleteMapping(value = "/user/screens/{screenid}")
	public ResponseEntity<GenericResponse> deleteScreen(@PathVariable Integer screenid) {
		
		screenService.deleteScreen(screenid);
		
		GenericResponse response = new GenericResponse(HttpStatus.OK.value(), "Screen Deleted");
		return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);

	}

	@PostMapping(value = "/user/screens")
	public ResponseEntity<Screen> addScreen(@RequestBody Screen screen) {
		
		screen.setPartnerId(Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName()));
		Screen response = screenService.addScreen(screen);
		return new ResponseEntity<Screen>(response, HttpStatus.CREATED);

	}
}
