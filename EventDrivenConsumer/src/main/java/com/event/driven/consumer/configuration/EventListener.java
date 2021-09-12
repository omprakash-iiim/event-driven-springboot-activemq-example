package com.event.driven.consumer.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class EventListener {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @JmsListener(destination = "event-queue")
    public void listener(String message){
        logger.info("Event Type received", message);
    }
	
}
