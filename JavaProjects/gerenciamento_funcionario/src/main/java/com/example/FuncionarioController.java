package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FuncionarioController {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public FuncionarioController(){
        funcionarios = new ArrayList<>();
    }
    
    //metodo 
    public void addFuncionario(){
        //criar o funcionario
        String nome = JOptionPane.showInputDialog("Digite o nome do funcionario");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite idade"));
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digete o Salário"));
        Funcionario funcionario = new Funcionario(nome, idade, salario);
        funcionarios.add(funcionario);
    }

    // Método para listar todos os funcionários
    public void listarFuncionarios() {
        StringBuilder lista = new StringBuilder("Funcionários:\n");
        for (Funcionario f : funcionarios) {
            lista.append(f.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

// Método para buscar funcionário pelo nome
public Funcionario buscarFuncionarioPorNome() {
    String nome = JOptionPane.showInputDialog("Digite o nome do funcionario");
    try {
        Funcionario funcionario = null;
        for (Funcionario f : funcionarios) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                funcionario = f;
                break; // Encontra o funcionário e sai do loop
            }
        }
        
        if (funcionario != null) {
            JOptionPane.showMessageDialog(null, "Funcionário encontrado: " + funcionario.getNome());
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage());
    }
    return null;
}



    // Método para remover funcionário buscando pelo nome
public void removerFuncionarioPorNome(String nome) {
    try {
        Funcionario funcionario = buscarFuncionarioPorNome();
        if (funcionario != null) {
            funcionarios.remove(funcionario);
            JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao remover o funcionário: " + e.getMessage());
    }
}

// Método para calcular a média salarial
public void calculoMediaSalario() {
    try {
        if (funcionarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há funcionários cadastrados.");
            return;
        }

        double totalSalario = 0;
        for (Funcionario f : funcionarios) {
            totalSalario += f.getSalario(); // Supondo que Funcionario tem um método getSalario()
        }
        
        double mediaSalario = totalSalario / funcionarios.size();
        JOptionPane.showMessageDialog(null, "A média salarial é: R$ " + mediaSalario);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao calcular a média salarial: " + e.getMessage());
    }
}

}
