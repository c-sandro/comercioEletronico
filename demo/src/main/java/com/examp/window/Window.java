package com.examp.window;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.examp.App;

public class Window extends JFrame{

    private static JFrame frame = new JFrame("Gerenciamento de Produtos");
    private static JTable table;
    private static DefaultTableModel tableModel;
    
    public JButton addProductButton = new JButton("Adicionar Produto");
    public JButton editProductButton = new JButton("Editar Produto");
    public JButton deleteProductButton = new JButton("Excluir Produto");
    public JButton backButton = new JButton("Voltar Ao Menu Principal");
    public JButton addClientButton = new JButton("Adicionar Cliente");
    public JButton editClientButton = new JButton("Editar Cliente");
    public JButton deleteClientButton = new JButton("Excluir Cliente");
    public JButton addOrderButton = new JButton("Adicionar Pedido");
    public JButton editOrderButton = new JButton("Editar Pedido");
    public JButton deleteOrderButton = new JButton("Excluir Pedido");

    int userOption = 0;

    App app;

    public Window(App app){
        String[] options = new String[]{
            "produto",
            "cliente",
            "pedidos",
            "sair"
        };

        this.app = app;

        while(userOption != 3){
            userOption = JOptionPane.showOptionDialog(
                null, 
                "O que você desejar acessar?", 
                "Gerenciamento de E-commerce", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                0);
                
            if(userOption == 0){
                ProductFrame();
                break;
            } 
            else if(userOption == 1){
                ClientFrame();
                break;
            } 
            else if(userOption == 2){
                OrderFrame();
                break;
            } 
            else{
                JOptionPane.showMessageDialog(null, "Programa Encerrado");
            }
        }
    }


    public JFrame ProductFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout());

        frame.getContentPane().add(mainPanel);
        frame.setLocation(480, 170);

    //###TABELA###
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        tableModel.addColumn("Nome");
        tableModel.addColumn("Preço");
        tableModel.addColumn("Quantidade");
        tableModel.addColumn("ID");
        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

    //###BOTÕES###
        JPanel buttonPanel = new JPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        addProductButton.setBackground(Color.lightGray);
        editProductButton.setBackground(Color.lightGray);
        deleteProductButton.setBackground(Color.lightGray);
        backButton.setBackground(Color.lightGray);
        buttonPanel.setBackground(Color.gray);

        buttonPanel.add(addProductButton);
        buttonPanel.add(editProductButton);
        buttonPanel.add(deleteProductButton);
        buttonPanel.add(backButton);

        addProductButton.addActionListener(app);
        editProductButton.addActionListener(app);
        deleteProductButton.addActionListener(app);
        backButton.addActionListener(app);

        frame.pack();
        frame.setVisible(true);
        return frame;
    }
    
    public JFrame OrderFrame(){
        frame = new JFrame("Gerenciamento de Pedidos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.getContentPane().add(mainPanel);
        frame.setLocation(480, 170);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Pedido");
        tableModel.addColumn("Cliente");
        tableModel.addColumn("Valor");
        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);


        buttonPanel.add(addOrderButton);
        buttonPanel.add(editOrderButton);
        buttonPanel.add(deleteOrderButton);
        buttonPanel.add(backButton);
        addOrderButton.addActionListener(app);
        editOrderButton.addActionListener(app);
        deleteOrderButton.addActionListener(app);
        backButton.addActionListener(app);

        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    public JFrame ClientFrame(){
        frame = new JFrame("Gerenciamento de Clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.getContentPane().add(mainPanel);
        frame.setLocation(480, 170);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        tableModel.addColumn("Nome");
        tableModel.addColumn("Endereço");
        tableModel.addColumn("CPF");
        tableModel.addColumn("Saldo");
        JScrollPane scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.add(addClientButton);
        buttonPanel.add(editClientButton);
        buttonPanel.add(deleteClientButton);
        buttonPanel.add(backButton);
        addClientButton.addActionListener(app);
        editClientButton.addActionListener(app);
        deleteClientButton.addActionListener(app);
        backButton.addActionListener(app);

        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    public String[] createProduct(){

        String[] productParams = {"", "", "", ""};

        productParams[0] = JOptionPane.showInputDialog(this, "Nome: ");
        do{
            try{
                productParams[1] = JOptionPane.showInputDialog(this, "Preço (em R$): ");
                Float.parseFloat(productParams[1]);
                break;
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
            }
        }while(true);
        do{
            try{
                productParams[2] = JOptionPane.showInputDialog(this, "Quantidade: ");
                Integer.parseInt(productParams[2]);
                break;
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
            }
        }while(true);
        do{
            try{
                productParams[3] = JOptionPane.showInputDialog(this, "Id (único pra cada produto): ");
                Integer.parseInt(productParams[3]);
                break;
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
            }
        }while(true);

        return productParams;

    }

}