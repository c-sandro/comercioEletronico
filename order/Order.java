package order;

import client.*;
import product.*;

public class Order{

    private Client client;
    private Product product;
    //tempo de entrega em dias
    private int id, shipping;
    
    public Order(Client client, Product product, int id, int shipping) {
        this.client = client;
        this.product = product;
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
