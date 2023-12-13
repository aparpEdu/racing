package com.example.car_racing.racing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RaceSource {
    public static List<Race> getRace(){
        List<Race> race = new ArrayList<>();
        race.add(new Race("Jonathan", "Alfredo", "Red Bull", "Honda", LocalDate.now(), false));
        race.add(new Race("Jonathan", "Alfredo", "Red Bull", "Honda", LocalDate.now(), false));
        return race;
    }
}
