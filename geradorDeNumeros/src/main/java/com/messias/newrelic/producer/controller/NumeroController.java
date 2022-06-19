package com.messias.newrelic.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.messias.newrelic.producer.service.MotorDecisaoService;



@RestController
@RequestMapping("/numero")
public class NumeroController {
	
	@Autowired
	private MotorDecisaoService motor;
	
	
	@GetMapping
	public ResponseEntity<String> test(){
		return ResponseEntity.ok("ok");
	}
	
	@GetMapping("/{numero}")
	public ResponseEntity<Integer> numero(@PathVariable int numero) {
		
		motor.decidir(numero);
		
		return ResponseEntity.ok(numero);
	}

	
}
