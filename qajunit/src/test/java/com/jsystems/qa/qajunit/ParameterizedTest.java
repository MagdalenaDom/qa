package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Parameterized Tests")
public class ParameterizedTest extends ConfigJunit{

    @BeforeAll
    public static void setUpAll(){
        System.out.println("======== Before All =========");
    }

    @AfterAll
    public static void tearDownAll(){
        System.out.println("======== After All =========");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("========= Before Each =========");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("========= Afetr Each =========");
    }

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

    @DisplayName("CSV value params test")
    @org.junit.jupiter.params.ParameterizedTest(name="Params test with value name: {0} and value {1}")
    @CsvSource(value = {"Hello, 5", "HelloJunit 5, 15", "'Hello 5!', 25"}, delimiter = ',')
    public void paramMultiArgTest(String param1, int param2) {
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5 == 0);
    }

    @DisplayName("CSV value params test")
    @org.junit.jupiter.params.ParameterizedTest(name = "Params test with value, name: {0} and value {1}")
    @CsvFileSource(resources = "/plik.csv", delimiter = ',')
    public void csvFileSourceTest(String param1, int param2){
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5 == 0);
    }

}



