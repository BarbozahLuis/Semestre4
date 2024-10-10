package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.TecnicoController;
import com.example.models.Tecnico;

public class TecnicosPanel extends JPanel{
    //atributos
    private TecnicoController tecnicoController;
    private JTable tecnicoTable;
    private DefaultTableModel tableModel;
    private JButton btnCadastrarTecnico;
    private JButton btnSalvarAlteracoes;

    //construtor
    public TecnicosPanel() {
        super(new BorderLayout());
        tecnicoController = new TecnicoController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Nome", "Especialidade", "Disponibilidade"
        },0);
        tecnicoTable = new JTable(tableModel);

        //criar tabelas e preencher a tabela com os dados
        List<Tecnico> tecnicos = tecnicoController.readTecnicos();
        for (Tecnico tecnico : tecnicos) {
            tableModel.addRow(new Object[]{
                tecnico.getId(),
                tecnico.getNome(),
                tecnico.getEspecialidade(),
                tecnico.getDisponibilidade()
            });
        }

        JScrollPane scrollPane = new JScrollPane(tecnicoTable);
        this.add(scrollPane, BorderLayout.CENTER);

        //adicionar botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarTecnico = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar Alterações");
        painelInferior.add(btnCadastrarTecnico);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // //implementar eventos dos botões
        // btnCadastrarTecnico.addActionListener(e -> {
        //     // TODO: implementar ação de cadastro de tecnico
        //     System.out.println("Cadastrando novo tecnico...");
        // });
    }
}
