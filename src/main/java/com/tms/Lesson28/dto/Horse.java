package com.tms.Lesson28.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Horse {
    private int number;
    private int speed;

    public Horse(int number){
        this.number = number;
        this.speed = (int) ( 1 + Math.random() * 59 );
    }
}
