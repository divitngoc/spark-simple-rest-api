package com.divitngoc.application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doThrow;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import com.divitngoc.application.model.Car;
import com.divitngoc.application.service.CarService;

import spark.Request;
import spark.Response;

@RunWith(MockitoJUnitRunner.class)
class CarControllerTest {

	private CarService service;
	private Request req;
	private Response res;
	private CarController controller;

	@BeforeEach
	public void setup() {
		service = mock(CarService.class);
		req = mock(Request.class);
		res = mock(Response.class);
		controller = new CarController(service);
	}

	@Test
	public void testGetAllCars() {
		when(service.fetchAllCars()).thenReturn(Arrays.asList(mock(Car.class)));

		assertNotNull(controller.getAllCars(req, res));
		assertEquals(1, controller.getAllCars(req, res).getData().size());
		assertEquals("SUCCESS", controller.getAllCars(req, res).getStatus().name());
	}

	@Test
	public void testGetCar() {
		Car car = mock(Car.class);
		when(service.fetchCar(any(Car.class)))
				.thenReturn(car)
				.thenReturn(null);

		assertEquals("SUCCESS", controller.getCar("test", car).getStatus().name());
		assertEquals("ERROR", controller.getCar("test", car).getStatus().name());
		
		doThrow(IllegalArgumentException.class).when(car).set_id(anyString());
		assertEquals("ERROR", controller.getCar("test", car).getStatus().name());
	}

	@Test
	public void testSaveCar() {
		assertEquals("SUCCESS", controller.saveCar(mock(Car.class)).getStatus().name());
	}

	@Test
	public void testDeleteCar() {
		Car car = mock(Car.class);
		when(service.deleteCar(any(Car.class)))
				.thenReturn(true)
				.thenReturn(false);

		assertEquals("SUCCESS", controller.deleteCar("test", car).getStatus().name());
		assertEquals("ERROR", controller.deleteCar("test", car).getStatus().name());
		
		doThrow(IllegalArgumentException.class).when(car).set_id(anyString());
		assertEquals("ERROR", controller.deleteCar("test", car).getStatus().name());
	}
}
