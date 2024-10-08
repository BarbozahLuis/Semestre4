package com.example;

import java.util.HashSet;
import java.util.Set;

public class SetExemplo {
    private Set<String> nomes;
    
    public SetExemplo() {
        nomes = new HashSet<>();
    }


    public void adicionarNome(String nome){
        nomes.add(nome);
        System.out.println(nomes.hashCode()); // Mostra a posição do nome na lista
    }
    //list
    public void listarNomes(){
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
    //remove
    public void removerNome(String nome){
        nomes.remove(nome);
        System.out.println("Nome removido com sucesso!");

    }

    //update
    public void modificarNomeIndex(String nome, String nomeNovo){
        nomes.remove(nome);
        nomes.add(nomeNovo);
        System.out.println("Nome alterado de "+nome+ "para "+nomeNovo);
    }
}
