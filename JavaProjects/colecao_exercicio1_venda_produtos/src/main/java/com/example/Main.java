package com.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        GerenciamentoVendas gv = new GerenciamentoVendas();
        String operacao;
        do {
            operacao = JOptionPane.showInputDialog("\n ---- Gerenciamento de Vendas ----\n" +
            "1 - Registrar Venda \n" +
            "2 - Listar Vendas do Cliente \n" +
            "3 - Listar Vendas Acima de um Valor Minimo \n" +
            "4 - Sair");
            switch (operacao) {
                case "1":
                String cpf = JOptionPane.showInputDialog("Informe o CPF do Cliente");
                String nomeProduto = JOptionPane.showInputDialog("Informe o Nome do Produto");
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o Valor do Produto"));
                Produto produto = new Produto(nomeProduto, valor);
                gv.venda(cpf, produto);
                break;

                case "2":
                    String cpf2 = JOptionPane.showInputDialog("Informe o CPF do Cliente");
                    gv.produtosCliente(cpf2);
                break;

                case "3":
                String cpf3 = JOptionPane.showInputDialog("Informe o CPF do Cliente");
                double valorMinimo = Double.parseDouble(JOptionPane.showInputDialog("Informe o Valor Minimo"));
                gv.produtosClienteAcimaDe(cpf3, valorMinimo);
                break;

                case "4":
                    System.out.println("Sair");
                break;
            }
        } while (operacao!="4");
    }
}