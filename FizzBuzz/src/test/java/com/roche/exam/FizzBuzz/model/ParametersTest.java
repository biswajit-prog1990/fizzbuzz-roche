package com.roche.exam.FizzBuzz.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParametersTest {

    Parameters parameters = new Parameters(5, 9, 10, "fizz", "buzz");

    @Test
    void should_create_parameters() {

        assertAll(
                () -> assertNotNull(parameters),
                () -> assertTrue(parameters.get_int1() != 0),
                () -> assertTrue(parameters.get_int2() != 0),
                () -> assertTrue(parameters.get_limit() > 0),
                () -> assertEquals(parameters.get_int1(), 5),
                () -> assertEquals(parameters.get_int2(), 9),
                () -> assertEquals(parameters.get_limit(), 10),
                () -> assertEquals(parameters.get_str1(), "fizz"),
                () -> assertEquals(parameters.get_str2(), "buzz")
        );
    }

    @Test
    void should_successfully_create_statistic_endpoint() {

        StatisticEndpoint endpoint = new StatisticEndpoint(parameters, 1);

        assertAll(
                () -> assertNotNull(endpoint),
                () -> assertEquals(endpoint.getParameters().get_int1(), 5),
                () -> assertEquals(endpoint.getParameters().get_int2(), 9),
                () -> assertEquals(endpoint.getParameters().get_limit(), 10),
                () -> assertEquals(endpoint.getParameters().get_str1(), "fizz"),
                () -> assertEquals(endpoint.getParameters().get_str2(), "buzz")
        );
    }
}
