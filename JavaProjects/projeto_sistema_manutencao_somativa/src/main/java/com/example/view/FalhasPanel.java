package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.FalhaController;
import com.example.models.Falha;

public class FalhasPanel extends JPanel{
    //atributos
    private FalhaController falhaController;
    private JTable falhaTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarFalha;
    
    //construtor
    public FalhasPanel() {
        super(new BorderLayout());
        falhaController = new FalhaController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "ID Maquina", "Data", "Problema", "Prioridade", "Operador"
        },0);
        falhaTable = new JTable(tableModel);

        //criar tabelas e preencher a tabela com os dados
        List<Falha> falhas = falhaController.readFalhas();
        for (Falha falha : falhas) {
            tableModel.addRow(new Object[]{
                falha.getId(),
                falha.getMaquinaId(),
                falha.getData(),
                falha.getProblema(),
                falha.getPrioridade(),
                falha.getOperador()
            });

        }

        JScrollPane scrollPane = new JScrollPane(falhaTable);
        this.add(scrollPane, BorderLayout.CENTER);

        //adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarFalha = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar Alterações");
        painelInferior.add(btnCadastrarFalha);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        //criar as ActionListener para os botões
    }
}
