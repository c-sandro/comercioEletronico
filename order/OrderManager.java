package order;

import java.util.ArrayList;

public class OrderManager{

    ArrayList<Order> temp = new ArrayList<>();

    public String addOrder(Order newOrder){

        for(Order orderCheck : temp){

            if(orderCheck.getId() == newOrder.getId()){

                return "Ja existe um com este ID";

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

        return "Ordem com este id não encontrado";

    }
    
}
