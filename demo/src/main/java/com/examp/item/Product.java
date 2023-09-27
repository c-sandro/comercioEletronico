package com.examp.item;

public class Product{
    
    private String name;
    private float price;
    private int quantity;
    private String id, sellerCpf;

    //id é pra ser único, cada produto tem um diferente

    public Product(String name, float price, int quantity, String id, String sellerCpf){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
        this.sellerCpf = sellerCpf;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public float getPrice(){
        return price;
    }
    public void setPrice(float price){
        this.price = price;
    }

    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getSellerCpf() {
        return sellerCpf;
    }
    public void setSeller(String sellerCpf) {
        this.sellerCpf = sellerCpf;
    }

}
