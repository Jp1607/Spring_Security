package com.jp.Spring_Security.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jp.Spring_Security.Model.DTO.CarDTO;
import com.jp.Spring_Security.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public ResponseEntity<String> getCars() {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(carService.stringedCarList());
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<String> addCar(@RequestBody CarDTO carDTO) {

        carService.saveCar(carDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
