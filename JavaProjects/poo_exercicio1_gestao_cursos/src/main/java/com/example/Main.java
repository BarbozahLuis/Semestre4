package com.example;

import javax.swing.JOptionPane;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        String operacao = "0";
        do {
            operacao = JOptionPane.showInputDialog(
                "\n --Gerenciamento de curso-- \n"
                + "1 - Cadastrar curso\n"
                + "2 - Adicionar professor\n"
                + "3 - Adicionar Aluno"
                + "4 - Informações do curso\n"
                + "5 - Atribuir notas\n"
                + "6 - Resultado final \n"
                + "7 - Sair");
                switch (operacao) {
                    case "1":
                        String nomeCurso = JOptionPane.showInputDialog("Informe o nome do curso");
                        cursos.add (new Curso(nomeCurso));
                        break;
                    
                    case "2":
                    String nomeCursoP = JOptionPane.showInputDialog("Informe o nome do curso");

                        for (Curso curso : cursos) {
                            if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoP)) {
                                String nomeProf = JOptionPane.showInputDialog("Nome Professor: ");
                                String cpfProf = JOptionPane.showInputDialog("CPF: ");
                                double salarioProf = Double.parseDouble(JOptionPane.showInputDialog("Salario: "));
                                Professor professor = new Professor(nomeProf, cpfProf, salarioProf);
                                curso.addProf(professor);
                            }
                        }
                        break;
                    case "3":
                    String nomeCursoA = JOptionPane.showInputDialog("Informe o nome do curso");    
                    try {
                        boolean encontrado = false;
                        for (Curso curso : cursos) {
                            if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoA)) {
                                encontrado = true;
                                boolean novoAluno=true;
                                do {
                                    String nomeAluno = JOptionPane.showInputDialog("Nome Professor: ");
                                    String cpfAluno = JOptionPane.showInputDialog("CPF: ");
                                    String matriculaAluno = JOptionPane.showInputDialog("Matricula: ");
                                    curso.addAluno(new Aluno(nomeAluno, cpfAluno, matriculaAluno));
                                    novoAluno = JOptionPane.showInputDialog(
                                        "Inserir novo aluno? \n"
                                                +"1-Sim \n"
                                                +"2-Não").equals("1")?true:false;
                                } while (encontrado);
                                
                            }
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }    
                    break;
                
                    default:
                        break;
                }
        } while (operacao!="7");
    }
}