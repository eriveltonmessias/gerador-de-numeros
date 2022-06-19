package com.messias.newrelic.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.messias.newrelic.producer.producers.NumeroProducer;

@Service
public class MotorDecisaoService {

	@Autowired
	private NumeroProducer numeroProducer;
	
 public void decidir(int numero) {	 
     if(numero % 2 == 0) 
		 par(numero);
     else
     impar(numero);
	 
 }
 
 
 private void par(int numero) {
	 if (numero > 0)
	numeroProducer.sendParPositivo(String.valueOf(numero));
	else
		numeroProducer.sendParNegativo(String.valueOf(numero));
 }
 private void impar(int numero) {
	 if (numero > 0)
		numeroProducer.sendImparPositivo(String.valueOf(numero));
	else
	 numeroProducer.sendImparNegativo(String.valueOf(numero));
 }
	
}
