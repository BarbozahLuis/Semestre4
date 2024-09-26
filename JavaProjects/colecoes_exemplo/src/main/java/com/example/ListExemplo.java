 package com.example;

import java.util.ArrayList;
import java.util.List;

public class ListExemplo {

    private List<String> nomes;

    public ListExemplo(){
        nomes = new ArrayList<>();
    }

    public void adicionarNome(String nome){
        nomes.add(nome);
        System.out.println(nomes.indexOf(nome)); // Mostra a posição do nome na lista
    }

    public void listarNomes(){
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }

    public void removerNome(String nome){
        nomes.remove(nome);
        System.out.println("Nome removido com sucesso!");

    }

    //update
    public void modificarNome(int index, String nome){
        String nomeAnterior = nomes.get(index);
        nomes.set(index,nome);
        System.out.println("Nome da posição"+index+ ","+nomeAnterior+" alterado para "+nome);
    }
}