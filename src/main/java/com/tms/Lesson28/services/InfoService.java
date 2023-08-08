package com.tms.Lesson28.services;


import com.tms.Lesson28.dto.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoService {

    private Pair pair1;
    private Pair pair2;
    private Pair pair3;

    public void showResults() throws InterruptedException {

        int lapTime = 5;

        for (int i = 1; i <= 5; i++){
            Thread.sleep(5000);
            System.out.println();
            System.out.println("Lap " + i);
            System.out.println("Pair 1: lap time - " + (pair1.getSpeed()*lapTime*i) + " seconds;");
            System.out.println("Pair 2: lap time - " + (pair2.getSpeed()*lapTime*i) + " seconds;");
            System.out.println("Pair 3: lap time - " + (pair3.getSpeed()*lapTime*i) + " seconds;");
        }

    }

}
