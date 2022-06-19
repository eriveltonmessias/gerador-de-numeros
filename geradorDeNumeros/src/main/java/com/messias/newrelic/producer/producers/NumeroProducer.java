package com.messias.newrelic.producer.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NumeroProducer {

	private static final Logger log = LoggerFactory.getLogger(NumeroProducer.class);
	
	@Value("${topic.par.positvo}")
	private String topicParPositvo;
	
	@Value("${topic.par.negativo}")
	private String topicParNegativo;
	
	@Value("${topic.impar.postivo}")
	private String topicImparPositvo;
	
	@Value("${topic.impar-negativo}")
	private String topicImparNegativo;
	
	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public NumeroProducer( KafkaTemplate<String, String> kafkaTemplate) {
	
		this.kafkaTemplate = kafkaTemplate;
	}
	
	
	public void sendParPositivo(String numero) {
		kafkaTemplate.send(topicParPositvo, numero)
		.addCallback(
				sucess -> log.info("PAR-POSITIVO enviada"),
				fail -> log.error("PAR-POSITIVO não envida"));
	}
	
	
	public void sendParNegativo(String numero) {
		kafkaTemplate.send(topicParNegativo, numero)
		.addCallback(
				sucess -> log.info("PAR-NEGATIVO enviada"),
				fail -> log.error("PAR-NEGATIVO não envida"));
	}
	
	public void sendImparPositivo(String numero) {
		kafkaTemplate.send(topicImparPositvo, numero)
		.addCallback(
				sucess -> log.info("IMPAR-POSITIVO enviada"),
				fail -> log.error("IMPAR-POSITIVO não envida"));
	}
	
	public void sendImparNegativo(String numero) {
		kafkaTemplate.send(topicImparNegativo, numero)
		.addCallback(
				sucess -> log.info("IMPAR-NEGATIVO enviada"),
				fail -> log.error("IMPAR-NEGATIVO não envida"));
	}
	
}
