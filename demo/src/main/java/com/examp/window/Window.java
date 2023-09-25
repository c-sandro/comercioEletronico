package com.examp.window;

import javax.swing.*;

import com.examp.App;

public class Window extends JFrame{

    private JFrame frame;
    private ClientFrame clientFrame;
    private ProductFrame productFrame;
    private OrderFrame orderFrame;

    int userOption = 0;

    App app;

    public Window(App app){
        String[] options = {"Cliente", "Produto", "Pedidos", "Sair"};

        this.app = app;

        userOption = JOptionPane.showOptionDialog(
            this, 
            "O que você desejar acessar?", 
            "Gerenciamento de E-commerce", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            options, 
            0);
            
        if(userOption == 0){
            clientFrame = new ClientFrame();

            ClientFrame.getAddButton().addActionListener(this.app);
            ClientFrame.getEditButton().addActionListener(this.app);
            ClientFrame.getDeleteButton().addActionListener(this.app);
            ClientFrame.getBackButton().addActionListener(this.app);
            
        }else if(userOption == 1){
            productFrame = new ProductFrame();

            ProductFrame.getAddButton().addActionListener(this.app);
            ProductFrame.getEditButton().addActionListener(this.app);
            ProductFrame.getDeleteButton().addActionListener(this.app);
            ProductFrame.getBackButton().addActionListener(this.app);

        }else if(userOption == 2){
            orderFrame = new OrderFrame();

            OrderFrame.getAddButton().addActionListener(this.app);
            OrderFrame.getEditButton().addActionListener(this.app);
            OrderFrame.getDeleteButton().addActionListener(this.app);
            OrderFrame.getBackButton().addActionListener(this.app);

        }else{
            JOptionPane.showMessageDialog(null, "Programa Encerrado");
        }
        
    }
    
    public String[] createProduct(){

        String[] productParams = {"", "", "", ""};

        //prevenir que o input seja vazio
        do{
            productParams[0] = JOptionPane.showInputDialog(this, "Nome: ");
        }while(productParams[0].equals(""));

        //os 3 previnem que outra coisa alem de numero esteja no input
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

    public String[] editProduct(){

        String[] newParams = {"", "", ""};

        do{
            try{
                newParams[0] = JOptionPane.showInputDialog(this, "ID do Produto: ");
                Integer.parseInt(newParams[0]);
                break;
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
            }
        }while(true);

        String[] options = {"Nome", "Preço", "Quantidade"};

        userOption = JOptionPane.showOptionDialog(
            this, 
            "O que você desejar alterar?", 
            "Editar Produto", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            options, 
            0);

        if(userOption == 0){
            newParams[1] = "NAME";
            newParams[2] = JOptionPane.showInputDialog(this, "Novo Nome: ");
        }else if(userOption == 1){
            do{
                try{
                    newParams[1] = "PRICE";
                    newParams[2] = JOptionPane.showInputDialog(this, "Novo Preço: ");
                    Float.parseFloat(newParams[2]);
                    break;
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Coloque um valor válido");
                }

            }while(true);
        }else{
            do{
                try{
                    newParams[1] = "QUANTITY";
                    newParams[2] = JOptionPane.showInputDialog(this, "Nova Quantidade: ");
                    Integer.parseInt(newParams[2]);
                    break;
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Coloque um valor válido");
                }
            }while(true);
        }

        return newParams;

    }

    public int deleteProduct(){

        String[] options = {"Sim", "Não"};
        int productId;

        do{
            try{
                productId = Integer.parseInt(JOptionPane.showInputDialog(this, "ID do Produto: "));
                break;
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
            }
        }while(true);

        userOption = JOptionPane.showOptionDialog(
            this, 
            "Você tem certeza?", 
            "Confirmar", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            options, 
            0);

        return (userOption == 0) ? productId : -1;

    }

    public JFrame getFrame(){
        return frame;
    }
    public ClientFrame getClientFrame() {
        return clientFrame;
    }
    public ProductFrame getProductFrame() {
        return productFrame;
    }
    public OrderFrame getOrderFrame() {
        return orderFrame;
    }

}