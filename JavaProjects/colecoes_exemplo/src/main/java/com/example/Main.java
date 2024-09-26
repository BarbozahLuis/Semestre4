package com.example;

public class Main {
    public static void main(String[] args) {
       ListExemplo list = new ListExemplo();
       SetExemplo set = new SetExemplo();
       list.adicionarNome("Luis");
       list.adicionarNome("Roger");
       list.adicionarNome("Coutinho");
       list.listarNomes();
       list.modificarNome(2, "Ygao");
       list.listarNomes();
       list.removerNome("Ygao");
       list.listarNomes();


       set.adicionarNome("Luis");
       set.adicionarNome("Roger");
       set.adicionarNome("Coutinho");
       set.listarNomes();
       set.modificarNomeIndex("Roger", "Ygao");
       set.listarNomes();
       set.removerNome("Ygao");
       set.listarNomes();
    }
}