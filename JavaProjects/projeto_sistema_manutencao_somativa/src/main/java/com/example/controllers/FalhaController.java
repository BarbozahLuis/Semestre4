package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.FalhaAPI;
import com.example.models.Falha;

public class FalhaController {
    private List<Falha> falhas;

    public FalhaController() {
        this.falhas = new ArrayList<>();
    }
    
    //método - create
    public void adicionarFalha(Falha falha) {
        this.falhas.add(falha);
    }

    //método - read
    public List<Falha> readFalhas() {
        falhas = FalhaAPI.getFalhas();// buscar as falhas na api
        return this.falhas;
    }

    //método - update
    public void updateFalha(int posicao, Falha falha) {
        falhas.set(posicao, falha);
    }
}
