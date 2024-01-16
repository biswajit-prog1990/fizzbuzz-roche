package com.roche.exam.FizzBuzz.mapper;

import com.roche.exam.FizzBuzz.entity.StatisticEntity;
import com.roche.exam.FizzBuzz.model.Parameters;
import com.roche.exam.FizzBuzz.model.StatisticEndpoint;

public class StatisticMapper {

    public static StatisticEndpoint getFromEntity(StatisticEntity entity) {
        Parameters params = entity.getParameters();
        return StatisticEndpoint.builder().parameters(new Parameters(params.get_int1(), params.get_int2(), params.get_limit(), params.get_str1(), params.get_str2()))._counter(entity.get_counter()).build();
    }

    public static StatisticEntity getFromObjects(StatisticEndpoint endpoint) {
        Parameters params = endpoint.getParameters();
        return new StatisticEntity(0L, endpoint.get_counter(), new Parameters(params.get_int1(), params.get_int2(), params.get_limit(), params.get_str1(), params.get_str2()));
    }
}
