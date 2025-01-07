package com.jp.Spring_Security.Model.Entity;

import com.jp.Spring_Security.Model.DTO.CarDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car extends DefaultEntity {

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "brand", nullable = false)
    private String brand;

    public Car(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }
    public Car(CarDTO carDTO){
        this.brand = carDTO.getBrand();
        this.model = carDTO.getModel();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
