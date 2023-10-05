package com.examp; 

import java.io.File; 
import java.io.FileWriter; 
import java.util.ArrayList;

public class Cadastrar{

    public void exportClient(String name, String adress, String cpf, String url) { 
        createArchive(url); 

        try{
            FileWriter archive = new FileWriter(url); 

            archive.write(name + "\n"); 
            archive.write(adress + "\n"); 
            archive.write(cpf + "\n"); 
            archive.close(); 

        }catch(Exception e){
            System.out.println("Erro ao gerar o arquivo " + url); 
        } 
    } 

    public void exportProduct(String name, String value, String quantity, String ID, String url){ 
        createArchive(url); 

        try{
            FileWriter archive = new FileWriter(url); 

            archive.write(name + "\n"); 
            archive.write(value + "\n"); 
            archive.write(quantity + "\n"); 
            archive.write(ID + "\n"); 
            archive.close(); 

        }catch(Exception e){
            System.out.println("Erro ao gerar o arquivo " + url); 
        } 
    } 

    public void exportOrder(String cpfClient, String IDProduct, String IDOrder, String quantity, String days, String url){
        createArchive(url); 

        try{
            FileWriter archive = new FileWriter(url); 

            archive.write(cpfClient + "\n"); 
            archive.write(IDProduct + "\n"); 
            archive.write(IDOrder + "\n"); 
            archive.write(quantity + "\n"); 
            archive.write(days + "\n"); 
            archive.close(); 

        }catch(Exception e){
            System.out.println("Erro ao gerar o arquivo " + url); 
        }
    } 


    public void createArchive(String url){

        try{
            File archive = new File(url); 
            archive.createNewFile(); 
        }catch(Exception e){
            System.out.println("Erro ao criar arquivo."); 
        } 
    } 


} 

