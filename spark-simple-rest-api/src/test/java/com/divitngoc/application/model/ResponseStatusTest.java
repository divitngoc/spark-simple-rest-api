package com.divitngoc.application.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ResponseStatusTest {

	@Test
	public void testResponseStatusValues() {
		ResponseStatus[] status = ResponseStatus.values();
		assertEquals(2, status.length);
	}

	@Test
	public void testResponseStatusGetStatus() {
		assertEquals("Success", ResponseStatus.SUCCESS.getStatus());
		assertEquals("Error", ResponseStatus.ERROR.getStatus());
	}
}
