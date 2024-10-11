package com.example.view;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import com.example.controllers.TecnicoController;
import com.example.models.Tecnico;

public class TecnicosPanel extends JPanel {
    // Atributos
    private TecnicoController tecnicoController;
    private JTable tecnicosTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarTecnico;

    // Construtor
    public TecnicosPanel() {
        super(new BorderLayout());
        tecnicoController = new TecnicoController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Nome", "Especialidade", "Disponibilidade"
        }, 0);
        tecnicosTable = new JTable(tableModel);

        // Preencher a tabela com os dados
        List<Tecnico> tecnicos = tecnicoController.readTecnicos();
        for (Tecnico tecnico : tecnicos) {
            tableModel.addRow(new Object[]{
                tecnico.getId(),
                tecnico.getNome(),
                tecnico.getEspecialidade(),
                tecnico.getDisponibilidade()
            });
        }
        JScrollPane scrollPane = new JScrollPane(tecnicosTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarTecnico = new JButton("Cadastrar Técnico");
        btnSalvarAlteracoes = new JButton("Salvar Alterações");
        painelInferior.add(btnCadastrarTecnico);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Criar as ActionListener para os botões
        // TODO: Adicionar ActionListeners para os botões
    }
}