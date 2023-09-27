package com.examp.order;

import java.util.ArrayList;

public class OrderManager{

    private ArrayList<Order> temp = new ArrayList<>();

    public String addOrder(Order newOrder){

        for(Order orderCheck : temp){

            if(orderCheck.getId() == newOrder.getId()){

                return "Ordem com este ID já existe";

            }

        }

        temp.add(newOrder);
        return "Ordem adicionado";

    }

    public String removeProduct(int inputId){

        for(Order productCheck : temp){

            if(productCheck.getId() == inputId){

                temp.remove(productCheck);
                return "Ordem removido";

            }

        }

        return "Ordem com este id não existe";

    }

    public ArrayList<Order> getTemp() {
        return temp;
    }
    
}
