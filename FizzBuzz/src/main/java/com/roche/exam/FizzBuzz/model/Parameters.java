package com.roche.exam.FizzBuzz.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Parameters implements Serializable {

    private int _int1;
    private int _int2;
    private int _limit;
    private String _str1;
    private String _str2;
}
