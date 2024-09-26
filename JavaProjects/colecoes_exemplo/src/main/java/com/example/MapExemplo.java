package com.example;

import java.util.HashMap;
import java.util.Map;

public class MapExemplo {
    private Map<String,Integer> nomeIdade;

    public MapExemplo() {
        nomeIdade = new HashMap<>();
    }

    public void adicionarNomeIdade(String nome, int idade){
        nomeIdade.put("Maria", 23);
    }

    //listar
    public void listarNomeIdade(){
        for (String nome : nomeIdade.keySet()) {
            int value = nomeIdade.get(nome);
            System.out.println(nome+ " " +nome);
        }
    }

    //remove
    public void removerNomeIdade(String key){
        nomeIdade.remove(key);
    }

    //update
    public void update(String key, int novaIdade){
        nomeIdade.put(key,novaIdade);
    }

}
