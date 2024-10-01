package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LeirturaAPI{
    
    public void exemplo(){
        try {
            URL url = new URL("http://api.github.com/users/BarbozahLuis");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");

            int status = con.getResponseCode();
            if (status!=200) {
                throw new Exception("Erro de conexão");
            }
            //conexão estabelecida
            BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream())
            );
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
