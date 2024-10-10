package com.example.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Manutencao;

public class ManutencaoAPI {
    public static List<Manutencao> getManutencaos() {
        String json = ApiConnection.getData("historicoManutencao");
        List<Manutencao> manutencaos = new ArrayList<>();


        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Manutencao manutencao = new Manutencao(
                    jsonObject.getString("id"),
                    jsonObject.getLong("maquinaId"),
                    LocalDate.parse(jsonObject.getString("data")),
                    jsonObject.getString("tipo"),
                    jsonObject.getString("pecasTrocadas"),
                    jsonObject.getLong("tempoDeParada"),
                    jsonObject.getString("tecnicoID"),
                    jsonObject.getString("observacoes")
                );
                manutencaos.add(manutencao);
            }
        }
        return manutencaos;
    }

    public static List<Manutencao> getManutencao() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFalha'");
    }
}
