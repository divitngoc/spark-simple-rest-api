package com.divitngoc.application.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataResponse {
	private ResponseStatus status;
	private String message;
	private List<Car> data;

	public DataResponse(ResponseStatus status, String message, List<Car> data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

}
