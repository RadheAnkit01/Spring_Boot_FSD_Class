package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AddCalculatorTest {
    @Test
    void twoPlusTwoShouldEqualToFour(){
        //Arrange
        int expectedOutput = 4;

        //Mocking
        Calculator calculator = mock(Calculator.class);

        when(calculator.add(2,2)).thenReturn(4);

        AddCalculator addCalculator = new AddCalculator(calculator);

        //Act
        int actualOutput = addCalculator.performAdd(2,2);
        IO.println("2 + 2 = "+actualOutput);

        //Assert
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void tenPlusTwoShouldEqualToTwelve(){
        //Arrange
        int expectedOutput = 12;

        //Mocking
        Calculator calculator = mock(Calculator.class);

        when(calculator.add(10,2)).thenReturn(12);

        AddCalculator addCalculator = new AddCalculator(calculator);

        //Act
        int actualOutput = addCalculator.performAdd(10,2);
        IO.println("10 + 2 = " + actualOutput);

        //Assert
        assertEquals(expectedOutput,actualOutput);
    }
}
