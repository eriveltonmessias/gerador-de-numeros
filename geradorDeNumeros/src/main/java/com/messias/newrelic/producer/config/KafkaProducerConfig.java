package com.messias.newrelic.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaProducerConfig {

	  @Bean
	  public NewTopic topicParPositivo() {
	    return TopicBuilder.name("par-positivo")
	      .partitions(3)
	      .replicas(1)
	      .build();
	  }
	  
	  @Bean
	  public NewTopic topicParNegativo() {
	    return TopicBuilder.name("par-negativo")
	      .partitions(3)
	      .replicas(1)
	      .build();
	  }
	  
	  @Bean
	  public NewTopic topicImparPositivo() {
	    return TopicBuilder.name("impar-positivo")
	      .partitions(3)
	      .replicas(1)
	      .build();
	  }
	  
	  @Bean
	  public NewTopic topicImparNegativo() {
	    return TopicBuilder.name("impar-negativo")
	      .partitions(3)
	      .replicas(1)
	      .build();
	  }
}
