package com.examp.client;

import java.util.ArrayList;

public class Client{

    private String name, adress, cpf;
    private float balance;
    //guarda os produtos do cliente
    private ArrayList<String> clientProductsId; 

    public Client(String name, String adress, String cpf, float balance){

        this.name = name;
        this.adress = adress;
        this.cpf = cpf;
        this.balance = balance;
        this.clientProductsId = new ArrayList<>();

    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getAdress(){
        return adress;
    }
    public void setAdress(String adress){
        this.adress = adress;
    }

    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public float getBalance(){
        return balance;
    }
    public void setBalance(float balance){
        this.balance = balance;
    }

    public String getClientProductsId(){

        if(this.clientProductsId.size() == 0){

            return "";

        }

        String toString = "";

        for(String id : this.clientProductsId){

            toString += id + ", ";

        }

        toString = toString.substring(0, toString.length() - 2);

        return toString;
    }
    public void addClientProduct(String newProduct){

        this.clientProductsId.add(newProduct);

    }
    public void removeClientProduct(String newProduct){

        this.clientProductsId.remove(newProduct);

    }
}
