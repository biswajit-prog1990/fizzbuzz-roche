package com.roche.exam.FizzBuzz.service;

import com.roche.exam.FizzBuzz.entity.StatisticEntity;
import com.roche.exam.FizzBuzz.mapper.StatisticMapper;
import com.roche.exam.FizzBuzz.model.StatisticEndpoint;
import com.roche.exam.FizzBuzz.repo.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatisticServiceImpl implements StatisticService {

    private StatisticRepository statisticRepository;

    @Autowired
    public StatisticServiceImpl(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public StatisticEndpoint findMostCalledEndpoint() {
        return statisticRepository.findMostCalled()
                .map(StatisticMapper::getFromEntity)
                .orElse(new StatisticEndpoint());
    }

    public void saveStatisticParameters(StatisticEndpoint endpoint) {
        StatisticEntity incomingNewEntity = StatisticMapper.getFromObjects(endpoint);
        Optional<StatisticEntity> optionalExistingEntity = statisticRepository.findStatisticEntityByParameters(incomingNewEntity.getParameters());
        optionalExistingEntity.ifPresent(StatisticEntity::incrementCounter);
        statisticRepository.save(optionalExistingEntity.orElse(incomingNewEntity));
    }
}
