package com.tms.Lesson28.services;


import com.tms.Lesson28.dto.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lapInfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoService {

    @Autowired
    private List<Pair> pairs;

    public void showResults() throws InterruptedException {

        int lapTime = 5;

        for (int i = 1; i <= 5; i++){
            Thread.sleep(5000);
            System.out.println();
            System.out.println("Lap " + i);
            System.out.println("Pair 1: lap time - " + (pairs.get(0).getSpeed()*lapTime*i) + " seconds;");
            System.out.println("Pair 2: lap time - " + (pairs.get(1).getSpeed()*lapTime*i) + " seconds;");
            System.out.println("Pair 3: lap time - " + (pairs.get(2).getSpeed()*lapTime*i) + " seconds;");
        }

    }

}
