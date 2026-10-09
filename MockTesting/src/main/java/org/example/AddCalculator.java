package org.example;

public class AddCalculator {
    private Calculator calculator;

    AddCalculator(Calculator calculator){
        this.calculator = calculator;
    }
    public int performAdd(int num1, int num2){
        return calculator.add(num1,num2);
    }
}
