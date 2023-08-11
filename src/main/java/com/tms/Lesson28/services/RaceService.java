package com.tms.Lesson28.services;


import com.tms.Lesson28.dto.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("raceInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RaceService {

    @Autowired
    private List<Pair> pairs;

    public int compare (){
        if (pairs.get(0).getSpeed() > pairs.get(1).getSpeed()){
            if (pairs.get(0).getSpeed() > pairs.get(2).getSpeed()){
                return 1;
            } else{
                return 3;
            }
        } else if (pairs.get(1).getSpeed() > pairs.get(2).getSpeed()){
            return 2;
        } else {
            return 3;
        }
    }


}
