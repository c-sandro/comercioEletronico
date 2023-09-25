import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClientFrame {
    
    private static JFrame frame;
    private static JTable clientTable;
    private static DefaultTableModel tableModel;
    
    public static JFrame clientFrame(){ 
        frame = new JFrame("Gerenciamento de Clientes");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    JPanel mainPanel = new JPanel(new BorderLayout());
                    frame.getContentPane().add(mainPanel);
                    frame.setLocation(480, 170);

                    tableModel = new DefaultTableModel();
                    clientTable = new JTable(tableModel);
                    tableModel.addColumn("Nome");
                    tableModel.addColumn("Endereço");
                    tableModel.addColumn("CPF");
                    tableModel.addColumn("Saldo");
                    JScrollPane scrollPane = new JScrollPane(clientTable);
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
                    return frame;
    }
}
