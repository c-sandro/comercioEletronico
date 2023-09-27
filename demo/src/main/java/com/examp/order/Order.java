package com.examp.order;

public class Order{

    private String clientCpf, productId, id;
    //tempo de entrega em dias
    private int quantity, shipping;
    
    public Order(String clientCpf, String productId, String id, int quantity, int shipping) {
        this.clientCpf = clientCpf;
        this.productId = productId;
        this.id = id;
        this.quantity = quantity;
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
    
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getShipping(){
        return shipping;
    }
    public void setShipping(int shipping){
        this.shipping = shipping;
    }
    
}
