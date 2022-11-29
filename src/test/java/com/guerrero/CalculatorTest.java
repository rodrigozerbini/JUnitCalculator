package com.guerrero;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Math operations in Calculator")
class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Executing @BeforeAll method");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Executing @AfterAll method");
    }

    @BeforeEach
    void beforeEachMethod() {
        System.out.println("Executing @BeforeEach method");
        calculator = new Calculator();
    }

    @AfterEach
    void afterEachMethod() {
        System.out.println("Executing @AfterEach method");
    }

    @DisplayName("Test 4/2 = 2")
    @Test
    void testDivideIntegers_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        // Act
        int result = calculator.divideIntegers(4,2);

        // Assert
        assertEquals(2, result, "4/2 should be 2");
    }

    @DisplayName("Test 10/2 = 5")
    @Test
    void testDivideIntegers_WhenTenIsDividedByTwo_ShouldReturnFive() {
        int result = calculator.divideIntegers(10,2);

        assertEquals(5, result, "10/2 should be 5");
    }

    @DisplayName("Test division by zero")

    @Test
    void testDivideIntegers_WhenIsDividedByZero_ShouldThrowArithmeticException() {

        // Act & Assert
        assertThrows(ArithmeticException.class, ()-> {calculator.divideIntegers(5, 0);}, "5/0 should return an exception");
    }

    @DisplayName("Test 10 - 5 = 5")
    @Test
    void testSubtractIntegers_WhenTenIsSubtractedByFive_ShouldReturnFive() {
        int a = 10;
        int b = 5;
        int expectedResult = 5;
        int result = calculator.subtractIntegers(a, b);

        // The lambda functions will be executed only if the test fails
        // This optimizes performance
        assertEquals(expectedResult, result, () -> a + "-" + b + " should be " + expectedResult);
    }
}