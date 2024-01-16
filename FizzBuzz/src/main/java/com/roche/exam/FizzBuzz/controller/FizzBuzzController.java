package com.roche.exam.FizzBuzz.controller;

import com.roche.exam.FizzBuzz.model.Parameters;
import com.roche.exam.FizzBuzz.model.StatisticEndpoint;
import com.roche.exam.FizzBuzz.service.StatisticServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/fizzbuzz")
public class FizzBuzzController {

    private final StatisticServiceImpl statisticService;

    @Autowired
    public FizzBuzzController(StatisticServiceImpl statisticService) {
        this.statisticService = statisticService;
    }

    @Operation(summary = "Get the fizz buzz response based on the specified parameters")
    @GetMapping
    public ResponseEntity<String> getFizzBuzz(@RequestParam int _int1, @RequestParam int _int2,
                                              @RequestParam int _limit, @RequestParam String _str1,
                                              @RequestParam String _str2) {
        //Check if the integer values are 0
        if (_int1 == 0 || _int2 == 0)
            throw new IllegalArgumentException("int1 or int2 shouldn't be equal to zero");
        //Check if _limit less than 1
        if (_limit < 1)
            throw new IllegalArgumentException("limit shouldn't be zero or negative");
        //Add value to Statistic Service
        StatisticEndpoint endpoint = new StatisticEndpoint(new Parameters(_int1, _int2, _limit, _str1, _str2), 1);
        statisticService.saveStatisticParameters(endpoint);
        //Return FizzBuzz Response
        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < _limit; idx++) {
            int currentNum = idx + 1;
            //Check number multiples
            boolean isInt1Multiple = (currentNum % _int1 == 0);
            boolean isInt2Multiple = (currentNum % _int2 == 0);
            if (isInt1Multiple && isInt2Multiple)
                sb.append(_str1).append(_str2);
            else if (isInt1Multiple)
                sb.append(_str1);
            else if (isInt2Multiple)
                sb.append(_str2);
            else
                sb.append(currentNum);
        }
        return ResponseEntity.status(HttpStatus.OK).body(sb.toString());
    }

    @GetMapping("/statistics")
    public StatisticEndpoint getMostCalledEndpoint() {
        return statisticService.findMostCalledEndpoint();
    }
}
