package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JScrollPane;



import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.ManutencaoController;
import com.example.models.Manutencao;

public class ManutencaoPanel extends JPanel {
    //atributos
    private ManutencaoController manutencaoController;
    private JTable manutencaoTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarManutencao;

    //construtor
    public ManutencaoPanel() {
        super(new BorderLayout());
        manutencaoController = new ManutencaoController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "ID Maquina", "Data", "Tipo", "Peças Trocadas", "Tecnico", "Observações",
        }, 0);
        manutencaoTable = new JTable(tableModel);
        
        //criar tabelas e preencher a tabela com os dados
        List<Manutencao> manuts = manutencaoController.readManutencoes();
        for (Manutencao manut : manuts){
            tableModel.addRow(new Object[]{
                manut.getId(),
                manut.getMaquinaID(),
                manut.getData(),
                manut.getTipo(),
                manut.getPecasTrocadas(),
                manut.getTecnicoID(),
                manut.getObservacoes(),
            });
        }
        
        JScrollPane scrollPane = new JScrollPane(manutencaoTable);
        this.add(scrollPane, BorderLayout.CENTER);

        //adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarManutencao = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar Alterações");
        painelInferior.add(btnCadastrarManutencao);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);


        //criar as ActionListener para os botões]

    }
}
