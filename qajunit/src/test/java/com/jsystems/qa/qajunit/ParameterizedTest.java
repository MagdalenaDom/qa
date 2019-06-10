package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Parameterized Tests")
public class ParameterizedTest {

    @DisplayName("First Param Test")
    @org.junit.jupiter.params.ParameterizedTest (name = "Patameterized test with value {0}")
    @ValueSource(ints = {5, 15, 25})
    public void paramFirstTest(int number){
        assertTrue(number % 5 == 0);
    }

    @DisplayName("Second Param Test")
    @org.junit.jupiter.params.ParameterizedTest (name = "Patameterized test with value {0}")
    @ValueSource(strings = {"Hello", "Hello all", "Hello Group"})
    public void paramSecondTest(String value) {
        assertTrue(value.contains("Hello"));
    }
}
