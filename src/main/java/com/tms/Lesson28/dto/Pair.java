package com.tms.Lesson28.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pair {

    private int number;
    private Horse horse;
    private Rider rider;

    public int getSpeed(){
        return (rider.getLevel() * horse.getSpeed());
    }
}
