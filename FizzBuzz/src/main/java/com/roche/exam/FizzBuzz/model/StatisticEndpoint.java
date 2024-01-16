package com.roche.exam.FizzBuzz.model;

import jakarta.persistence.Embedded;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class StatisticEndpoint {

    @Embedded
    private Parameters parameters;
    private int _counter;

    public StatisticEndpoint(Parameters parameters, int counter) {
        this.parameters = parameters;
        this._counter = counter;
    }
}
