package com.pairing;

import com.paring.Population;
import com.paring.model.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PopulationTest {

    @Test
    public void mostPopulationInYearTest() {
        Person p1 = new Person("person1", 1900, 1985);
        Person p2 = new Person("person2", 1962, 2001);
        Person p3 = new Person("person3", 1940, 1985);
        Person p4 = new Person("person4", 1960, 2020);
        Person p5 = new Person("person5", 1905, 1960);
        Population p = new Population(Arrays.asList(p1, p2, p3, p4, p5));
        assertEquals(1960, p.mostPopulationInYear());
    }
}
