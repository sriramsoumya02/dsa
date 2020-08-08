package com.paring.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {

    @Test
    public void validatePerson() {
        Person xyz = new Person("xyz", 1960, 1970);
        assertEquals("xyz", xyz.getName());
        assertEquals(1960, xyz.getBirthYear());
        assertEquals(1970, xyz.getDeathYear());
        assertTrue(xyz.getDeathYear() < 2020);
    }

}
