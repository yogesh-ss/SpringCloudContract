package com.example.fraud.fraudservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FraudController {

	@GetMapping("/fraud")
    ResponseEntity<List<String>> getFraud() {
		return ResponseEntity.status(200).body(Arrays.asList("yogesh","nihal"));
	}
}
