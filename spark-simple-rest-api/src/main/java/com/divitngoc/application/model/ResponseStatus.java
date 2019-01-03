package com.divitngoc.application.model;

public enum ResponseStatus {
	SUCCESS("Success"),
	ERROR("Error");

	private String status;

	private ResponseStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}