package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.models.Manutencao;

public class ManutencoaController {
    //atributos
    private List<Manutencao> manutencaos;

    public ManutencoaController(){
        this.manutencaos = new ArrayList<>();
    }

    //método create
    public void adicionarManutencao(Manutencao manutencao){
        this.manutencaos.add(manutencao);
    }

    //método read
    public List<Manutencao> readManutencoes(){
        return this.manutencaos;
    }

    //método update
    public void updateManutencao(int posicao, Manutencao manutencao){
        manutencaos.set(posicao, manutencao);
    }
}
