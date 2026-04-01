package com.example.demo;


public class Calculator {

    // Method to add two numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to subtract two numbers
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method to multiply two numbers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Method to divide two numbers
    public int divide(int a, int b) {

        // If denominator is zero, throw exception
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return a / b; // integer division
    }
}
