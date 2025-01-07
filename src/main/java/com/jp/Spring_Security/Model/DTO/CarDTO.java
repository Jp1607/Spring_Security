package com.jp.Spring_Security.Model.DTO;

public class CarDTO {
    private String model;
    private String brand;

    public CarDTO(String model, String brand) {
        this.model = model;
        this.brand = brand;
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
