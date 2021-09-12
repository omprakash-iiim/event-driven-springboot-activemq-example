package com.event.driven.producer.configuration;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class ActiveMqConfiguration {

	@Value("${event.queue}")
	String eventQueue;
	
	@Bean
	Queue queue() {
		return new ActiveMQQueue(eventQueue);
	}

	
}
