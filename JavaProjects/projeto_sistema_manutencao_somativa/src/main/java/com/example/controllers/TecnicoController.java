package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.models.Tecnico;

public class TecnicoController {
    private List<Tecnico> tecnicos;

    public TecnicoController() {
        this.tecnicos = new ArrayList<>();
    }

    //método create
    public void adicionarTecnico(Tecnico tecnico) {
        this.tecnicos.add(tecnico);
    }

    //método read
    public List<Tecnico> readTecnicos() {
        return this.tecnicos;
    }

    //método update
    public void updateTecnico(int posicao, Tecnico tecnico) {
        tecnicos.set(posicao, tecnico);
    }

    //método delete
    public void deletarTecnico(int posicao) {
        tecnicos.remove(posicao);
    }
}
