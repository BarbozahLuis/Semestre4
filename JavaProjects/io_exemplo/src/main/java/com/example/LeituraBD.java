package com.example;


import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;


public class LeituraBD {
    public void exemplo(){
        try {
            //estabelecer conexão
            Connection  con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

            //tradutor de sql
            Statement stmt = con.createStatement();

            //armazenar os resultados do sql
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nome: " + rs.getString("nome") + "Idade: "+rs.getInt("idade"));

            }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    
}

