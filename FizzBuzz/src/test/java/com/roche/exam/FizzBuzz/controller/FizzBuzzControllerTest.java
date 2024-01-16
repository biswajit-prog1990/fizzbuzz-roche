package com.roche.exam.FizzBuzz.controller;

import com.roche.exam.FizzBuzz.model.StatisticEndpoint;
import com.roche.exam.FizzBuzz.service.StatisticServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = FizzBuzzController.class)
public class FizzBuzzControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatisticServiceImpl statisticService;

    @Test
    void should_return_400_when_int1_parameter_invalid() throws Exception {
        mockMvc.perform(get("/v1/fizzbuzz?_int1=0&_int2=3&_limit=100&_str1=fizz&_str2=buzz"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_return_400_when_int2_parameter_invalid() throws Exception {
        mockMvc.perform(get("/v1/fizzbuzz?_int1=3&_int2=0&_limit=100&_str1=fizz&_str2=buzz"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_return_400_when_limit_parameter_invalid() throws Exception {
        mockMvc.perform(get("/v1/fizzbuzz?_int1=6&_int2=3&_limit=-1&_str1=fizz&_str2=buzz"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_return_200_when_all_valid_parameters() throws Exception {
        mockMvc.perform(get("/v1/fizzbuzz?_int1=4&_int2=4&_limit=8&_str1=fizz&_str2=buzz"))
                .andExpect(status().isOk());
    }

    @Test
    void should_return_200_with_most_called_endpoint() throws Exception {
        Mockito.when(statisticService.findMostCalledEndpoint())
                .thenReturn(new StatisticEndpoint());
        mockMvc.perform(get("/v1/fizzbuzz/statistics"))
                .andExpect(status().isOk());
    }
}
