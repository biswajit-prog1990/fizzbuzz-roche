package com.roche.exam.FizzBuzz.repo;

import com.roche.exam.FizzBuzz.entity.StatisticEntity;
import com.roche.exam.FizzBuzz.model.Parameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticRepository extends JpaRepository<StatisticEntity, Long> {

    @Query("SELECT new StatisticEntity(_statisticsId, MAX(_counter), parameters) FROM StatisticEntity " +
            "GROUP BY parameters, _statisticsId ORDER BY _counter DESC LIMIT 1")
    Optional<StatisticEntity> findMostCalled();

    Optional<StatisticEntity> findStatisticEntityByParameters(Parameters parameters);
}
