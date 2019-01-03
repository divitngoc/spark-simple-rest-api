package com.divitngoc.application;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.delete;

import com.divitngoc.application.controller.CarController;
import com.divitngoc.application.model.Car;
import com.divitngoc.application.service.CarService;
import com.google.gson.Gson;

public class Application {

	private static final String CARS_PATH = "/api/cars";

	public static void main(String[] args) {
		CarController carController = new CarController(new CarService());
		Gson gson = new Gson();
		
		get(CARS_PATH, (req, res) -> {
			res.type("application/json");
			return carController.getAllCars(req, res);
		}, gson::toJson);

		get(CARS_PATH + "/:id", (req, res) -> {
			res.type("application/json");
			return carController.getCar(req.params(":id"));

		}, gson::toJson);

		post(CARS_PATH, (req, res) -> {
			res.type("application/json");
			Car car = gson.fromJson(req.body(), Car.class);
			return carController.saveCar(car);
		}, gson::toJson);

		delete(CARS_PATH + "/:id", (req, res) -> {
			res.type("application/json");
			return carController.deleteCar(req.params(":id"));

		}, gson::toJson);
	}

}