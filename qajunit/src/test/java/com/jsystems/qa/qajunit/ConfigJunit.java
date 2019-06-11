package com.jsystems.qa.qajunit;

import org.junit.Test;
import org.junit.jupiter.api.*;

public class ConfigJunit {

    @BeforeAll
    public static void setUpAll(TestInfo testInfo){
        System.out.println("======== Before All =========");
        System.out.println("Test name:" + testInfo.getTestClass() + " \ntest name: " + testInfo.getTestMethod());
    }

    @AfterAll
    public static void tearDownAll(TestInfo testInfo){
        System.out.println("======== After All =========");
        System.out.println("Test name:" + testInfo.getTestClass() + " \ntest name: " + testInfo.getTestMethod());

    }

    @BeforeEach
    public void setUp(TestInfo testInfo){
        System.out.println("========= Before Each =========");
        System.out.println("Test name:" + testInfo.getTestClass() + " \ntest name: " + testInfo.getTestMethod());

    }

    @AfterEach
    public void tearDown(TestInfo testInfo){
        System.out.println("========= Afetr Each =========");
        System.out.println("Test name:" + testInfo.getTestClass() + " \ntest name: " + testInfo.getTestMethod());

    }
}
