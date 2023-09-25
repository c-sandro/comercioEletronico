package com.examp;

import java.awt.event.*;
import javax.swing.*;

import com.examp.client.*;
import com.examp.item.*;
import com.examp.order.*;
import com.examp.window.*;

public class App implements ActionListener{

    static Window windowManager;
    static ClientManager clientManager;
    static ProductManager productManager;
    static OrderManager orderManager;

    public App(){

        windowManager = new Window(this);
        clientManager = new ClientManager();
        productManager = new ProductManager();
        orderManager = new OrderManager();

    }

    public static void main(String[] args){
       
        new App();

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==windowManager.addProductButton){

            String[] productParams = windowManager.createProduct();
            Product newProduct = new Product(productParams[0], Float.parseFloat(productParams[0]), Integer.parseInt(productParams[0]), Integer.parseInt(productParams[0]));

            productManager.addProduct(newProduct);

            System.out.println(newProduct.getName() + "\n" + newProduct.getPrice() + "\n" + newProduct.getQuantity() + "\n" + newProduct.getId());


        }else if(e.getSource()==windowManager.editProductButton){
            JOptionPane.showMessageDialog(windowManager, "teste editar produto");
        }else if(e.getSource()==windowManager.deleteProductButton){
            JOptionPane.showMessageDialog(windowManager, "teste deletar produto");
        }else if(e.getSource()==windowManager.backButton){
            
        }else if(e.getSource()==windowManager.addClientButton){
            JOptionPane.showMessageDialog(windowManager, "teste adicionar cliente");
        }else if(e.getSource()==windowManager.editClientButton){
            JOptionPane.showMessageDialog(windowManager, "teste editar cliente");
        }else if(e.getSource()==windowManager.deleteClientButton){
            JOptionPane.showMessageDialog(windowManager, "teste deletar cliente");
        }else if(e.getSource()==windowManager.addOrderButton){
            JOptionPane.showMessageDialog(windowManager, "teste adicionar pedido");
        }else if(e.getSource()==windowManager.editOrderButton){
            JOptionPane.showMessageDialog(windowManager, "teste editar pedido");
            
        }else if(e.getSource()==windowManager.deleteOrderButton){
            JOptionPane.showMessageDialog(windowManager, "teste deletar pedido");
        }
    }

}
