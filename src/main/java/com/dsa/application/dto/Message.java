package com.dsa.application.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;


@Data
public class Message {
	private HttpStatus status;
	private String message;
	private Object data;
	
	public Message() {
		this.status = null;
		this.message = null;
		this.data = null;
				
	}
}
