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
        if(e.getSource() == ProductFrame.getAddButton()){

            String[] productParams = windowManager.createProduct();
            Product newProduct = new Product(productParams[0], 
                            Float.parseFloat(productParams[1]), 
                            Integer.parseInt(productParams[2]), 
                            Integer.parseInt(productParams[3]));

            JOptionPane.showMessageDialog(windowManager, productManager.addProduct(newProduct));

            System.out.println(newProduct.getName() + "\n" + newProduct.getPrice() + "\n" + newProduct.getQuantity() + "\n" + newProduct.getId());

        }else if(e.getSource() == ProductFrame.getEditButton()){

            String[] newParams = windowManager.editProduct();
            JOptionPane.showMessageDialog(windowManager, 
            productManager.editProduct(Integer.parseInt(newParams[0]), 
                                                        newParams[1], 
                                                        newParams[2]));

        }else if(e.getSource() == ProductFrame.getDeleteButton()){

            int productId = windowManager.deleteProduct();

            if(productId != -1){
                JOptionPane.showMessageDialog(windowManager, productManager.removeProduct(productId));
            }

        }else if(e.getSource() == ProductFrame.getBackButton()){
            
            windowManager.getProductFrame().dispose();
            new Window(this);

        }/*else if(e.getSource() == windowManager.addClientButton){
            JOptionPane.showMessageDialog(windowManager, "teste adicionar cliente");
        }else if(e.getSource() == windowManager.editClientButton){
            JOptionPane.showMessageDialog(windowManager, "teste editar cliente");
        }else if(e.getSource() == windowManager.deleteClientButton){
            JOptionPane.showMessageDialog(windowManager, "teste deletar cliente");
        }else if(e.getSource() == windowManager.addOrderButton){
            JOptionPane.showMessageDialog(windowManager, "teste adicionar pedido");
        }else if(e.getSource() == windowManager.editOrderButton){
            JOptionPane.showMessageDialog(windowManager, "teste editar pedido");
            
        }else if(e.getSource() == windowManager.deleteOrderButton){
            JOptionPane.showMessageDialog(windowManager, "teste deletar pedido");
        }*/
    }

}
