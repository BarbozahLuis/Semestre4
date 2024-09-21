package com.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        FuncionarioController gerenciaFuncionario = new FuncionarioController();
        int operacao = 0;
        do {
            operacao = Integer.parseInt(JOptionPane.showInputDialog(
                "\n Gerenciamento de Funcionarios \n"+
                "1 - Adicionar funcionario \n"
                +"2 - Listar funcionarios \n"
                +"3 - buscar funcionario \n"
                +"4 - remover funcionario \n"
                +"5 - média salarial \n"
                +"6 - Sair"));

                switch (operacao) {
                    case 1:
                        gerenciaFuncionario.addFuncionario();
                        break;

                    case 2:
                    gerenciaFuncionario.listarFuncionarios();
                    break;

                    case 3:
                    gerenciaFuncionario.buscarFuncionarioPorNome();
                    break;

                    case 4:
                    gerenciaFuncionario.removerFuncionarioPorNome(null);
                    break;

                    case 5:
                    gerenciaFuncionario.calculoMediaSalario();
                    break;

                    case 6:
                    System.out.println("saindo...");
                    break;

                    default:
                        
                }
        } while (operacao!=6);
    }
}