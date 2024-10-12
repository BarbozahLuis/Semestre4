package com.example.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class ApiConnection {
    private static final String API_URL = "http://localhost:3000/"; //endereço da api


    public static String getData(String endpoint) {

        try {
            URL url = new URL(API_URL + endpoint);//aqui seria quando juntamos o endereço da api junto do endpoint que seria o maquinas por exemplo
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");


            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();


            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }


            in.close();
            connection.disconnect();
            return content.toString();


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //metodo - post
    public static void postData(String endpoint, String inputData){
        try {
            URL url = new URL(API_URL + endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            
            try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(connection.getOutputStream(), "UTF-8"))) {
                bw.write(inputData);//informações da string que vão para o Json
                bw.flush();
            }
            // Verificar o status da resposta
            int status = connection.getResponseCode();
            if (status != HttpURLConnection.HTTP_CREATED) { // HTTP 201 Created
                throw new Exception("Erro ao criar usuário: " + status);
            }

            System.out.println("Cadastrado com Sucesso");
            connection.disconnect();


        } catch (Exception e){
            e.printStackTrace();
           
        }
    }


    //metodo - put
    public static void putData(String endpoint, String inputData, String id){//diferença de post, para put, é adicionar o ID que será puxado
        try {
            URL url = new URL(API_URL + endpoint + "/"+ id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            
            try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(connection.getOutputStream(), "UTF-8"))) {
                bw.write(inputData);//informações da string que vão para o Json
                bw.flush();
            }
            // Verificar o status da resposta
            int status = connection.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK) { // HTTP 201 Created
                throw new Exception("Erro ao criar usuário: " + status);
            }

            System.out.println("Cadastrado com Sucesso");
            connection.disconnect();


        } catch (Exception e){
            e.printStackTrace();
           
        }
    }

    //metodo - delete

    public static void delteData(String endpoint, String id){//diferença de post, para put, é adicionar o ID que será puxado
        try {
            URL url = new URL(API_URL + endpoint + "/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setDoOutput(true);
            
            
            // Verificar o status da resposta
            int status = connection.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK) { // HTTP 201 Created
                throw new Exception("Erro ao deletar usuário: " + status);
            }

            System.out.println("Cadastrado com Sucesso");
            connection.disconnect();


        } catch (Exception e){
            e.printStackTrace();
           
        }
    }




}
