package com.examp; 

import java.io.File; 
import java.io.FileWriter; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.List; 

public class Cadastrar { 

    public void CadastrarClientes(String nome, String endereço, String cpf, String url) { 
        CriarArquivo(url); 

        try { 
            List<String> existentes = LinhaExistentes(url); 
            String linha = "nome: " + nome + "; " + "Endereço: "+ endereço + "; " + "CPF: " + cpf; 
            existentes.add(linha); 

            //adicionar no csv 
            String todasLinhas = UnicaLinha(existentes); 
            FileWriter arquivo = new FileWriter(url); 
            arquivo.write(todasLinhas); 
            arquivo.close(); 

        } catch (Exception error) { 
            System.out.println("Erro ao gerar o arquivo " + url); 
        } 
    } 

    public void CadastrarProdutos(String nome, String valor, String quantidade, String ID, String url) { 
        CriarArquivo(url); 

        try { 
            List<String> existentes = LinhaExistentes(url); 
            String linha = "Nome: " + nome + "; " + "Valor: "+ valor + " reais; " + "Quantidade: " + quantidade + "; " + "ID: " + ID; 
            existentes.add(linha); 

            //adicionar no csv 
            String todasLinhas = UnicaLinha(existentes); 
            FileWriter arquivo = new FileWriter(url); 
            arquivo.write(todasLinhas); 
            arquivo.close(); 

        } catch (Exception error) { 
            System.out.println("Erro ao gerar o arquivo " + url); 
        } 
    } 

    public void CadastrarPedidos(String cpfClient, String IDProduct, String IDOrder, String quantidade,String days,String url) { 
        CriarArquivo(url); 

        try { 
            List<String> existentes = LinhaExistentes(url); 
            String linha = "Cpf do cliente: " + cpfClient + "; " + "ID do produto: "+ IDProduct + " reais; " + "ID do pedido: " + IDOrder + "; "+ "Quantidade:"+ quantidade + "; " + "Dias para entrega: " + days; 
            existentes.add(linha); 

            //adicionar no csv 
            String todasLinhas = UnicaLinha(existentes); 
            FileWriter arquivo = new FileWriter(url); 
            arquivo.write(todasLinhas); 
            arquivo.close(); 

        } catch (Exception error) { 
            System.out.println("Erro ao gerar o arquivo " + url); 
        } 
    } 
    
    public void EditarProdutos(String nome, String valor, String quantidade, String ID, String url) { 
        CriarArquivo(url); 

        try { 
            List<String> existentes = LinhaExistentes(url); 
            String linha = "Nome: " + nome + "; " + "Valor: "+ valor + " reais; " + "Quantidade: " + quantidade + "; " + "ID: " + ID; 
            existentes.add(linha); 

            //adicionar no csv 
            String todasLinhas = UnicaLinha(existentes); 
            FileWriter arquivo = new FileWriter(url); 
            arquivo.write(todasLinhas); 
            arquivo.close(); 

        } catch (Exception error) { 
            System.out.println("Erro ao gerar o arquivo " + url); 
        } 
    } 

    public void EditarClientes(String cpf, String endereço, String nome, String saldo, String url) { 
        CriarArquivo(url); 

        try { 
            List<String> existentes = LinhaExistentes(url); 
            String linha = "CPF: " + cpf + "; " + " Novo endereço: "+ endereço + "; " + "Novo saldo: " + cpf; 
            existentes.add(linha); 

            //adicionar no csv 
            String todasLinhas = UnicaLinha(existentes); 
            FileWriter arquivo = new FileWriter(url); 
            arquivo.write(todasLinhas); 
            arquivo.close(); 

        } catch (Exception error) { 
            System.out.println("Erro ao gerar o arquivo " + url); 
        } 
    } 

    public String UnicaLinha(List<String> existentes) { 

        String unicaLinha = ""; 
        for (String linha : existentes) { 
            unicaLinha += linha + " \n"; 
        } 
        return unicaLinha; 
    } 

    public void CriarArquivo(String url) { 

        try { 
            File arquivo = new File(url); 
            arquivo.createNewFile(); 
        } catch (Exception erro) { 
            System.out.println("Erro ao criar arquivo."); 
        } 
    } 

    public List<String> LinhaExistentes(String url) { 

        List<String> result = new ArrayList<String>(); 

        try { 
            Path path = Paths.get(url); 
            result = Files.readAllLines(path); 
        } catch (Exception erro) { 
            System.out.println("Erro ao ler o arquivo."); 
        } 

        return result; 
    } 
} 

