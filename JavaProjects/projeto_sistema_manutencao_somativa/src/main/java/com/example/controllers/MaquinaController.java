package com.example.controllers;
import java.util.ArrayList;
import java.util.List;

import com.example.api.MaquinaAPI;
import com.example.models.Maquina;

public class MaquinaController {
    private List<Maquina> maquinas;
    
    public MaquinaController() {
        this.maquinas = new ArrayList<>();
    }

    //método - crud
    public void adicionarMaquina(Maquina maquina) {
        this.maquinas.add(maquina);
    }

    //metodo read
    public List<Maquina> readMaquinas() {
        maquinas = MaquinaAPI.getMaquinas();
        return maquinas;
    }

    //metodo update
    public void updateMaquina(int posicao, Maquina maquina) {
        maquinas.set(posicao, maquina);
    }

    //metodo delete
    public void deletarMaquina(int posicao) {
        maquinas.remove(posicao);
    }
    
}
