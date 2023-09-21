import java.util.ArrayList;

public class ProductManager{

    //aqui a gente coloca as funções que mexe com o produto
    //tipo adicionar produto, remover etc

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

    public String removeProduct(int inputId){

        for(Product productCheck : temp){

            if(productCheck.getId() == inputId){

                temp.remove(productCheck);
                return "Produto removido";

            }

        }

        return "Produto com este id não encontrado";

    }
    
}
