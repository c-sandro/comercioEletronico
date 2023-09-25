package com.examp.client;

import java.util.ArrayList;

public class ClientManager{

    ArrayList<Client> temp = new ArrayList<>();

    public String addClient(Client newClient){

        for(Client clientCheck : temp){

            if(clientCheck.getCpf() == newClient.getCpf()){

                return "Ja existe um cliente com este CPF";

            }

        }

        temp.add(newClient);
        return "Cliente adicionado";

    }

    public String editClient(int inputCpf, String option, String newVar){

        if(scanList(inputCpf) == -1){
            return "CPF não existe";
        }

        int clientId = scanList(inputCpf);

        switch(option){

            case "NAME":

                temp.get(clientId).setName(newVar);
                return "Nome alterado";

            case "ADRESS":
            
                temp.get(clientId).setAdress(newVar);
                return "Endereço alterado";

            case "BALANCE":

                temp.get(clientId).setBalance(Integer.parseInt(newVar));
                return "Saldo alterado";
            
            default:

                return null;
        }        

    }

    public String removeProduct(int inputCpf){

        for(Client productCheck : temp){

            if(productCheck.getCpf() == inputCpf){

                temp.remove(productCheck);
                return "Produto removido";

            }

        }

        return "Produto com este id não encontrado";

    }

    private int scanList(int cpf){

        for(Client productCheck : temp){

            if(productCheck.getCpf() == cpf){

                return temp.indexOf(productCheck);

            }

        }

        return -1;

    }
    
    
}
