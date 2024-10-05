package com.example;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CalculadoraAbas extends JFrame{
    //atributos 



    //construtor
    public CalculadoraAbas(){
        super("Calculadora com abas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);


        //adicionar os componentes
        JTabbedPane abas = new JTabbedPane();

        JPanel calcSimples = new CalculadoraSimples();
        abas.addTab("Simples", calcSimples);

        JPanel calcAvancada = new CalculadoraAvancada();
        abas.addTab("Avançada", calcAvancada);

        this.add(abas);

        this.setVisible(true);

    }
}
