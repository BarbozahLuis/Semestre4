package com.example;

public class Roupa implements Transportavel{
    //atributos
    private double volume;

    public Roupa(String nome, double preco, double volume) {
        super(nome, preco);
        this.volume = volume;

    }

    @Override
    public double calcularPeso() {
        double peso = volume*1;
        return peso;
    }
    
    @Override
    public double calcularFrete() {
        double frete = calcularPeso()*0.5;
        return frete;
    }

    
}