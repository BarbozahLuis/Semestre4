package com.example;
import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Curso {
    //atributos
    private String nomeCurso;
    private List<Aluno> alunos; //list é abstrata
    private Professor professor; //objeto

    //construtor
    public Curso(String nomeCurso){
        this.nomeCurso=nomeCurso;
        alunos = new ArrayList<>(); //implementação do método arraylist
    }

    //métodos adicionar professor
    public void addProf(Professor professor){
        this.professor=professor;

    }

    //método adicionar aluno
    public void addAluno(Aluno aluno){
        alunos.add(aluno);
    }

    //método info curso
    public void infoCurso(){
        System.out.println("Curso: "+nomeCurso);
        System.out.println("Professor: "+professor.getNome());
        System.out.println("Alunos Matriculados:");
        for (Aluno aluno : alunos) {
            System.out.println("Aluno: "+ aluno.getNome()+ "RA: "+ aluno.getMatricula());
        }
    }

    //método lançar nota
    public void atribuirNotaNome(String nomeAluno, double notaAluno){
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nomeAluno)) {
                aluno.setNota(notaAluno);
                return;
            }
        }
        System.out.println("Aluno não encontrado!");
    }

    //método exibir resultado final 
    public void exibirResultadoFinal(){
        for (Aluno aluno : alunos) {
            System.out.println(aluno.exibirInfo());//como ja foi criada a ação e o print dentro do arquivo Aluno.java, apenas puxamos eles ao inves de degitar novamente
            System.out.println(aluno.avaliarDesempenho());// mesma coisa referente a exibir info
        }
    }
}
