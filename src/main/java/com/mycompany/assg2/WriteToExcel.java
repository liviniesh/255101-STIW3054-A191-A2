/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assg2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author USER
 */
public class WriteToExcel {

    static File temp1;

    private static XSSFWorkbook book1 = new XSSFWorkbook();
    private static XSSFSheet sheet = book1.createSheet("Zhamri Followers' Info");

    public static void main(String[] args) throws IOException {
        temp1 = File.createTempFile("Assg2_", ".xlsx");
        String FILE_NAME = temp1.toString();
        Object[][] data = App.List;
        int row = 0;
        System.out.println();
        System.out.println("Creating...");
        System.out.println("");
        System.out.println("Excel Filepath: " + temp1.getAbsolutePath());
        getRowNum(sheet, data, row);
        excel(FILE_NAME, book1);
    }

    private static void excel(String file, XSSFWorkbook book) {
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            book.write(outputStream);
            book.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found or currently open");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getRowNum(XSSFSheet sheet, Object[][] data, int row) {
        sheet1(sheet, data, row);
    }

    private static void sheet1(XSSFSheet sheet, Object[][] data, int row) {
        for (Object[] datatype : data) {
            Row row1 = sheet.createRow(row++);
            int col = 0;
            for (Object field : datatype) {
                Cell cell1 = row1.createCell(col++);
                sheet.autoSizeColumn(row);
                if (field instanceof String) {
                    cell1.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell1.setCellValue((Integer) field);
                }
            }
        }

        for (int x = 0; x < sheet.getRow(0).getPhysicalNumberOfCells(); x++) {
            sheet.autoSizeColumn(x);
        }
    }

}
