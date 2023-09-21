package client;

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

        Client tempProduct = scanList(inputCpf);

        switch(option){

            case "NAME":

                tempProduct.setName(newVar);
                temp.add(tempProduct);
                return "Nome alterado";

            case "ADRESS":
            
                tempProduct.setAdress(newVar);
                temp.add(tempProduct);
                return "Endereço alterado";

            case "BALANCE":

                tempProduct.setBalance(Integer.parseInt(newVar));
                temp.add(tempProduct);
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

    private Client scanList(int cpf){

        for(Client productCheck : temp){

            if(productCheck.getCpf() == cpf){

                temp.remove(productCheck);
                return productCheck;

            }

        }

        return null;

    }
    
    
}
