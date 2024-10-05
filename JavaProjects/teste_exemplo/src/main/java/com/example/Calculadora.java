package com.example;

public class Calculadora {
    public double soma(double a, double b){
        return a + b;
    }

    public double subtrai(double a, double b){
        return a - b;
    }

    public double multiplica(double a, double b){
        return a * b;
    }

    public double divide(double a, double b){
        if(b == 0){
            throw new IllegalArgumentException("Divisão por zero não é permitida.");
        }
        return a / b;
    }
}
