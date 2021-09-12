package com.event.driven.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.event.driven.producer.model.Event;
import com.event.driven.producer.model.EventType;

@Service
public class EventService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// Getting the activeMqTemplate object for sending the event type to the queue where a consumer
	// is listening and will process the event details further
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Value("${event.queue}")
	String eventQueue;

	public String createEvent(Event event) {
		//TODO: Create the event
		//Sending the message to active mq for further processing
		publishEventToActiveMq(EventType.CREATED);
		final String response = "Event created successfully.";
		return response;
	}
	
	@Async
	private void publishEventToActiveMq(final EventType eventType) {
		logger.info("Sending "+ eventType.name()+" event type to the queue!!");
		jmsTemplate.convertAndSend(eventQueue, eventType.name());
		logger.info("Message successfully sent to the activeMq.");
	}
	
	
}
