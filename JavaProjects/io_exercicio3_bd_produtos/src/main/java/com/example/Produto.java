package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Produto{
    private int id;
    private String nome;
    private double preco;

    @Override
    public String toString() {
        return "Nome: " + nome + ", Preço: " + preco;
    }
}