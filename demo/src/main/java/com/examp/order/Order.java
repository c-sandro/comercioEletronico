package com.examp.order;

public class Order{

    private String clientCpf, productId;
    //tempo de entrega em dias
    private int quantity, id, shipping;
    
    public Order(String clientCpf, String productId, int quantity, int id, int shipping) {
        this.clientCpf = clientCpf;
        this.productId = productId;
        this.quantity = quantity;
        this.id = id;
        this.shipping = shipping;
    }

    public String getClientCpf(){
        return clientCpf;
    }
    public void setClient(String clientCpf){
        this.clientCpf = clientCpf;
    }

    public String getProductId(){
        return productId;
    }
    public void setProduct(String productId){
        this.productId = productId;
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
