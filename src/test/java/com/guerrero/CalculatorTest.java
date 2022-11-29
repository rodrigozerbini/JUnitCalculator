package com.guerrero;

import static org.junit.jupiter.api.Assertions.*;

import com.sun.org.apache.xpath.internal.Arg;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
        // Arrange
        int dividend = 4;
        int divisor = 0;

        // Act & Assert
        assertThrows(ArithmeticException.class, ()-> {
            calculator.divideIntegers(dividend, divisor);},
                "Division by zero should throw an exception");
    }

    @DisplayName("Test integer subtraction")
    @ParameterizedTest
    @MethodSource("subtractIntegersInputParameters")
    void testSubtractIntegers(int a, int b, int expectedResult) {
        int result = calculator.subtractIntegers(a, b);

        // The lambda functions will be executed only if the test fails
        // This optimizes performance
        assertEquals(expectedResult, result, () -> a + "-" + b + " should be " + expectedResult);
    }

    public static Stream<Arguments> subtractIntegersInputParameters() {

        return Stream.of(
                Arguments.of(10, 5, 5),
                Arguments.of(55, 1, 54),
                Arguments.of(1, 0, 1)
        );
    }
}