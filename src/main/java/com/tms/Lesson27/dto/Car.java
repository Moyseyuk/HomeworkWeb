package com.tms.Lesson27.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Car {

    private UUID uuid;
    private String brand;
    private Transmission transmission;
    private int productionYear;

    public Car(String brand, Transmission transmission, int productionYear) {
        this.brand = brand;
        this.transmission = transmission;
        this.productionYear = productionYear;
        uuid = UUID.randomUUID();
    }

    public enum Transmission {
        AUTOMATIC, MANUAL
    }
}
