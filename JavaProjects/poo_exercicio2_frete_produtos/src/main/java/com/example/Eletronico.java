package com.example;

public class Eletronico extends Produto{
    private double peso;

    //contrutor
    public Eletronico(String nome, double preco, double peso) {
        super(nome, preco);
        this.peso = peso;
    }
    
}
