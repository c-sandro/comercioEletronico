import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Window extends JFrame implements ActionListener{

    private JFrame frame = new JFrame("Gerenciamento de Produtos");
    private JTable table;
    private DefaultTableModel tableModel;
    
    JButton addProductButton = new JButton("Adicionar Produto");
    JButton editProductButton = new JButton("Editar Produto");
    JButton deleteProductButton = new JButton("Excluir Produto");
    JButton backButton = new JButton("Voltar Ao Menu Principal");
    JButton addClientButton = new JButton("Adicionar Cliente");
    JButton editClientButton = new JButton("Editar Cliente");
    JButton deleteClientButton = new JButton("Excluir Cliente");
    JButton addOrderButton = new JButton("Adicionar Pedido");
    JButton editOrderButton = new JButton("Editar Pedido");
    JButton deleteOrderButton = new JButton("Excluir Pedido");

    int userOption = 0;

    public Window(){
        String[] options = new String[]{
            "produto",
            "cliente",
            "pedidos",
            "sair"
        };

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
            else if (userOption == 1) {
                ClientFrame();
                break;
            } 
            else if (userOption == 2) {
                OrderFrame();
                break;
            } 
            else {
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

        buttonPanel.add(addProductButton);
        buttonPanel.add(editProductButton);
        buttonPanel.add(deleteProductButton);
        buttonPanel.add(backButton);
        addProductButton.addActionListener(this);
        editProductButton.addActionListener(this);
        deleteProductButton.addActionListener(this);
        backButton.addActionListener(this);

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
        addOrderButton.addActionListener(this);
        editOrderButton.addActionListener(this);
        deleteOrderButton.addActionListener(this);
        backButton.addActionListener(this);

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
        addClientButton.addActionListener(this);
        editClientButton.addActionListener(this);
        deleteClientButton.addActionListener(this);
        backButton.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    
            public static void main(String[] args){
                new Window();
            }


            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==addProductButton){
                    JOptionPane.showMessageDialog(rootPane, "teste adicionar produto");
                } else if(e.getSource()==editProductButton){
                    JOptionPane.showMessageDialog(rootPane, "teste editar produto");
                } else if(e.getSource()==deleteProductButton){
                    JOptionPane.showMessageDialog(rootPane, "teste deletar produto");
                } else if(e.getSource()==backButton){
                    JOptionPane.showMessageDialog(rootPane, "teste voltar");
                } else if(e.getSource()==addClientButton){
                    JOptionPane.showMessageDialog(rootPane, "teste adicionar cliente");
                } else if(e.getSource()==editClientButton){
                    JOptionPane.showMessageDialog(rootPane, "teste editar cliente");
                } else if(e.getSource()==deleteClientButton){
                    JOptionPane.showMessageDialog(rootPane, "teste deletar cliente");
                }else if(e.getSource()==addOrderButton){
                    JOptionPane.showMessageDialog(rootPane, "teste adicionar pedido");
                } else if(e.getSource()==editOrderButton){
                    JOptionPane.showMessageDialog(rootPane, "teste editar pedido");
                } else if(e.getSource()==deleteOrderButton){
                    JOptionPane.showMessageDialog(rootPane, "teste deletar pedido");
                }
            }
}
