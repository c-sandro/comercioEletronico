//package window;
import javax.swing.*;

public class Window extends JFrame{

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
            JOptionPane.showInputDialog(null, "nome");
                
                if(userOption == 0){
                    ProductFrame.productFrame();
                    break;
                } 
                else if (userOption == 1) {
                    ClientFrame.clientFrame();
                    break;
                } 
                else if (userOption == 2) {
                    OrderFrame.orderFrame();
                    break;
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Programa Encerrado");
                }
            }
    }
}