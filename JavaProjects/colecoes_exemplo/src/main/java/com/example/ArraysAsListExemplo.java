package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsListExemplo {
    private String[] nomes = new String[3];//vetor/array de strings/ fixo com 3 elementos
    private List<String> nomesList;//dinâmico/modificável com qualquer quantidade de elementos
    
    public ArraysAsListExemplo(){
        nomes = new String[]{"Maria", "João", "Pedro"};//criando uma lista para armazenar os nomes
        nomesList = new ArrayList<>(Arrays.asList(nomes));//criando uma lista para armazenar os nomes
    
    
    }

    //alteração do array fixo
    public void adicionarArray(String nome){

        try {
            int posicao = nomes.length;//pegando a posição vazia do array
            nomes[posicao] = nome;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println(Arrays.toString(nomes));
        }
        
    }

    //alterar uma lista
    public void adicionarList(String nome){
        
        
        try {
            nomesList.add(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println(nomesList);
        }
        
    }

}
