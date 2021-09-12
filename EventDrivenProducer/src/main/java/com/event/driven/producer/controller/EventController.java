package com.event.driven.producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.driven.producer.model.Event;
import com.event.driven.producer.service.EventService;

@RestController
@RequestMapping(value= "/event")
public class EventController {
	
	@Autowired
	EventService eventService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping(value= "/create")
	public ResponseEntity<String> create(@RequestBody final Event event) {
		logger.info("event processing");
		final String response = eventService.createEvent(event);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
