package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    @ParameterizedTest
    @CsvSource({"1,1",
            "2,2",
            "3,Fizz",
            "4,4",
            "5,Buzz",
            "7,7",
            "8,8",
            "9,Fizz",
            "10,Buzz",
            "11,11",
            "12,Fizz",
            "13,13",
            "14,14",
            "15,FizzBuzz"})
    public void itShouldReturnAFizzBuzzResult(String input, String expected) {
        int number = Integer.parseInt(input);
        assertEquals(expected, FizzBuzz.of(number));
    }
}
