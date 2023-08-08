package com.tms.Lesson28.services;


import com.tms.Lesson28.dto.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RaceService {

    private Pair pair1;
    private Pair pair2;
    private Pair pair3;

    public int compare (){
        if (pair1.getSpeed() > pair2.getSpeed()){
            if (pair1.getSpeed() > pair3.getSpeed()){
                return 1;
            } else{
                return 3;
            }
        } else if (pair2.getSpeed() > pair3.getSpeed()){
            return 2;
        } else {
            return 3;
        }
    }


}
