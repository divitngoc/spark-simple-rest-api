package com.divitngoc.application.controller;

import java.util.Arrays;
import java.util.List;

import com.divitngoc.application.model.Car;
import com.divitngoc.application.model.DataResponse;
import com.divitngoc.application.model.ResponseStatus;
import com.divitngoc.application.service.CarService;

import lombok.extern.slf4j.Slf4j;
import spark.Request;
import spark.Response;

@Slf4j
public class CarController {

	private CarService service;

	public CarController(CarService service) {
		this.service = service;
	}

	public DataResponse getAllCars(Request req, Response res) {
		List<Car> carList = service.fetchAllCars();
		return new DataResponse(ResponseStatus.SUCCESS, "", carList);
	}

	public DataResponse getCar(String _id, Car car) {
		DataResponse response = new DataResponse();
		String message = "";
		try {
			car.set_id(_id);
		} catch (IllegalArgumentException e) {
			log.error("Error setting object id");
			message = "ID is not valid, must be in hexadecimal";
			response.setStatus(ResponseStatus.ERROR);
			response.setMessage(message);
			return response;
		}
		car = service.fetchCar(car);

		if (car != null) {
			response.setStatus(ResponseStatus.SUCCESS);
			response.setData(Arrays.asList(car));
		} else {
			response.setStatus(ResponseStatus.ERROR);
			message = "Car does not exist.";
		}
		response.setMessage(message);
		return response;
	}

	public DataResponse saveCar(Car car) {
		service.saveCar(car);
		return new DataResponse(ResponseStatus.SUCCESS, "Car added.", null);
	}

	public DataResponse deleteCar(String _id, Car car) {
		DataResponse response = new DataResponse();
		String message = "";
		try {
			car.set_id(_id);
		} catch (IllegalArgumentException e) {
			log.error("Error setting object id");
			message = "ID is not valid, must be in hexadecimal";
			response.setStatus(ResponseStatus.ERROR);
			response.setMessage(message);
			return response;
		}
		boolean success = service.deleteCar(car);
		if (success) {
			return new DataResponse(ResponseStatus.SUCCESS, "Car deleted.", null);
		} else {
			return new DataResponse(ResponseStatus.ERROR, "Error with deleting.", null);
		}
	}
}
