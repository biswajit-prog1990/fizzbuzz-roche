package com.roche.exam.FizzBuzz.service;

import com.roche.exam.FizzBuzz.model.StatisticEndpoint;

public interface StatisticService {

    StatisticEndpoint findMostCalledEndpoint();

    void saveStatisticParameters(StatisticEndpoint endpoint);
}
