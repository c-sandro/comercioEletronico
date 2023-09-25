import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OrderFrame {
    
    private static JFrame frame;
    private static JTable orderTable;
    private static DefaultTableModel tableModel;
    
    public static JFrame orderFrame(){ 
        frame = new JFrame("Gerenciamento de Pedidos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.getContentPane().add(mainPanel);
        frame.setLocation(480, 170);

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
        return frame;
    }
}
