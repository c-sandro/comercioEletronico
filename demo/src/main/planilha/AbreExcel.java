package com.examp.window;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.examp.client.Client;

public class AbreExcel{
    private static final String fileName = "C:/teste/teste.xls";

    public static void main(String[] args) throws IOException {
        List<Client> listaClients = new ArrayList<Client>(null);

        try{
            FileInputStream arquivo = new FileInputStream(new File(
                                    AbreExcel.fileName));

                    HSSFWorkbook workbook = new HSSFWorkbook(arquivo);

                    HSSFSheet sheetClients = workbook.getSheetAt(0);

                    Iterator<Row> rowIterator = sheetClients.iterator();

                    while (rowIterator.hasNext()) {
                        Row row = rowIterator.next();
                        Iterator<Cell> cellIterator = row.cellIterator();
                        Client client = new Client(fileName, fileName, fileName, 0);
                        listaClients.add(client);
                        while (cellIterator.hasNext()) {
                            Cell cell = cellIterator.next();
                            switch (cell.getColumnIndex()) {
                                case 0:
                                    client.setName(cell.getStringCellValue());
                                    break;
                                case 1: 
                                    client.setAdress(cell.getStringCellValue());
                                    break;
                                case 2:
                                    client.setCpf(cell.getStringCellValue());
                                    break;
                                case 3:
                                    client.setBalance(cell.getStringCellValue());
                                    break;

                            }

                        }
                    }
                    
    }  finally{}
}}