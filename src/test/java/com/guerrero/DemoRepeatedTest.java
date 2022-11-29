package com.guerrero;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class DemoRepeatedTest {

    Calculator calculator;

    @BeforeEach
    void beforeEachMethod() {
        System.out.println("Executing @BeforeEach method");
        calculator = new Calculator();
    }

    @DisplayName("Test division by zero")
    @RepeatedTest(3)
    // This test will be repeated 3 times
    void testDivideIntegers_WhenIsDividedByZero_ShouldThrowArithmeticException() {
        // Arrange
        int dividend = 4;
        int divisor = 0;

        // Act & Assert
        assertThrows(ArithmeticException.class, ()-> {
                    calculator.divideIntegers(dividend, divisor);},
                "Division by zero should throw an exception");
    }
}
