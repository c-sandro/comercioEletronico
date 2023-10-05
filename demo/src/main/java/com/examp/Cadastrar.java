package com.examp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Cadastrar {

    public void CadastarProduto(String cliente, String produto, String order, String url) {
        try {

            Path path = Paths.get(url);
            if (!Files.exists(path)) {
                
                Files.createFile(path);
            }

            List<String> existentes = LinhaExistentes(url);

    
            String linha = cliente + ";" + produto + ";" + order;
            existentes.add(linha);

            FileWriter arquivo = new FileWriter(url);
            try (BufferedWriter writer = new BufferedWriter(arquivo)) {
                for (String existente : existentes) {
                    writer.write(existente);
                    writer.newLine();
                }
            }
            System.out.println("Produto cadastrado com sucesso!");

        } catch (IOException error) {
            System.err.println("Erro ao gerar o arquivo: " + error.getMessage());
        }
    }

    public List<String> LinhaExistentes(String url) {
        List<String> result = new ArrayList<>();

        try {
            Path path = Paths.get(url);
            result = Files.readAllLines(path);
        } catch (IOException erro) {
            System.err.println("Erro ao ler arquivo: " + erro.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        Cadastrar cadastrar = new Cadastrar();
        String url = "files/teste.csv";

        cadastrar.CadastarProduto("julia", "café", "8990101", url);
    }
}
