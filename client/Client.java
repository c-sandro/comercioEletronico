package client;

public class Client{

    private String name, adress;
    private int cpf;
    private float balance;

    public Client(String name, String adress, int cpf, float balance){

        this.name = name;
        this.adress = adress;
        this.cpf = cpf;
        this.balance = balance;
        
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

    public int getCpf(){
        return cpf;
    }
    public void setCpf(int cpf){
        this.cpf = cpf;
    }

    public float getBalance(){
        return balance;
    }
    public void setBalance(float balance){
        this.balance = balance;
    }

}
