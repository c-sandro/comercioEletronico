package com.examp.window;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClientFrame extends JFrame{
    
    private JTable clientTable;
    private DefaultTableModel tableModel;

    private static JButton addButton = new JButton("Adicionar Cliente");
    private static JButton editButton = new JButton("Editar Cliente");
    private static JButton deleteButton = new JButton("Excluir Cliente");
    private static JButton exportButton = new JButton("Exportar Cliente");
    private static JButton importButton = new JButton("Importar Cliente");
    private static JButton backButton = new JButton("Voltar Ao Menu Principal");
    
    public ClientFrame(){ 
        this.setTitle("Gerenciamento de Clientes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        this.getContentPane().add(mainPanel);
        this.setLocation(480, 170);

        tableModel = new DefaultTableModel();
        clientTable = new JTable(tableModel);
        tableModel.addColumn("Nome");
        tableModel.addColumn("Endereço");
        tableModel.addColumn("CPF");
        tableModel.addColumn("Saldo");
        tableModel.addColumn("Produtos");
        JScrollPane scrollPane = new JScrollPane(clientTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(exportButton);
        buttonPanel.add(importButton);
        buttonPanel.add(backButton);

        this.pack();
        this.setVisible(false);
    }
    
    public JTable getClientTable(){
        return clientTable;
    }
    public DefaultTableModel getTableModel(){
        return tableModel;
    }
    public static JButton getAddButton(){
        return addButton;
    }
    public static JButton getEditButton(){
        return editButton;
    }
    public static JButton getDeleteButton(){
        return deleteButton;
    }
    public static JButton getExportButton(){
        return exportButton;
    }
    public static JButton getImportButton(){
        return importButton;
    }
    public static JButton getBackButton(){
        return backButton;
    }
    
}
