package com.example;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produto> produtos;
    private Connection con;
    private java.sql.Statement stmt;
    private ResultSet rs;
    
    public ProdutoController() {
        produtos = new ArrayList<>();
    }

    public void getConnection(){
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //listar produtos
    public void listarProdutos(){
        getConnection();
        try {
            stmt = con.createStatement();
        rs= stmt.executeQuery("SELECT * FROM produtos");
        while (rs.next()) {
            Produto produto = new Produto(
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getDouble("preco"));
            produtos.add(produto);
        }
        System.out.println(produtos.toString()
        );
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }

        
    }
}
