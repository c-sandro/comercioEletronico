package com.examp.window;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OrderFrame extends JFrame{
    
    private JTable orderTable;
    private DefaultTableModel tableModel;

    private static JButton addButton = new JButton("Adicionar Pedido");
    private static JButton editButton = new JButton("Editar Pedido");
    private static JButton deleteButton = new JButton("Excluir Pedido");
    private static JButton backButton = new JButton("Voltar Ao Menu Principal");
    
    public OrderFrame(){ 
        this.setTitle("Gerenciamento de Pedidos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        this.getContentPane().add(mainPanel);
        this.setLocation(480, 170);

        tableModel = new DefaultTableModel();
        orderTable = new JTable(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Pedido");
        tableModel.addColumn("Cliente");
        tableModel.addColumn("Valor");
        JScrollPane scrollPane = new JScrollPane(orderTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);

        this.pack();
        this.setVisible(true);
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
    public static JButton getEditButton(){
        return editButton;
    }
    public static JButton getDeleteButton(){
        return deleteButton;
    }
    public static JButton getBackButton(){
        return backButton;
    }
    
}
