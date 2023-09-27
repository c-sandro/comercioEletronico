package com.examp;

import java.awt.event.*;
import javax.swing.*;

import com.examp.client.*;
import com.examp.item.*;
import com.examp.order.*;
import com.examp.window.*;

public class App implements ActionListener{

    WindowManager windowManager;
    ClientManager clientManager = new ClientManager();
    ProductManager productManager = new ProductManager();
    OrderManager orderManager = new OrderManager();

    public App(){

        this.windowManager = new WindowManager(this);

    }

    public static void main(String[] args){
       
        new App();

    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == ClientFrame.getAddButton()){

            String[] clientParams = this.windowManager.createClient();
            Client newClient = new Client(clientParams[0], 
                                          clientParams[1], 
                                          clientParams[2], 
                         Float.parseFloat(clientParams[3]));

            JOptionPane.showMessageDialog(this.windowManager, clientManager.addClient(newClient));

            this.refreshClient();

        }else if(e.getSource() == ClientFrame.getEditButton()){

            String[] newParams = this.windowManager.editClient();

            JOptionPane.showMessageDialog(this.windowManager, clientManager.editClient(newParams[0], newParams[1], newParams[2]));

            this.refreshClient();

        }else if(e.getSource() == ClientFrame.getDeleteButton()){

            String clientId = this.windowManager.deleteClient();

            if(clientId.equals("-1")){
                return;
            }

            JOptionPane.showMessageDialog(this.windowManager, clientManager.removeClient(clientId));

            this.refreshClient();
            
        }else if(e.getSource() == ClientFrame.getBackButton()){

            this.windowManager.getClientFrame().setVisible(false);
            this.windowManager.startWindow();

        }else if(e.getSource() == ProductFrame.getAddButton()){

            this.addProduct();
            this.refreshProduct();

        }else if(e.getSource() == ProductFrame.getEditButton()){

            String[] newParams = this.windowManager.editProduct();

            JOptionPane.showMessageDialog(this.windowManager, productManager.editProduct(newParams[0], newParams[1], newParams[2]));

            this.refreshProduct();

        }else if(e.getSource() == ProductFrame.getDeleteButton()){

            this.deleteProduct();
            this.refreshProduct();
            
        }else if(e.getSource() == ProductFrame.getBackButton()){
            
            this.windowManager.getProductFrame().setVisible(false);
            this.windowManager.startWindow();

        }else if(e.getSource() == OrderFrame.getAddButton()){

            


        }else if(e.getSource() == OrderFrame.getDeleteButton()){

            JOptionPane.showMessageDialog(this.windowManager, "teste deletar pedido");

        }else if(e.getSource() == OrderFrame.getBackButton()){
            
            this.windowManager.getOrderFrame().setVisible(false);
            this.windowManager.startWindow();

        }
    }

    public void addProduct(){

        String[] productParams = this.windowManager.createProduct();
        
        if(clientManager.scanList(productParams[4]) == -1){
            
            JOptionPane.showMessageDialog(this.windowManager, "Cliente com este CPF não existe");
            return;
            
        }
        
        Product newProduct = new Product(productParams[0], 
                        Float.parseFloat(productParams[1]), 
                        Integer.parseInt(productParams[2]), 
                                        (productParams[3]),
                                         productParams[4]);

        JOptionPane.showMessageDialog(this.windowManager, productManager.addProduct(newProduct));

        if(productManager.scanList(productParams[3]) != -1){

            clientManager.getTemp().get( clientManager.scanList(productParams[4]) ).
                        addClientProduct(productParams[3]);

        }

    }

    public void deleteProduct(){

        String productId = this.windowManager.deleteProduct();

        if(productId == ""){
            return;
        }

        if(productManager.scanList(productId) != -1){

            //resumindo essa monstruosidade:
            //eu quero pegar um objeto na lista de clientes, então eu uso o get do clientmanager que preciso do index dele
            //pra isso, eu uso o scanlist, que me retorna o index e usa o cpf como parametro
            //o cpf eu pego com o produto que eu quero remover, jj que ele tambem guarda o cpf do vendedor
            //então eu uso o get do productmanager, que precisa do index dele tambem
            //aí eu uso o scanlist do productmanager, que recebe o productid (id do produto a ser removido)
            //aí sim eu pego o cpf guardado nele e removo o produto da lista do cliente
            //pseh bem simples
            clientManager.getTemp().get( 
                clientManager.scanList( 
                    productManager.getTemp().get( 
                        productManager.scanList(productId) ).getSellerCpf() ) ).removeClientProduct(productId);

        }

        JOptionPane.showMessageDialog(this.windowManager, productManager.removeProduct(productId));

    }

    public void addOrder(){

        String[] orderParams = this.windowManager.createOrder();
        Order newOrder = new Order(orderParams[0], 
                                   orderParams[1], 
                   Integer.parseInt(orderParams[2]), 
                   Integer.parseInt(orderParams[3]),
                   Integer.parseInt(orderParams[4]));

        Product productCheck = productManager.getTemp().get(productManager.scanList(orderParams[1]));
        Client clientCheck = clientManager.getTemp().get(clientManager.scanList(orderParams[0]));

        if(clientManager.scanList(orderParams[1]) == -1){

            JOptionPane.showMessageDialog(this.windowManager, "Cliente com este CPF não existe");
            return;

        }else if(productCheck.getQuantity() < Integer.parseInt(orderParams[2])){

            JOptionPane.showMessageDialog(this.windowManager, "Quantidade do produto insuficiente");
            return;

        }else if(clientCheck.getBalance() < Integer.parseInt(orderParams[2]) * productCheck.getPrice()){

            JOptionPane.showMessageDialog(this.windowManager, "Saldo insuficiente");
            return;

        }

        productManager.getTemp().get(productManager.scanList(orderParams[1])).setQuantity(productCheck.getQuantity() - Integer.parseInt(orderParams[2]));
        clientManager.getTemp().get(clientManager.scanList(orderParams[0])).setBalance(
            clientCheck.getBalance() - (productCheck.getPrice() * productCheck.getPrice()));

        JOptionPane.showMessageDialog(this.windowManager, orderManager.addOrder(newOrder));

    }

    public void refreshClient(){

        if(clientManager.getTemp().size() == 0){
            return;
        }

        int rowTotal = this.windowManager.getClientFrame().getTableModel().getRowCount();

        //limpar a tabela
        for(int i = 0; i < rowTotal; i += 1){

            this.windowManager.getClientFrame().getTableModel().removeRow(0);

        }
        
        //colocar todos os itens da tabela
        for(Client check : clientManager.getTemp()){

            String[] checkToString = {check.getName(), 
                                      check.getAdress(), 
                                      check.getCpf(), 
                       Float.toString(check.getBalance()),
                                      check.getClientProductsId()};

            this.windowManager.getClientFrame().getTableModel().addRow(checkToString);
                
        }

    }

    public void refreshProduct(){

        if(productManager.getTemp().size() == 0){
            return;
        }

        int rowTotal = this.windowManager.getProductFrame().getTableModel().getRowCount();

        //limpar a tabela
        for(int i = 0; i < rowTotal; i += 1){

            this.windowManager.getProductFrame().getTableModel().removeRow(0);

        }
        
        //colocar todos os itens da tabela
        for(Product check : productManager.getTemp()){

            String[] checkToString = {check.getName(), 
                       Float.toString(check.getPrice()), 
                     Integer.toString(check.getQuantity()), 
                                      check.getId(),
                                      check.getSellerCpf()};
                       
            this.windowManager.getProductFrame().getTableModel().addRow(checkToString);
                
        }

    }
}
