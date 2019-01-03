package com.divitngoc.application.controller;

import java.util.List;

import org.bson.types.ObjectId;

import com.divitngoc.application.model.Car;
import com.divitngoc.application.model.DataResponse;
import com.divitngoc.application.model.ResponseStatus;
import com.divitngoc.application.service.CarService;

import spark.Request;
import spark.Response;

public class CarController {

	private CarService service;

	public CarController(CarService service) {
		this.service = service;
	}

	public DataResponse getAllCars(Request req, Response res) {
		List<Car> carList = service.fetchAllCars();
		return new DataResponse(ResponseStatus.SUCCESS, "", carList);
	}

	public DataResponse getCar(String _id) {
		Car car = new Car();
		car.set_id(new ObjectId(_id));
		car = service.fetchCar(car);
		if (car != null) {
			return new DataResponse(ResponseStatus.SUCCESS, "", List.of(car));
		}
		else
		{
			return new DataResponse(ResponseStatus.ERROR, "Car does not exist.", null);
		}
	}

	public DataResponse saveCar(Car car) {
		service.saveCar(car);
		return new DataResponse(ResponseStatus.SUCCESS, "Car added.", null);
	}

	public DataResponse deleteCar(String _id) {
		Car car = new Car();
		car.set_id(new ObjectId(_id));
		boolean success = service.deleteCar(car);
		if (success) {
			return new DataResponse(ResponseStatus.SUCCESS, "Car deleted.", null);
		} else {
			return new DataResponse(ResponseStatus.ERROR, "Error with deleting.", null);
		}
	}
}
