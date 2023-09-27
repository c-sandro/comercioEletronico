package com.examp.item;

import java.util.ArrayList;

public class ProductManager{

    //array temporario ate a gente decidir como guardar os dado
    private ArrayList<Product> temp = new ArrayList<>();

    public boolean addProduct(Product newProduct){

        for(Product productCheck : temp){

            if(productCheck.getId() == newProduct.getId()){

                return false;

            }

        }

        temp.add(newProduct);
        return true;

    }

    public String editProduct(String inputId, String option, String newVar){

        if(scanList(inputId) == -1){
            return "Produto com este ID não existe";
        }

        int productId = scanList(inputId);

        switch(option){
            case "NAME":

                temp.get(productId).setName(newVar);
            
            break;
            case "PRICE":
            
                temp.get(productId).setPrice(Float.parseFloat(newVar));

            break;
            case "QUANTITY":

                temp.get(productId).setQuantity(Integer.parseInt(newVar));
            
            break;
        }

        return "Valor alterado";

    }

    public String removeProduct(String inputId){

        for(Product productCheck : temp){

            if(productCheck.getId().equals(inputId)){

                temp.remove(productCheck);
                return "Produto removido";

            }

        }

        return "Produto com este ID não existe";

    }

    public int scanList(String productId){

        for(Product productCheck : temp){

            if(productCheck.getId().equals(productId)){

                return temp.indexOf(productCheck);

            }

        }

        return -1;

    }

    public ArrayList<Product> getTemp() {
        return temp;
    }
    
}
