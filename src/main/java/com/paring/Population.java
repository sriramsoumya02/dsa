package com.paring;

import com.paring.model.Person;

import java.util.Arrays;
import java.util.List;

public class Population {
    List<Person> personsList;

    public Population(List<Person> personsList) {
        this.personsList = personsList;
    }

    public int mostPopulationInYear() {
        List<Person> input = this.personsList;
        int[] populationyear = new int[2022 - 1900];
        Arrays.fill(populationyear, 0);
        for (Person person : input) {
            populationyear[person.getBirthYear() - 1900] += 1;
            populationyear[person.getDeathYear() + 1 - 1900] -= 1;
        }
        int maxValue = populationyear[0];
        int maxIndex = 0;
        for (int i = 1; i < populationyear.length; i++) {
            populationyear[i] += populationyear[i - 1];
            if (maxValue < populationyear[i]) {
                maxValue = populationyear[i];
                maxIndex = i;
            }
        }

        return maxIndex + 1900;
    }
}
