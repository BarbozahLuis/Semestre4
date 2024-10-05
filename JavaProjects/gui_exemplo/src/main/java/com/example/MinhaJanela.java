package com.example;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MinhaJanela extends JFrame{

    //cria o frame (painel)
    public MinhaJanela(){
    super("Minha Janela");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(400, 300);

    //instanciando um objeto painel e adicionando dentro do JFrame o painel
    JPanel painel = new JPanel();
    this.add(painel);

    //adicionando um botão 
    JButton botao = new JButton("Clique Aqui");
    painel.add(botao);

    //adicionarum evento do botão
    botao.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Botão Clicado");
        }
    });

    // botao.addActionListener(e->{
    //     JOptionPane.showMessageDialog(null, "Botão Clicado com outra maneira");
    // });

    this.setVisible(true);
}

    
}
