package com.tms.Lesson28.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pair {

    private int number;
    private Horse horse;
    private Rider rider;

    public Pair(Horse horse, Rider rider){
        this.number = rider.getNumber();
        this.horse = horse;
        this.rider = rider;
    }

    public int getSpeed(){
        return (rider.getLevel() * horse.getSpeed());
    }
}
