package com.examp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Cadastrar {

    public void CadastrarNomes(String nome, String sobrenome, String arquivo) {
        try {
            FileWriter fileWriter = new FileWriter(arquivo, true); // Abre o arquivo em modo de escrita, "true" para adicionar ao final
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Escreve os nomes no arquivo
            printWriter.println(nome + "," + sobrenome);

            printWriter.close(); // Fecha o arquivo após a escrita
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao cadastrar nomes no arquivo.");
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