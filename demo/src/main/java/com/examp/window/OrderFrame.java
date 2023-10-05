package com.examp.window;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OrderFrame extends JFrame{
    
    private JTable orderTable;
    private DefaultTableModel tableModel;

    private static JButton addButton = new JButton("Adicionar Pedido");
    private static JButton deleteButton = new JButton("Excluir Pedido");
    private static JButton exportButton = new JButton("Exportar Produto");
    private static JButton importButton = new JButton("Importar Produto");
    private static JButton backButton = new JButton("Voltar Ao Menu Principal");
    
    public OrderFrame(){ 
        this.setTitle("Gerenciamento de Pedidos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        this.getContentPane().add(mainPanel);
        this.setLocation(480, 170);

        tableModel = new DefaultTableModel();
        orderTable = new JTable(tableModel);
        tableModel.addColumn("Cliente");
        tableModel.addColumn("Produto");
        tableModel.addColumn("ID");
        tableModel.addColumn("Quantidade");
        tableModel.addColumn("Tempo de entrega");
        JScrollPane scrollPane = new JScrollPane(orderTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(exportButton);
        buttonPanel.add(importButton);
        buttonPanel.add(backButton);

        this.pack();
        this.setVisible(false);
    }

    public JTable getOrderTable(){
        return orderTable;
    }
    public DefaultTableModel getTableModel(){
        return tableModel;
    }
    public static JButton getAddButton(){
        return addButton;
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
