package product;

import java.util.ArrayList;

public class ProductManager{

    //array temporario ate a gente decidir como guardar os dado
    ArrayList<Product> temp = new ArrayList<>();

    public String addProduct(Product newProduct){

        for(Product productCheck : temp){

            if(productCheck.getId() == newProduct.getId()){

                return "ID ja está sendo utilizado";

            }

        }

        temp.add(newProduct);
        return "Produto adicionado";

    }

    public String editProduct(int inputId, String option, String newVar){

        if(scanList(inputId) == -1){
            return "Produto com ID não encontrado";
        }

        int productId = scanList(inputId);

        switch(option){

            case "NAME":

                temp.get(productId).setName(newVar);
                return "Nome alterado";

            case "PRICE":
            
                temp.get(productId).setPrice(Float.parseFloat(newVar));
                return "Preço alterado";

            case "QUANTITY":

                temp.get(productId).setQuantity(Integer.parseInt(newVar));
                return "Preço alterado";
            
            default:

                return null;
        }


    }

    public String removeProduct(int inputId){

        for(Product productCheck : temp){

            if(productCheck.getId() == inputId){

                temp.remove(productCheck);
                return "Produto removido";

            }

        }

        return "Produto com ID não encontrado";

    }

    private int scanList(int id){

        for(Product productCheck : temp){

            if(productCheck.getId() == id){

                return temp.indexOf(productCheck);

            }

        }

        return -1;

    }
    
}
