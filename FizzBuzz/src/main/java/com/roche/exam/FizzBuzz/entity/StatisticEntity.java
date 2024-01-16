package com.roche.exam.FizzBuzz.entity;

import com.roche.exam.FizzBuzz.model.Parameters;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "statistics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statistics_seq")
    @SequenceGenerator(name = "statistics_seq", sequenceName = "_statistics_id_seq", allocationSize = 1)
    private Long _statisticsId;

    @Column(name = "occurrences", nullable = false)
    private int _counter;

    @Embedded
    private Parameters parameters;

    public void incrementCounter() {
        _counter = _counter + 1;
    }
}
