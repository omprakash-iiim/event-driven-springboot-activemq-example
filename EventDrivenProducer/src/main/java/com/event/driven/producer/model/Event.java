package com.event.driven.producer.model;

public class Event {
	
	public final int id;
	public final String name;
	
	public Event(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	

}
