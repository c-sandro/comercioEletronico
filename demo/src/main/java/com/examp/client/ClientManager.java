package com.examp.client;

import java.util.ArrayList;

public class ClientManager{

    private ArrayList<Client> temp = new ArrayList<>();

    public String addClient(Client newClient){

        for(Client clientCheck : temp){

            if(clientCheck.getCpf().equals(newClient.getCpf())){

                return "Cliente com este CPF já existe";
                
            }

        }

        temp.add(newClient);
        return "Cliente adicionado";

    }

    public String editClient(String inputCpf, String option, String newVar){

        int clientId = scanList(inputCpf);

        if(clientId == -1){
            return "Cliente com este CPF não existe";
        }

        switch(option){
            case "NAME":

                temp.get(clientId).setName(newVar);

            break;
            case "ADRESS":
            
                temp.get(clientId).setAdress(newVar);

            break;
            case "BALANCE":

                temp.get(clientId).setBalance(Integer.parseInt(newVar));
            
            break;
        }

        return "Valor alterado";

    }

    public String removeClient(String inputCpf){

        for(Client productCheck : temp){

            if(productCheck.getCpf().equals(inputCpf)){

                temp.remove(productCheck);
                return "Cliente removido";

            }

        }

        return "Cliente com este CPF não existe";

    }

    public int scanList(String cpf){

        for(Client productCheck : temp){

            if(productCheck.getCpf().equals(cpf)){

                return temp.indexOf(productCheck);

            }

        }

        return -1;

    }

    public ArrayList<Client> getTemp() {
        return temp;
    }
    
}
