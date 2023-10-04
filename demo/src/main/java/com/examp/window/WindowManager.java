package com.examp.window;

import javax.swing.*;

import com.examp.App;

public class WindowManager extends JFrame{

    private ClientFrame clientFrame = new ClientFrame();
    private ProductFrame productFrame = new ProductFrame();
    private OrderFrame orderFrame = new OrderFrame();

    private App app;

    public WindowManager(App app){

        this.app = app;
        startWindow();
        
    }

    public void startWindow(){

        String[] options = {"Cliente", "Produto", "Pedidos", "Sair"};

        int userOption = JOptionPane.showOptionDialog(
            this, 
            "O que você desejar acessar?", 
            "Gerenciamento de E-commerce", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            options, 
            0);
            
        if(userOption == 0){
            this.clientFrame.setVisible(true);

            this.app.refreshClient();

            ClientFrame.getAddButton().addActionListener(this.app);
            ClientFrame.getEditButton().addActionListener(this.app);
            ClientFrame.getDeleteButton().addActionListener(this.app);
            ClientFrame.getBackButton().addActionListener(this.app);
            
        }else if(userOption == 1){
            this.productFrame.setVisible(true);

            this.app.refreshProduct();

            ProductFrame.getAddButton().addActionListener(this.app);
            ProductFrame.getEditButton().addActionListener(this.app);
            ProductFrame.getDeleteButton().addActionListener(this.app);
            ProductFrame.getBackButton().addActionListener(this.app);

        }else if(userOption == 2){
            this.orderFrame.setVisible(true);

            this.app.refreshOrder();

            OrderFrame.getAddButton().addActionListener(this.app);
            OrderFrame.getDeleteButton().addActionListener(this.app);
            OrderFrame.getBackButton().addActionListener(this.app);

        }else if(userOption == 3){
            JOptionPane.showMessageDialog(null, "Programa encerrado");
            System.exit(0);
        }

    }
    
    //###FUNÇÕES DA ABA DO CLIENTE###
    public String[] createClient(){

        String[] clientParams = {"", "", "", ""};

        //prevenir que os 2 input sejam vazios
        do{
            clientParams[0] = JOptionPane.showInputDialog(this, "Nome: ");
        }while(clientParams[0].equals(""));

        do{
            clientParams[1] = JOptionPane.showInputDialog(this, "Endereço: ");
        }while(clientParams[1].equals(""));

        //os 2 previnem que outra coisa alem de numero esteja no input
        do{
            try{

                clientParams[2] = JOptionPane.showInputDialog(this, "CPF (somente números): ");
                Long.parseLong(clientParams[2]);

                if(clientParams[2].length() == 11){
                    break;
                }

                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
                

            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
                
            }
        }while(true);
        do{
            try{

                clientParams[3] = JOptionPane.showInputDialog(this, "Saldo (em R$): ");
                Float.parseFloat(clientParams[3]);
                break;

            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
                
            }
        }while(true);

        return clientParams;

    }

    public String[] editClient(){

        String[] newParams = {"", "", ""};

        do{
            try{
                newParams[0] = JOptionPane.showInputDialog(this, "CPF do cliente: ");
                Long.parseLong(newParams[0]);
                if(newParams[0].length() == 11){
                    break;
                }
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
            }
        }while(true);

        String[] options = {"Nome", "Endereço", "Saldo"};

        int userOption = JOptionPane.showOptionDialog(
            this, 
            "O que você desejar alterar?", 
            "Editar Cliente", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            options, 
            0);

        if(userOption == 0){

            newParams[1] = "NAME";

            do{
                newParams[2] = JOptionPane.showInputDialog(this, "Novo nome: ");
            }while(newParams[2].equals(""));

        }else if(userOption == 1){

            newParams[1] = "ADRESS";

            do{
                newParams[2] = JOptionPane.showInputDialog(this, "Novo endereço: ");
            }while(newParams[2].equals(""));

        }else if(userOption == 2){

            do{
                try{

                    newParams[1] = "BALANCE";
                    newParams[2] = JOptionPane.showInputDialog(this, "Novo saldo: ");

                    Integer.parseInt(newParams[2]);
                    break;

                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Coloque um valor válido");
                }

            }while(true);

        } else {

        }

        return newParams;

    }

    public String deleteClient(){

        String[] options = {"Sim", "Não"};
        String clientCpf;

        do{
            try{

                clientCpf = JOptionPane.showInputDialog(this, "CPF do cliente: ");
                Integer.parseInt(clientCpf);
                if(clientCpf.length() == 11){
                    break;
                }
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");

            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
            }
        }while(true);

        int userOption = JOptionPane.showOptionDialog(
            this, 
            "Você tem certeza?", 
            "Confirmar", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            options, 
            0);

        return (userOption == 0) ? clientCpf : "-1";

    }

    //###FUNÇÕES DA ABA DO PRODUTO###
    public String[] createProduct(){

        String[] productParams = {"", "", "", "", ""};

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

                productParams[3] = JOptionPane.showInputDialog(this, "ID (único pra cada produto): ");
                Integer.parseInt(productParams[3]);
                break;

            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
            }

        }while(true);
        do{

            try{

                productParams[4] = JOptionPane.showInputDialog(this, "CPF do vendedor: ");
                Long.parseLong(productParams[4]);

                if(productParams[4].length() == 11){
                    break;
                }

                JOptionPane.showMessageDialog(this, "Coloque um valor válido");

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

        int userOption = JOptionPane.showOptionDialog(
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

            do{
                newParams[2] = JOptionPane.showInputDialog(this, "Novo nome: ");
            }while(newParams[2].equals(""));

        }else if(userOption == 1){

            do{

                try{

                    newParams[1] = "PRICE";
                    newParams[2] = JOptionPane.showInputDialog(this, "Novo preço: ");

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
                    newParams[2] = JOptionPane.showInputDialog(this, "Nova quantidade: ");

                    Integer.parseInt(newParams[2]);
                    break;

                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Coloque um valor válido");
                }

            }while(true);

        }

        return newParams;

    }

    public String deleteProduct(){

        String[] options = {"Sim", "Não"};
        String productId;

        do{

            try{

                productId = JOptionPane.showInputDialog(this, "ID do produto: ");
                Integer.parseInt(productId);
                break;

            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
            }

        }while(true);

        int userOption = JOptionPane.showOptionDialog(
            this, 
            "Você tem certeza?", 
            "Confirmar", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            options, 
            0);

        return (userOption == 0) ? productId : "";

    }

    //###FUNÇÕES DA ABA DA ORDEM###
    public String[] createOrder(){

        String[] orderParams = {"", "", "", "", ""};

        do{

            try{

                orderParams[0] = JOptionPane.showInputDialog(this, "CPF do cliente: ");
                Long.parseLong(orderParams[0]);

                if(orderParams[0].length() == 11){
                    break;
                }

                JOptionPane.showMessageDialog(this, "Coloque um valor válido");

            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
            }

        }while(true);
        do{

            try{

                orderParams[1] = JOptionPane.showInputDialog(this, "ID do produto: ");
                Integer.parseInt(orderParams[1]);
                break;

            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
            }

        }while(true);
        do{
            
            try{
                
                orderParams[2] = JOptionPane.showInputDialog(this, "ID da ordem: ");
                Integer.parseInt(orderParams[2]);
                break;
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
            }
            
        }while(true);
        do{

            try{

                orderParams[3] = JOptionPane.showInputDialog(this, "Quantidade: ");
                Integer.parseInt(orderParams[3]);
                break;

            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
            }

        }while(true);
        
        orderParams[4] = Double.toString( Math.floor((Math.random()*15) + 15 ));
        orderParams[4] = orderParams[4].substring(0, 2);

        return orderParams;

    }

    public String deleteOrder(){

        String[] options = {"Sim", "Não"};
        String orderId;

        do{

            try{

                orderId = JOptionPane.showInputDialog(this, "ID da ordem: ");
                Integer.parseInt(orderId);
                break;

            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Coloque um valor válido");
            }

        }while(true);

        int userOption = JOptionPane.showOptionDialog(
            this, 
            "Você tem certeza?", 
            "Confirmar", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            options, 
            0);

        return (userOption == 0) ? orderId : "";

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