package com.tms.Lesson28.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Rider {
    private int number;
    private int level;

    public Rider(int number){
        this.number = number;
        this.level = (int) ( 1 + Math.random() * 9 );
    }
}
