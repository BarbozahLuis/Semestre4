package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {
    //atributos com encapsulamento então é necessáro utilziar private
    private String nome;
    private String cpf;

    //metodo
    public String exibirInfo(){
        return "Nome: " +nome+ "CPF: " +cpf;
    }

}
