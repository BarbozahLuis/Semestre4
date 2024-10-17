package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.MaquinaController;
import com.example.models.Maquina;

public class MaquinasPanel extends JPanel {
    // Atributos
    private MaquinaController maquinaController;
    private JTable maquinasTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarMaquina;

    public MaquinasPanel() {
        super(new BorderLayout());

        // Inicializando o controlador
        maquinaController = new MaquinaController();

        // Inicializando o model da tabela com as colunas
        tableModel = new DefaultTableModel(new Object[] {
                "ID", "Código", "Nome", "Modelo", "Fabricante", "Data de Aquisição", "Tempo de Vida Estimado", "Localização", "Detalhes", "Manual"
        }, 0);  // Número de linhas inicial: 0

        // Criar JTable com o model
        maquinasTable = new JTable(tableModel);

        // Preenchendo a tabela com as máquinas do controlador
        List<Maquina> maquinas = maquinaController.readMaquinas();
        for (Maquina maquina : maquinas) {
            tableModel.addRow(new Object[] {
                    maquina.getId(),
                    maquina.getCodigo(),
                    maquina.getNome(),
                    maquina.getModelo(),
                    maquina.getFabricante(),
                    maquina.getDataAquisicao().toString(), // Converter LocalDate para String
                    maquina.getTempoVidaEstimado(),
                    maquina.getLocalizacao(),
                    maquina.getDetalhes(),
                    maquina.getManual()
            });
        }

        // Adicionando a JTable a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(maquinasTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // Criando painel inferior com botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarMaquina = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Atualizar");
        painelInferior.add(btnCadastrarMaquina);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Adicionando ActionListeners para os botões
        addActionListeners();
    }

    private void addActionListeners() {
        // ActionListener para o botão "Cadastrar"
        btnCadastrarMaquina.addActionListener(e -> {
            // Cria um novo JDialog para o cadastro de máquina
            JDialog dialog = new JDialog((JDialog) null, "Cadastrar Nova Máquina", true);
            dialog.setSize(400, 400);
            dialog.setLayout(new GridLayout(0, 2));

            // Adiciona campos de texto para os atributos da máquina
            JTextField jtfCodigo = new JTextField();
            JTextField jtfNome = new JTextField();
            JTextField jtfModelo = new JTextField();
            JTextField jtfFabricante = new JTextField();
            JTextField jtfDataAquisicao = new JTextField(); // Sugere formato "Ano-Mes-Dia"
            JTextField jtfTempoVidaEstimado = new JTextField();
            JTextField jtfLocalizacao = new JTextField();
            JTextField jtfDetalhes = new JTextField();
            JTextField jtfManual = new JTextField();

            // Adiciona rótulos e campos ao dialog
            dialog.add(new JLabel("Código:"));
            dialog.add(jtfCodigo);
            dialog.add(new JLabel("Nome:"));
            dialog.add(jtfNome);
            dialog.add(new JLabel("Modelo:"));
            dialog.add(jtfModelo);
            dialog.add(new JLabel("Fabricante:"));
            dialog.add(jtfFabricante);
            dialog.add(new JLabel("Data de Aquisição (Ano-Mes-Dia):"));
            dialog.add(jtfDataAquisicao);
            dialog.add(new JLabel("Tempo de Vida Estimado:"));
            dialog.add(jtfTempoVidaEstimado);
            dialog.add(new JLabel("Localização:"));
            dialog.add(jtfLocalizacao);
            dialog.add(new JLabel("Detalhes:"));
            dialog.add(jtfDetalhes);
            dialog.add(new JLabel("Manual (link ou descrição):"));
            dialog.add(jtfManual);

            // Botão para cadastrar a máquina
            JButton btnSubmit = new JButton("Cadastrar");
            dialog.add(btnSubmit);

            // Quando o botão for clicado, valida e envia os dados
            btnSubmit.addActionListener(ev -> {
                try {
                    // Recupera os dados dos campos de texto
                    String codigo = jtfCodigo.getText();
                    String nome = jtfNome.getText();
                    String modelo = jtfModelo.getText();
                    String fabricante = jtfFabricante.getText();
                    LocalDate dataAquisicao = LocalDate.parse(jtfDataAquisicao.getText()); // Valida data
                    int tempoVidaEstimado = Integer.parseInt(jtfTempoVidaEstimado.getText());
                    String localizacao = jtfLocalizacao.getText();
                    String detalhes = jtfDetalhes.getText();
                    String manual = jtfManual.getText();

                    // Cria um novo objeto Maquina
                    Maquina novaMaquina = new Maquina(null, codigo, nome, modelo, fabricante, dataAquisicao, tempoVidaEstimado,
                            localizacao, detalhes, manual);

                    // Envia para a API
                    Maquina maquinaCriada = maquinaController.createMaquina(novaMaquina);

                    // Se a máquina criada não for nula, atualiza a tabela e fecha o diálogo
                    if (maquinaCriada != null) {
                        tableModel.addRow(new Object[]{
                                maquinaCriada.getId(), // Assume que o ID é retornado na criação
                                codigo, nome, modelo, fabricante, dataAquisicao.toString(), // Convertendo LocalDate para String
                                tempoVidaEstimado, localizacao, detalhes, manual
                        });
                        JOptionPane.showMessageDialog(dialog, "Máquina cadastrada com sucesso!");
                        dialog.dispose(); // Fecha o diálogo
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Erro ao cadastrar máquina.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Erro ao preencher os dados: " + ex.getMessage());
                }
            });

            // Mostra o formulário
            dialog.setVisible(true);
        });

        // ActionListener para o botão "Salvar"
        btnSalvarAlteracoes.addActionListener(e -> {
            // Verifica se uma linha está selecionada
            int selectedRow = maquinasTable.getSelectedRow();
            if (selectedRow != -1) {
                // Cria um novo JDialog para editar a máquina
                JDialog dialog = new JDialog((JDialog) null, "Editar Máquina", true);
                dialog.setSize(400, 400);
                dialog.setLayout(new GridLayout(0, 2));

                // Pega os valores da linha selecionada
                String id = String.valueOf(tableModel.getValueAt(selectedRow, 0)); // ID da máquina
                String codigo = (String) tableModel.getValueAt(selectedRow, 1);
                String nome = (String) tableModel.getValueAt(selectedRow, 2);
                String modelo = (String) tableModel.getValueAt(selectedRow, 3);
                String fabricante = (String) tableModel.getValueAt(selectedRow, 4);
                LocalDate dataAquisicao = LocalDate.parse((String) tableModel.getValueAt(selectedRow, 5)); // Conversão correta
                int tempoVidaEstimado = Integer.parseInt(tableModel.getValueAt(selectedRow, 6).toString());
                String localizacao = (String) tableModel.getValueAt(selectedRow, 7);
                String detalhes = (String) tableModel.getValueAt(selectedRow, 8);
                String manual = (String) tableModel.getValueAt(selectedRow, 9);

                // Adiciona campos de texto para os atributos da máquina
                JTextField jtfCodigo = new JTextField(codigo);
                JTextField jtfNome = new JTextField(nome);
                JTextField jtfModelo = new JTextField(modelo);
                JTextField jtfFabricante = new JTextField(fabricante);
                JTextField jtfDataAquisicao = new JTextField(dataAquisicao.toString()); // Formato "Ano-Mes-Dia"
                JTextField jtfTempoVidaEstimado = new JTextField(String.valueOf(tempoVidaEstimado));
                JTextField jtfLocalizacao = new JTextField(localizacao);
                JTextField jtfDetalhes = new JTextField(detalhes);
                JTextField jtfManual = new JTextField(manual);

                // Adiciona rótulos e campos ao dialog
                dialog.add(new JLabel("Código:"));
                dialog.add(jtfCodigo);
                dialog.add(new JLabel("Nome:"));
                dialog.add(jtfNome);
                dialog.add(new JLabel("Modelo:"));
                dialog.add(jtfModelo);
                dialog.add(new JLabel("Fabricante:"));
                dialog.add(jtfFabricante);
                dialog.add(new JLabel("Data de Aquisição (Ano-Mes-Dia):"));
                dialog.add(jtfDataAquisicao);
                dialog.add(new JLabel("Tempo de Vida Estimado:"));
                dialog.add(jtfTempoVidaEstimado);
                dialog.add(new JLabel("Localização:"));
                dialog.add(jtfLocalizacao);
                dialog.add(new JLabel("Detalhes:"));
                dialog.add(jtfDetalhes);
                dialog.add(new JLabel("Manual (link ou descrição):"));
                dialog.add(jtfManual);

                // Botão para salvar as alterações
                JButton btnSubmit = new JButton("Salvar");
                dialog.add(btnSubmit);

                // Quando o botão "Salvar" for clicado, valida e envia os dados
                btnSubmit.addActionListener(ev -> {
                    try {
                        // Recupera os dados dos campos de texto
                        String newCodigo = jtfCodigo.getText();
                        String newNome = jtfNome.getText();
                        String newModelo = jtfModelo.getText();
                        String newFabricante = jtfFabricante.getText();
                        LocalDate newDataAquisicao = LocalDate.parse(jtfDataAquisicao.getText());
                        int newTempoVidaEstimado = Integer.parseInt(jtfTempoVidaEstimado.getText());
                        String newLocalizacao = jtfLocalizacao.getText();
                        String newDetalhes = jtfDetalhes.getText();
                        String newManual = jtfManual.getText();

                        // Atualiza os dados da máquina
                        Maquina maquinaAtualizada = new Maquina(id, newCodigo, newNome, newModelo, newFabricante,
                                newDataAquisicao, newTempoVidaEstimado, newLocalizacao, newDetalhes, newManual);

                        // Envia para a API para atualizar a máquina
                        maquinaController.updateMaquina(maquinaAtualizada); // Supondo que esse método não retorne nada

                        // Exibe mensagem de sucesso
                        JOptionPane.showMessageDialog(dialog, "Alterações salvas com sucesso!");

                        // Atualiza a tabela para refletir as mudanças
                        tableModel.setValueAt(newCodigo, selectedRow, 1);
                        tableModel.setValueAt(newNome, selectedRow, 2);
                        tableModel.setValueAt(newModelo, selectedRow, 3);
                        tableModel.setValueAt(newFabricante, selectedRow, 4);
                        tableModel.setValueAt(newDataAquisicao.toString(), selectedRow, 5); // Aqui convertemos para String
                        tableModel.setValueAt(newTempoVidaEstimado, selectedRow, 6);
                        tableModel.setValueAt(newLocalizacao, selectedRow, 7);
                        tableModel.setValueAt(newDetalhes, selectedRow, 8);
                        tableModel.setValueAt(newManual, selectedRow, 9);

                        dialog.dispose(); // Fecha o diálogo
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(dialog, "Erro ao preencher os dados: " + ex.getMessage());
                    }
                });

                // Mostra o formulário
                dialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma máquina para salvar alterações.");
            }
        });
    }
}