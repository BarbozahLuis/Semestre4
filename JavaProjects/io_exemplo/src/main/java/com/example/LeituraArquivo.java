package com.example;

import java.io.BufferedReader;
import java.io.FileReader;

public class LeituraArquivo {
    public void exemplo(){
        try (BufferedReader br = new BufferedReader(new FileReader("dado.txt"))){
            String linha;
            do {
                linha = br.readLine();
                System.out.println(linha==null?"Fim do Documento":linha);
            } while (linha!=null);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
}
