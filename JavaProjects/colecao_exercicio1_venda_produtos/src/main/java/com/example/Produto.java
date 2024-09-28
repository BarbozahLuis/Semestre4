package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Produto{
    private String nome;
    private double valor;
    //toString
    @Override
    public String toString() {
        return "Nome Produto: " + nome + ", Valor do Produto: " + valor;
    }

}