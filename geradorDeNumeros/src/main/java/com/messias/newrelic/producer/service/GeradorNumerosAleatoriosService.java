package com.messias.newrelic.producer.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.messias.newrelic.producer.producers.NumeroProducer;

@Service
public class GeradorNumerosAleatoriosService {

	private static final Logger log = LoggerFactory.getLogger(NumeroProducer.class);

	private MotorDecisaoService decisaoService;
	private Random random;

	@Value("${quantidade.de.numeros.gerados}")
	private Integer qtdGerar;

	@Autowired
	public GeradorNumerosAleatoriosService(MotorDecisaoService motorDecisaoService) {
		this.random = new Random();
		this.decisaoService = motorDecisaoService;
	}

	@Scheduled(fixedRate = 50000)
	public void gerar() {
		log.info("Inicio gerador");
		for (int i = 0; i < qtdGerar; i++) {
			decisaoService.decidir(gerarNumero());
		}
	}

	private int gerarNumero() {

		return gerarPositivo() ? gerarNumerosPositivos() : gerarNumerosNegativos();

	}

	private int gerarNumerosPositivos() {

		int n = random.nextInt(100) + 1;

		return n;
	}

	private int gerarNumerosNegativos() {

		int n = (random.nextInt(100) + 1) * -1;

		return n;
	}

	private Boolean gerarPositivo() {
		return random.nextBoolean();
	}
}
