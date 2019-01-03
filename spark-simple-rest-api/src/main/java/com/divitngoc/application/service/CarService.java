package com.divitngoc.application.service;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.divitngoc.application.model.Car;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CarService {

	private Datastore datastore = new Morphia().createDatastore(new MongoClient("localhost", 27017), "cardb");

	public List<Car> fetchAllCars() {
		List<Car> carList = datastore.find(Car.class).asList();
		log.info("carList fetched {}", carList);
		return carList;
	}

	public Car fetchCar(Car car) {
		Car carFound = datastore.get(car);
		return carFound;
	}

	public void saveCar(Car car) {
		datastore.save(car);
		log.info("Car added.");
	}

	public boolean deleteCar(Car car) {
		WriteResult result = datastore.delete(car);
		if (result.getN() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
