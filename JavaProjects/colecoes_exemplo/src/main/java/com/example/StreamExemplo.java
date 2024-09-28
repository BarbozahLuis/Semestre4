package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExemplo {
    List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

    //crie uma nova list resultado
    //filtre as words que começam com a letra 'a'
    //to upperCase
    //crie um método
    public void resultadoStream(){
        List<String> resultado = words.stream()
        .filter(word -> word.startsWith("a"))
        .map(String::toUpperCase)
        .collect(Collectors.toList());
        //resultados
        System.out.println(resultado);
        
    }

}
