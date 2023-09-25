package item;

public class Product{
    
    private String name;
    private float price;
    private int quantity, id;

    //id é pra ser único, cada produto tem um diferente

    public Product(String name, float price, int quantity, int id) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
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

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

}
