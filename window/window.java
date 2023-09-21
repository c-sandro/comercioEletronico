//package window;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class window extends JFrame{
    
    private static JFrame frame;
    private static JTable productTable;
    private static DefaultTableModel tableModel;
    public static void main(String[] args){
        String[] options = new String[]{
            "produto",
            "cliente",
            "pedidos",
            "sair"
        };

        int userOption = 0;

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
                    frame = new JFrame("Gerenciamento de Produtos");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    JPanel mainPanel = new JPanel(new BorderLayout());
                    frame.getContentPane().add(mainPanel);

                //TABELA
                    tableModel = new DefaultTableModel();
                    productTable = new JTable(tableModel);
                    tableModel.addColumn("Nome");
                    tableModel.addColumn("Preço");
                    tableModel.addColumn("Quantidade");
                    tableModel.addColumn("ID");
                    JScrollPane scrollPane = new JScrollPane(productTable);
                    mainPanel.add(scrollPane, BorderLayout.CENTER);

                //BOTÕES
                    JPanel buttonPanel = new JPanel();
                    mainPanel.add(buttonPanel, BorderLayout.SOUTH);

                
                    JButton addButton = new JButton("Adicionar Produto");
                    JButton editButton = new JButton("Editar Produto");
                    JButton deleteButton = new JButton("Excluir Produto");
                    JButton backButton = new JButton("Voltar Ao Menu Principal");

                    buttonPanel.add(addButton);
                    buttonPanel.add(editButton);
                    buttonPanel.add(deleteButton);
                    buttonPanel.add(backButton);

                    frame.pack();
                    frame.setVisible(true);
                    } 
                    else if (userOption == 1) {
                    frame = new JFrame("Gerenciamento de Clientes");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    JPanel mainPanel = new JPanel(new BorderLayout());
                    frame.getContentPane().add(mainPanel);

                    tableModel = new DefaultTableModel();
                    productTable = new JTable(tableModel);
                    tableModel.addColumn("Nome");
                    tableModel.addColumn("Sobrenome");
                    tableModel.addColumn("Endereço");
                    tableModel.addColumn("CPF");
                    JScrollPane scrollPane = new JScrollPane(productTable);
                    mainPanel.add(scrollPane, BorderLayout.CENTER);

                    JPanel buttonPanel = new JPanel();
                    mainPanel.add(buttonPanel, BorderLayout.SOUTH);

                    JButton addButton = new JButton("Adicionar Cliente");
                    JButton editButton = new JButton("Editar Cliente");
                    JButton deleteButton = new JButton("Excluir Cliente");
                    JButton backButton = new JButton("Voltar Ao Menu Principal");

                    buttonPanel.add(addButton);
                    buttonPanel.add(editButton);
                    buttonPanel.add(deleteButton);
                    buttonPanel.add(backButton);

                    frame.pack();
                    frame.setVisible(true);
                    } 
                    else if (userOption == 2) {
                    frame = new JFrame("Gerenciamento de Pedidos");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    JPanel mainPanel = new JPanel(new BorderLayout());
                    frame.getContentPane().add(mainPanel);

                    tableModel = new DefaultTableModel();
                    productTable = new JTable(tableModel);
                    tableModel.addColumn("ID");
                    tableModel.addColumn("Pedido");
                    tableModel.addColumn("Cliente");
                    tableModel.addColumn("Valor");
                    JScrollPane scrollPane = new JScrollPane(productTable);
                    mainPanel.add(scrollPane, BorderLayout.CENTER);

                    JPanel buttonPanel = new JPanel();
                    mainPanel.add(buttonPanel, BorderLayout.SOUTH);

                    JButton addButton = new JButton("Adicionar Pedido");
                    JButton editButton = new JButton("Editar Pedido");
                    JButton deleteButton = new JButton("Excluir Pedido");
                    JButton backButton = new JButton("Voltar Ao Menu Principal");

                    buttonPanel.add(addButton);
                    buttonPanel.add(editButton);
                    buttonPanel.add(deleteButton);
                    buttonPanel.add(backButton);

                    frame.pack();
                    frame.setVisible(true);
                } 
            }JOptionPane.showMessageDialog(null, "Encerrando programa...");
    }
}