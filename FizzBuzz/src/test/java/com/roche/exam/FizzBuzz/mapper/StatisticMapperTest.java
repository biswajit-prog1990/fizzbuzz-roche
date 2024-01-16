package com.roche.exam.FizzBuzz.mapper;

import com.roche.exam.FizzBuzz.entity.StatisticEntity;
import com.roche.exam.FizzBuzz.model.Parameters;
import com.roche.exam.FizzBuzz.model.StatisticEndpoint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticMapperTest {

    @Test
    void should_get_from_entity() {
        Parameters parameters = new Parameters();
        parameters.set_int1(1);
        parameters.set_int2(5);
        parameters.set_limit(6);
        parameters.set_str1("fizz");
        parameters.set_str2("buzz");

        StatisticEntity entity = new StatisticEntity();
        entity.set_statisticsId(1L);
        entity.set_counter(1);
        entity.setParameters(parameters);

        StatisticEndpoint endpoint = StatisticMapper.getFromEntity(entity);

        assertAll(
                () -> assertEquals(1, endpoint.get_counter()),
                () -> assertEquals(1, endpoint.getParameters().get_int1()),
                () -> assertEquals(5, endpoint.getParameters().get_int2()),
                () -> assertEquals(6, endpoint.getParameters().get_limit()),
                () -> assertEquals("fizz", endpoint.getParameters().get_str1()),
                () -> assertEquals("buzz", endpoint.getParameters().get_str2())
        );
    }

    @Test
    void should_get_from_objects() {
        Parameters parameters = new Parameters();
        parameters.set_int1(1);
        parameters.set_int2(5);
        parameters.set_limit(6);
        parameters.set_str1("fizz");
        parameters.set_str2("buzz");

        StatisticEndpoint endpoint = new StatisticEndpoint();
        endpoint.setParameters(parameters);
        endpoint.set_counter(1);

        StatisticEntity entity = StatisticMapper.getFromObjects(endpoint);

        assertAll(
                () -> assertEquals(1, entity.get_counter()),
                () -> assertEquals(1, entity.getParameters().get_int1()),
                () -> assertEquals(5, entity.getParameters().get_int2()),
                () -> assertEquals(6, entity.getParameters().get_limit()),
                () -> assertEquals("fizz", entity.getParameters().get_str1()),
                () -> assertEquals("buzz", entity.getParameters().get_str2())
        );
    }
}
