package com.tms.Lesson28.configuration;

import com.tms.Lesson28.dto.Horse;
import com.tms.Lesson28.dto.Pair;
import com.tms.Lesson28.dto.Rider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SpringConfig {

    @Bean
    public List<Horse> horses(){
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse(1));
        horses.add(new Horse(2));
        horses.add(new Horse(3));
        return horses;
    }

    @Bean
    public List<Rider> riders(){
        List<Rider> riders = new ArrayList<>();
        riders.add(new Rider(1));
        riders.add(new Rider(2));
        riders.add(new Rider(3));
        return riders;
    }

    @Bean
    public List<Pair> pairs(List<Horse> horses, List<Rider> riders){
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(horses.get(0), riders.get(0)));
        pairs.add(new Pair(horses.get(1), riders.get(1)));
        pairs.add(new Pair(horses.get(2), riders.get(2)));
        return pairs;
    }
}
