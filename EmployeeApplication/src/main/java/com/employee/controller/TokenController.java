package com.employee.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.config.JwtUser;
import com.employee.security.JwtGenerator;
import com.employee.model.JwtResponse;
@RestController
@RequestMapping("/token")
public class TokenController {

	private JwtGenerator jwtGenerator;

	public TokenController(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}

	@PostMapping
	public ResponseEntity<?> generate(@RequestBody final JwtUser jwtUser) {

		final String token =  jwtGenerator.generate(jwtUser);
		return ResponseEntity.ok(new JwtResponse(token));
	}
}
