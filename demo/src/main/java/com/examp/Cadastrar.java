package com.examp; 

import java.io.File; 
import java.io.FileWriter; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List; 

public class Cadastrar{

    public void AddClient(String name, String adress, String cpf, String url) { 
        createArchive(url); 

        try { 
            List<String> existingLine = existingLine(url); 
            String line = "nome: " + name + "; " + "Endereço: "+ adress + "; " + "CPF: " + cpf; 
            existingLine.add(line); 

            //adicionar no csv 
            String allLines = oneLine(existingLine); 
            FileWriter archive = new FileWriter(url); 
            archive.write(allLines); 
            archive.close(); 

        } catch (Exception error) { 
            System.out.println("Erro ao gerar o arquivo " + url); 
        } 
    } 

    public void addProduct(String name, String value, String quantity, String ID, String url){ 
        createArchive(url); 

        try{ 
            List<String> existingLine = existingLine(url); 
            String line = "Nome: " + name + "; " + "Valor: "+ value + " reais; " + "Quantidade: " + quantity + "; " + "ID: " + ID; 
            existingLine.add(line); 

            //adicionar no csv 
            String allLines = oneLine(existingLine); 
            FileWriter archive = new FileWriter(url); 
            archive.write(allLines); 
            archive.close(); 

        } catch (Exception error) { 
            System.out.println("Erro ao gerar o arquivo " + url); 
        } 
    } 

    public void addOrder(String cpfClient, String IDProduct, String IDOrder, String quantity, String days, String url){
        createArchive(url); 

        try { 
            List<String> existingLine = existingLine(url); 
            String line = "Cpf do cliente: " + cpfClient + "; " + "ID do produto: "+ IDProduct + " reais; " + "ID do pedido: " + IDOrder + "; "+ "Quantidade:"+ quantity + "; " + "Dias para entrega: " + days; 
            existingLine.add(line); 

            //adicionar no csv 
            String allLines = oneLine(existingLine); 
            FileWriter archive = new FileWriter(url); 
            archive.write(allLines); 
            archive.close(); 

        } catch (Exception error) { 
            System.out.println("Erro ao gerar o arquivo " + url); 
        } 
    } 
    
    public void editProduct(String name, String price, String quantity, String ID, String url){
        createArchive(url); 

        try{
            List<String> existingLine = existingLine(url); 
            String linha = "Nome: " + name + "; " + "Valor: R$" + price + " Quantidade: " + quantity + "; " + "ID: " + ID; 
            existingLine.add(linha); 

            //adicionar no csv 
            String todasLinhas = oneLine(existingLine); 
            FileWriter arquivo = new FileWriter(url); 
            arquivo.write(todasLinhas); 
            arquivo.close(); 

        }catch(Exception error){
            System.out.println("Erro ao gerar o arquivo " + url); 
        } 
    } 

    public void editClient(String cpf, String adress, String name, String balance, String url){
        createArchive(url); 

        try{
            List<String> existingLine = existingLine(url); 
            String linha = "CPF: " + cpf + "; " + " Novo endereço: "+ adress + "; " + "Novo saldo: " + balance; 
            existingLine.add(linha); 

            //adicionar no csv 
            String allLines = oneLine(existingLine); 
            FileWriter archive = new FileWriter(url); 
            archive.write(allLines); 
            archive.close(); 

        } catch (Exception error) { 
            System.out.println("Erro ao gerar o arquivo " + url); 
        } 
    } 

    public String oneLine(List<String> existingLine){

        String line = ""; 
        for (String lineCheck : existingLine){
            line += lineCheck + " \n"; 
        } 
        return line; 
    } 

    public void createArchive(String url){

        try{
            File archive = new File(url); 
            archive.createNewFile(); 
        }catch(Exception e){
            System.out.println("Erro ao criar arquivo."); 
        } 
    } 

    public List<String> existingLine(String url){

        List<String> result = new ArrayList<String>(); 

        try{
            Path path = Paths.get(url); 
            result = Files.readAllLines(path);
        }catch(Exception e){
            System.out.println("Erro ao ler o arquivo."); 
        }

        return result; 
    } 
} 

