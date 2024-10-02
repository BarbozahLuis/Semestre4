package com.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class UsuarioController {
    private List<Usuario> usuarios;
    private URL url;

    public UsuarioController() {
        usuarios = new ArrayList<>();
        
    }

    public void read(){
        try {
            //estabelecer conexão
            url = new URL("http://localhost:3000/usuarios");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");

            //verifica o status da conexão
            int status = con.getResponseCode();
            if (status!=200) { //se for diferente de 200 lançar um exception
                throw new Exception("Erro de conexão");
            }

            //gravar os dados da api na memoria
            BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream())
            );

            //laço de repetição
            String linha;
            //convertar um arquivo de texto (string)
            StringBuffer content = new StringBuffer();
            while ((linha = br.readLine()) != null) {
                content.append(linha);
            }
            br.close();
            //converter o arquivo de texto para dados da classe usuario
            JSONArray dadosUsuarios = new JSONArray(content.toString());

            for (int i = 0; i < dadosUsuarios.length(); i++) {
                JSONObject usuarioJson = dadosUsuarios.getJSONObject(i);
                
                //adicionar os dados do usuario a lista de usuarios
                usuarios.add(new Usuario(//instanciar objeto usuario
                    usuarioJson.getString("id"),
                    usuarioJson.getString("nome"),
                    usuarioJson.getInt("idade"),
                    usuarioJson.getString("endereco")
                ));
            }

            System.out.println(usuarios.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }

    public void createUser(Usuario usuario){
        //estabelecer conexão
        try {
            url = new URL("http://localhost:3000/usuarios");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            
            //converter o objeto usuario para json
            JSONObject usuarioJson = new JSONObject();
            usuarioJson.put("nome", usuario.getNome());
            usuarioJson.put("idade", usuario.getIdade());
            usuarioJson.put("endereco", usuario.getEndereco());


            //enviar dos dados para  API
            try(BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(con.getOutputStream(), "UTF-8"))){

                    bw.write(usuarioJson.toString());
                    bw.flush();

                    //verifica o status da conexão
                    int status = con.getResponseCode();
                    if (status!=HttpURLConnection.HTTP_CREATED) { //se for diferente de 201 lançar um exception
                        throw new Exception("Erro ao cadastrar usuario" + status);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
