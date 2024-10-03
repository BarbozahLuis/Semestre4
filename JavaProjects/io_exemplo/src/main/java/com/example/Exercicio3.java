package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Exercicio3 {
    
    public void produtos(){
        // Lista para armazenar os preços dos produtos
        ArrayList<Double> precos = new ArrayList<>();

        try {
            //estabelecer comunicação com o banco de dados
            Connection  con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

            //tradutor de sql
            Statement stmt = con.createStatement();

            //armazenar os resultados do sql
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");

             // Verificar nomes das colunas
            int columnCount = rs.getMetaData().getColumnCount();
            StringBuilder colunas = new StringBuilder("Colunas disponíveis:\n");
            for (int i = 1; i <= columnCount; i++) {
                colunas.append(rs.getMetaData().getColumnName(i)).append("\n");
            }
            JOptionPane.showMessageDialog(null, colunas.toString(), "Colunas do ResultSet", JOptionPane.INFORMATION_MESSAGE);

            // Variáveis para armazenar o produto mais caro e o mais barato
            String produtoMaisCaro = "";
            double maiorPreco = Double.MIN_VALUE;
            String produtoMaisBarato = "";
            double menorPreco = Double.MAX_VALUE;
            double somaPrecos = 0;
            int contador = 0;

            // StringBuilder para armazenar os detalhes dos produtos
            StringBuilder detalhesProdutos = new StringBuilder();

            // Processar os resultados
            while (rs.next()) {
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");

                // Adicionar preço à lista
                precos.add(preco);
                
                // Adicionar detalhes do produto ao StringBuilder
                detalhesProdutos.append("Produto: ").append(nome).append(", Preço: ").append(preco).append("\n");
                
                // Verificar se é o produto mais caro
                if (preco > maiorPreco) {
                    maiorPreco = preco;
                    produtoMaisCaro = nome;
                }

                // Verificar se é o produto mais barato
                if (preco < menorPreco) {
                    menorPreco = preco;
                    produtoMaisBarato = nome;
                }

                // Somar os preços e contar os produtos
                somaPrecos += preco;
                contador++;
            }

            // Calcular média de preços
            double mediaPrecos = (contador > 0) ? (somaPrecos / contador) : 0;

            // Montar mensagem final
            String mensagem = detalhesProdutos.toString() +
                    "\nProduto mais caro: " + produtoMaisCaro + " com preço: " + maiorPreco +
                    "\nProduto mais barato: " + produtoMaisBarato + " com preço: " + menorPreco +
                    "\nMédia de preços dos produtos: " + mediaPrecos;

            // Exibir mensagem usando JOptionPane
            JOptionPane.showMessageDialog(null, mensagem, "Detalhes dos Produtos", JOptionPane.INFORMATION_MESSAGE);

            // Fechar conexões
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Exibir o erro no console
        }
    }


}
