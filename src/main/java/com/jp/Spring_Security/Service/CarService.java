package com.jp.Spring_Security.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.Spring_Security.Model.DTO.CarDTO;
import com.jp.Spring_Security.Model.Entity.Car;
import com.jp.Spring_Security.Model.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    CarRepository carRepository;
    ObjectMapper objectMapper;

    @Autowired
    public CarService(CarRepository carRepository, ObjectMapper objectMapper) {
        this.carRepository = carRepository;
        this.objectMapper = objectMapper;
    }

    private List<Car> carList() {
        return carRepository.findAll();
    }

    public String stringedCarList() throws JsonProcessingException {
        return objectMapper.writeValueAsString(carList());
    }

    public void saveCar(CarDTO carDTO){
        Car car = new Car(carDTO);
        carRepository.save(car);
    }
}
