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

            this.refreshClient(false);

        }else if(e.getSource() == ClientFrame.getEditButton()){

            String[] newParams = this.windowManager.editClient();

            JOptionPane.showMessageDialog(this.windowManager, clientManager.editClient(newParams[0], newParams[1], newParams[2]));

            this.refreshClient(false);

        }else if(e.getSource() == ClientFrame.getDeleteButton()){

            String clientId = this.windowManager.deleteClient();

            if(clientId.equals("-1")){
                return;
            }

            JOptionPane.showMessageDialog(this.windowManager, clientManager.removeClient(clientId));

            this.refreshClient(true);
            
        }else if(e.getSource() == ClientFrame.getBackButton()){
            
            this.windowManager.getClientFrame().setVisible(false);
            this.windowManager.startWindow();

        }else if(e.getSource() == ProductFrame.getAddButton()){

            this.addProduct();
            this.refreshProduct(false);

        }else if(e.getSource() == ProductFrame.getEditButton()){

            String[] newParams = this.windowManager.editProduct();

            JOptionPane.showMessageDialog(this.windowManager, productManager.editProduct(newParams[0], newParams[1], newParams[2]));

            this.refreshProduct(false);

        }else if(e.getSource() == ProductFrame.getDeleteButton()){

            this.deleteProduct();
            this.refreshProduct(true);
            
        }else if(e.getSource() == ProductFrame.getBackButton()){
            
            this.windowManager.getProductFrame().setVisible(false);
            this.windowManager.startWindow();

        }else if(e.getSource() == OrderFrame.getAddButton()){

            this.addOrder();            
            this.refreshOrder(false);

        }else if(e.getSource() == OrderFrame.getDeleteButton()){

            this.deleteOrder();
            this.refreshOrder(true);

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

        if(productManager.addProduct(newProduct)){

            JOptionPane.showMessageDialog(this.windowManager, "Produto adicionado");
            clientManager.getTemp().get( clientManager.scanList(productParams[4]) ).
                        addClientProduct(productParams[3]);

        }else{

            JOptionPane.showMessageDialog(this.windowManager, "Produto com este ID já existe");

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
                                   orderParams[2], 
                  Integer.parseInt(orderParams[3]),
                  Integer.parseInt(orderParams[4]));

        Product productCheck = productManager.getTemp().get(productManager.scanList(orderParams[1]));
        Client clientCheck = clientManager.getTemp().get(clientManager.scanList(orderParams[0]));

        if(clientManager.scanList(orderParams[0]) == -1){

            JOptionPane.showMessageDialog(this.windowManager, "Cliente com este CPF não existe");
            return;

        }else if(productManager.scanList(orderParams[1]) == -1){

            JOptionPane.showMessageDialog(this.windowManager, "Produto com este ID não existe");
            return;

        }else if(productCheck.getQuantity() < Integer.parseInt(orderParams[3])){

            JOptionPane.showMessageDialog(this.windowManager, "Quantidade do produto insuficiente");
            return;

        }else if(clientCheck.getBalance() < Integer.parseInt(orderParams[3]) * productCheck.getPrice()){

            JOptionPane.showMessageDialog(this.windowManager, "Saldo insuficiente");
            return;

        }

        if(orderManager.addOrder(newOrder)){

            productManager.getTemp().get(productManager.scanList(orderParams[1])).setQuantity(productCheck.getQuantity() - Integer.parseInt(orderParams[3]));
            clientManager.getTemp().get(clientManager.scanList(orderParams[0])).setBalance(
                clientCheck.getBalance() - (productCheck.getPrice() * Integer.parseInt(orderParams[3])));

            JOptionPane.showMessageDialog(this.windowManager, "Pedido adicionado");

        }else{

            JOptionPane.showMessageDialog(this.windowManager, "Pedido com este ID já existe");

        }

    }

    public void deleteOrder(){

        String orderId = this.windowManager.deleteOrder();

        if(orderId.equals("")){
            return;
        }

        JOptionPane.showMessageDialog(this.windowManager, orderManager.removeOrder(orderId));
    }

    public void refreshClient(boolean isDeleting){

        if(clientManager.getTemp().size() == 0 && !isDeleting){
            return;
        }

        int rowTotal = this.windowManager.getClientFrame().getTableModel().getRowCount();

        //limpar a tabela
        for(int i = 0; i < rowTotal; i += 1){

            this.windowManager.getClientFrame().getTableModel().removeRow(0);

        }
        
        //colocar todos os itens da tabela
        for(Client check : clientManager.getTemp()){

            //formatação do cpf pro padrão 123.456.789-12
            String cpf = check.getCpf().substring(0, 3) + "." + check.getCpf().substring(3, 6) + "." + check.getCpf().substring(6, 9) + "-" + check.getCpf().substring(9);

            String[] checkToString = {check.getName(), 
                                      check.getAdress(), 
                                      cpf,
                "R$" + Float.toString(check.getBalance()),
                                      check.getClientProductsId()};

            this.windowManager.getClientFrame().getTableModel().addRow(checkToString);
                
        }

    }

    public void refreshProduct(boolean isDeleting){

        if(productManager.getTemp().size() == 0 && !isDeleting){
            return;
        }

        int rowTotal = this.windowManager.getProductFrame().getTableModel().getRowCount();

        //limpar a tabela
        for(int i = 0; i < rowTotal; i += 1){

            this.windowManager.getProductFrame().getTableModel().removeRow(0);

        }
        
        //colocar todos os itens da tabela
        for(Product check : productManager.getTemp()){

            String cpf = check.getSellerCpf().substring(0, 3) + "." + check.getSellerCpf().substring(3, 6) + "." + check.getSellerCpf().substring(6, 9) + "-" + check.getSellerCpf().substring(9);

            String[] checkToString = {check.getName(), 
                "R$" + Float.toString(check.getPrice()), 
                     Integer.toString(check.getQuantity()), 
                                      check.getId(),
                                      cpf};
                       
            this.windowManager.getProductFrame().getTableModel().addRow(checkToString);
                
        }

    }

    public void refreshOrder(boolean isDeleting){

        if(orderManager.getTemp().size() == 0 && !isDeleting){
            return;
        }

        int rowTotal = this.windowManager.getOrderFrame().getTableModel().getRowCount();

        //limpar a tabela
        for(int i = 0; i < rowTotal; i += 1){

            this.windowManager.getOrderFrame().getTableModel().removeRow(0);

        }
        
        //colocar todos os itens da tabela
        for(Order check : orderManager.getTemp()){

            String cpf = check.getClientCpf().substring(0, 3) + "." + check.getClientCpf().substring(3, 6) + "." + check.getClientCpf().substring(6, 9) + "-" + check.getClientCpf().substring(9);

            String[] checkToString = {cpf, 
                                      check.getProductId(), 
                                      check.getId(), 
                     Integer.toString(check.getQuantity()),
                     Integer.toString(check.getShipping()) + " dias"};
                       
            this.windowManager.getOrderFrame().getTableModel().addRow(checkToString);
                
        }

    }
}
