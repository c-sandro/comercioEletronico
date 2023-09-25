package com.examp.order;

import com.examp.client.*;
import com.examp.item.*;

public class Order{

    private Client client;
    private Product product;
    //id unico que nem os produtos
    //tempo de entrega em dias
    private int quantity, id, shipping;
    
    public Order(Client client, Product product, int quantity, int id, int shipping) {
        this.client = client;
        this.product = product;
        this.quantity = quantity;
        this.id = id;
        this.shipping = shipping;
    }

    public Client getClient(){
        return client;
    }
    public void setClient(Client client){
        this.client = client;
    }

    public Product getProduct(){
        return product;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getShipping(){
        return shipping;
    }
    public void setShipping(int shipping){
        this.shipping = shipping;
    }
    
}
