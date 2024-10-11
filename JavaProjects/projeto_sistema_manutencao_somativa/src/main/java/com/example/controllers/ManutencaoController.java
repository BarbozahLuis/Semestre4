package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.ManutencaoAPI;
import com.example.models.Manutencao;

public class ManutencaoController {
    //atributos
    private List<Manutencao> manutencaos;

    public ManutencaoController(){
        this.manutencaos = new ArrayList<>();
    }

    //método create
    public void adicionarManutencao(Manutencao manutencao){
        this.manutencaos.add(manutencao);
    }

    //método read
    public List<Manutencao> readManutencoes(){
        manutencaos = ManutencaoAPI.getManutencaos();
        return this.manutencaos;
    }

    //método update
    public void updateManutencao(int posicao, Manutencao manutencao){
        manutencaos.set(posicao, manutencao);
    }
}
