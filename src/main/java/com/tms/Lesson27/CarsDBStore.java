package com.tms.Lesson27;

import com.tms.Lesson27.dto.Car;

import java.util.ArrayList;
import java.util.List;

public class CarsDBStore {

    private List<Car> cars = new ArrayList<>();
    private static CarsDBStore instance = null;

    private CarsDBStore(){
    }

    public static CarsDBStore getInstance(){
        if (instance == null){
            instance = new CarsDBStore();
        }
        return instance;
    }

    public void add(Car car){
        cars.add(car);
    }

    public void delete (Car car){
        cars.remove(car);
    }

    public List<Car> getAll(){
        return cars;
    }
}
