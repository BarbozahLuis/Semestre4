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

public class FalhaPanel extends JPanel {
    private FalhaController falhaController;
    private JTable falhasTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarFalha;

    public FalhaPanel() {
        super(new BorderLayout());
        falhaController = new FalhaController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Máquina ID", "Data", "Problema", "Prioridade", "Operador"
        }, 0);
        falhasTable = new JTable(tableModel);

        // Criar a tabela
        List<Falha> falhas = falhaController.readFalhas();
        for (Falha falha : falhas) {
            tableModel.addRow(new Object[] {
                falha.getId(),
                falha.getMaquinaID(),
                falha.getData(),
                falha.getProblema(),
                falha.getPrioridade(),
                falha.getOperador()
            });
        }
        
        JScrollPane scrollPane = new JScrollPane(falhasTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarFalha = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarFalha);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Criar as ActionListener para Botões
    }
}