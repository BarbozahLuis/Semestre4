package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;


import com.example.models.Maquina;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class MaquinaAPI {


    public static List<Maquina> getMaquinas() {
        String json = ApiConnection.getData("maquinas");
        List<Maquina> maquinas = new ArrayList<>();


        if (json != null) {
            //biblioteca jsonArray, irá separar a String e converte em um elemento chave e valor
            JSONArray jsonArray = new JSONArray(json);// puxa a string e cria um json 
            //percorrer objeto por objeto e toda a informação inserida 
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                //objeto do model máquina
                Maquina maquina = new Maquina(
                    jsonObject.getString("id"),
                    jsonObject.getString("codigo"),
                    jsonObject.getString("nome"),
                    jsonObject.getString("modelo"),
                    jsonObject.getString("fabricante"),
                    LocalDate.parse(jsonObject.getString("dataAquisicao")),
                    jsonObject.getInt("tempoVidaEstimado"),
                    jsonObject.getString("localizacao"),
                    jsonObject.getString("detalhes"),
                    jsonObject.getString("manual")
                );
                maquinas.add(maquina);
            }
        }
        return maquinas;
    }

    public static void postMaquinas(Maquina maquina) {
        //criar um objeto json
        JSONObject maquinaObject = new JSONObject();
        maquinaObject.put("id", maquina.getId());
        maquinaObject.put("codigo", maquina.getCodigo());
        maquinaObject.put("nome", maquina.getNome());
        maquinaObject.put("modelo", maquina.getModelo());
        maquinaObject.put("fabricante", maquina.getFabricante());
        maquinaObject.put("dataAquisicao", maquina.getDataAquisicao().toString());
        maquinaObject.put("tempoVidaEstimado", maquina.getTempoVidaEstimado());
        maquinaObject.put("localizacao", maquina.getLocalizacao());
        maquinaObject.put("detalhes", maquina.getDetalhes());
        maquinaObject.put("manual", maquina.getManual());
        //enviar para a api
        if (!maquinaObject.isEmpty()) {
            try {
                ApiConnection.postData("maquinas", maquinaObject.toString());
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        
    }



    public static void putMaquinas(Maquina maquina) {//transforma o objeto da classe maquina para uma maquinaObject
        //criar um objeto json
        JSONObject maquinaObject = new JSONObject();
        maquinaObject.put("id", maquina.getId());
        maquinaObject.put("codigo", maquina.getCodigo());
        maquinaObject.put("nome", maquina.getNome());
        maquinaObject.put("modelo", maquina.getModelo());
        maquinaObject.put("fabricante", maquina.getFabricante());
        maquinaObject.put("dataAquisicao", maquina.getDataAquisicao().toString());
        maquinaObject.put("tempoVidaEstimado", maquina.getTempoVidaEstimado());
        maquinaObject.put("localizacao", maquina.getLocalizacao());
        maquinaObject.put("detalhes", maquina.getDetalhes());
        maquinaObject.put("manual", maquina.getManual());
        //enviar para a api
        if (!maquinaObject.isEmpty()) {
            try {
                ApiConnection.putData("maquinas", maquinaObject.toString(), maquina.getId());
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        
    }
}

