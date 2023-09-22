import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductFrame {
    
    private static JFrame frame;
    private static JTable productTable;
    private static DefaultTableModel tableModel;
    
    public static JFrame productFrame(){ 
        frame = new JFrame("Gerenciamento de Produtos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.getContentPane().add(mainPanel);
        frame.setLocation(480, 170);

    //###TABELA###
        tableModel = new DefaultTableModel();
        productTable = new JTable(tableModel);
        tableModel.addColumn("Nome");
        tableModel.addColumn("Preço");
        tableModel.addColumn("Quantidade");
        tableModel.addColumn("ID");
        JScrollPane scrollPane = new JScrollPane(productTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

    //###BOTÕES###
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
        return frame;
    }
}
