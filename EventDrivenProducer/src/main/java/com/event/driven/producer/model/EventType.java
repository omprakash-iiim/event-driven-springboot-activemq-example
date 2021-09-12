package com.event.driven.producer.model;

public enum EventType {

	CREATED("CREATED"),
	DELETED("DELETED"),
	UPDATED("UPDATED");

	public final String eventType;

	EventType(final String eventType) {
		this.eventType = eventType;
	}
	
}
