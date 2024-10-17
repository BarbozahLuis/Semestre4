package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.FalhaController; // Certifique-se de que o controlador está implementado
import com.example.models.Falha; // Certifique-se de que a model está implementada

public class FalhasPanel extends JPanel {
    // Atributos
    private FalhaController falhaController;
    private JTable falhasTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarFalha;
    private JButton btnGerarRelatorio; // Novo botão para gerar relatório

    public FalhasPanel() {
        super(new BorderLayout());

        // Inicializando o controlador
        falhaController = new FalhaController();

        // Inicializando o model da tabela com as colunas
        tableModel = new DefaultTableModel(new Object[] {
                "ID", "Máquina ID", "Data", "Problema", "Prioridade", "Operador"
        }, 0);  // Número de linhas inicial: 0

        // Criar JTable com o model
        falhasTable = new JTable(tableModel);

        // Preenchendo a tabela com as falhas do controlador
        carregarFalhas();

        // Adicionando a JTable a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(falhasTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Criando painel inferior com botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarFalha = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Atualizar");
        btnGerarRelatorio = new JButton("Gerar Relatório"); // Inicializa o botão de relatório
        painelInferior.add(btnCadastrarFalha);
        painelInferior.add(btnSalvarAlteracoes);
        painelInferior.add(btnGerarRelatorio); // Adiciona o botão de relatório ao painel
        this.add(painelInferior, BorderLayout.SOUTH);

        // Adicionando ActionListeners para os botões
        addActionListeners();
    }

    private void carregarFalhas() {
        // Recupera a lista de falhas e preenche a tabela
        List<Falha> falhas = falhaController.readFalhas(); // Supondo que o método readFalhas retorna uma lista de Falha
        for (Falha falha : falhas) {
            tableModel.addRow(new Object[] {
                    falha.getId(),
                    falha.getMaquinaID(),
                    falha.getData().toString(),
                    falha.getProblema(),
                    falha.getPrioridade(),
                    falha.getOperador()
            });
        }
    }

    private void addActionListeners() {
        // ActionListener para o botão "Cadastrar"
        btnCadastrarFalha.addActionListener(e -> abrirDialogCadastro());

        // ActionListener para o botão "Salvar"
        btnSalvarAlteracoes.addActionListener(e -> editarFalha());

        // ActionListener para o botão "Gerar Relatório"
        btnGerarRelatorio.addActionListener(e -> gerarRelatorio());
    }

    private void gerarRelatorio() {
    StringBuilder sb = new StringBuilder();
    sb.append("ID,Máquina ID,Data,Problema,Prioridade,Operador\n"); // Cabeçalho do CSV

    for (int i = 0; i < tableModel.getRowCount(); i++) {
        for (int j = 0; j < tableModel.getColumnCount(); j++) {
            sb.append(tableModel.getValueAt(i, j).toString());
            if (j < tableModel.getColumnCount() - 1) {
                sb.append(","); // Adiciona vírgula entre os valores
            }
        }
        sb.append("\n"); // Nova linha após cada registro
    }

    // Cria um JFileChooser para selecionar o local e o nome do arquivo
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Salvar Relatório de Falhas");
    fileChooser.setSelectedFile(new java.io.File("relatorio_falhas.csv")); // Nome padrão do arquivo

    // Filtra apenas arquivos CSV
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("CSV Files", "csv"));

    int userSelection = fileChooser.showSaveDialog(this);
    
    // Verifica se o usuário selecionou um arquivo
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        java.io.File fileToSave = fileChooser.getSelectedFile(); // Obtém o arquivo selecionado
        
        // Tentativa de escrever o conteúdo do CSV no arquivo selecionado
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
            writer.write(sb.toString());
            JOptionPane.showMessageDialog(this, "Relatório gerado com sucesso: " + fileToSave.getAbsolutePath());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório: " + e.getMessage());
        }
    }
}


    private void abrirDialogCadastro() {
        // Cria um novo JDialog para o cadastro de falha
        JDialog dialog = new JDialog((JDialog) null, "Cadastrar Nova Falha", true);
        dialog.setSize(400, 400);
        dialog.setLayout(new GridLayout(0, 2));

        // Adiciona campos de texto para os atributos da falha
        JTextField jtfMaquinaId = new JTextField();
        JTextField jtfData = new JTextField(); // Sugere formato "yyyy-MM-dd"
        JTextField jtfProblema = new JTextField();
        JTextField jtfPrioridade = new JTextField();
        JTextField jtfOperador = new JTextField();

        // Adiciona rótulos e campos ao dialog
        dialog.add(new JLabel("Máquina ID:"));
        dialog.add(jtfMaquinaId);
        dialog.add(new JLabel("Data (Ano-Mes-Dia):"));
        dialog.add(jtfData);
        dialog.add(new JLabel("Problema:"));
        dialog.add(jtfProblema);
        dialog.add(new JLabel("Prioridade:"));
        dialog.add(jtfPrioridade);
        dialog.add(new JLabel("Operador:"));
        dialog.add(jtfOperador);

        // Botão para cadastrar a falha
        JButton btnSubmit = new JButton("Cadastrar");
        dialog.add(btnSubmit);

        // Quando o botão for clicado, valida e envia os dados
        btnSubmit.addActionListener(ev -> {
            try {
                // Recupera os dados dos campos de texto
                String maquinaId = jtfMaquinaId.getText();
                LocalDate data = LocalDate.parse(jtfData.getText());
                String problema = jtfProblema.getText();
                String prioridade = jtfPrioridade.getText();
                String operador = jtfOperador.getText();

                // Cria um novo objeto Falha
                Falha novaFalha = new Falha(null, maquinaId, data, problema, prioridade, operador);

                // Envia para a API
                Falha falhaCriada = falhaController.createFalha(novaFalha);

                // Se a falha criada não for nula, atualiza a tabela e fecha o diálogo
                if (falhaCriada != null) {
                    tableModel.addRow(new Object[]{
                            falhaCriada.getId(),
                            maquinaId,
                            data.toString(),
                            problema,
                            prioridade,
                            operador
                    });
                    JOptionPane.showMessageDialog(dialog, "Falha cadastrada com sucesso!");
                    dialog.dispose(); // Fecha o diálogo
                } else {
                    JOptionPane.showMessageDialog(dialog, "Erro ao cadastrar falha.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Erro ao preencher os dados: " + ex.getMessage());
            }
        });

        // Mostra o formulário
        dialog.setVisible(true);
    }

    private void editarFalha() {
        // Verifica se uma linha está selecionada
        int selectedRow = falhasTable.getSelectedRow();
        if (selectedRow != -1) {
            // Cria um novo JDialog para editar a falha
            JDialog dialog = new JDialog((JDialog) null, "Editar Falha", true);
            dialog.setSize(400, 400);
            dialog.setLayout(new GridLayout(0, 2));

            // Pega os valores da linha selecionada
            String id = String.valueOf(tableModel.getValueAt(selectedRow, 0)); // ID da falha
            String maquinaId = (String) tableModel.getValueAt(selectedRow, 1);
            LocalDate data = LocalDate.parse((String) tableModel.getValueAt(selectedRow, 2));
            String problema = (String) tableModel.getValueAt(selectedRow, 3);
            String prioridade = (String) tableModel.getValueAt(selectedRow, 4);
            String operador = (String) tableModel.getValueAt(selectedRow, 5);

            // Adiciona campos de texto para os atributos da falha
            JTextField jtfMaquinaId = new JTextField(maquinaId);
            JTextField jtfData = new JTextField(data.toString());
            JTextField jtfProblema = new JTextField(problema);
            JTextField jtfPrioridade = new JTextField(prioridade);
            JTextField jtfOperador = new JTextField(operador);

            // Adiciona rótulos e campos ao dialog
            dialog.add(new JLabel("Máquina ID:"));
            dialog.add(jtfMaquinaId);
            dialog.add(new JLabel("Data:"));
            dialog.add(jtfData);
            dialog.add(new JLabel("Problema:"));
            dialog.add(jtfProblema);
            dialog.add(new JLabel("Prioridade:"));
            dialog.add(jtfPrioridade);
            dialog.add(new JLabel("Operador:"));
            dialog.add(jtfOperador);

            // Botão para atualizar a falha
            JButton btnUpdate = new JButton("Atualizar");
            dialog.add(btnUpdate);

            // Quando o botão for clicado, valida e envia os dados
            btnUpdate.addActionListener(ev -> {
                try {
                    // Recupera os dados dos campos de texto
                    String newMaquinaId = jtfMaquinaId.getText();
                    LocalDate newData = LocalDate.parse(jtfData.getText());
                    String newProblema = jtfProblema.getText();
                    String newPrioridade = jtfPrioridade.getText();
                    String newOperador = jtfOperador.getText();

                    // Atualiza os dados da falha
                    Falha falhaAtualizada = new Falha(id, newMaquinaId, newData, newProblema, newPrioridade, newOperador);

                    // Envia para a API para atualizar a falha
                    falhaController.updateFalha(falhaAtualizada); // Supondo que esse método não retorne nada

                    // Exibe mensagem de sucesso
                    JOptionPane.showMessageDialog(dialog, "Alterações salvas com sucesso!");

                    // Atualiza a tabela para refletir as mudanças
                    tableModel.setValueAt(newMaquinaId, selectedRow, 1);
                    tableModel.setValueAt(newData.toString(), selectedRow, 2);
                    tableModel.setValueAt(newProblema, selectedRow, 3);
                    tableModel.setValueAt(newPrioridade, selectedRow, 4);
                    tableModel.setValueAt(newOperador, selectedRow, 5);

                    dialog.dispose(); // Fecha o diálogo
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Erro ao preencher os dados: " + ex.getMessage());
                }
            });

            // Mostra o formulário
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma falha para salvar alterações.");
        }

        
    }
}
