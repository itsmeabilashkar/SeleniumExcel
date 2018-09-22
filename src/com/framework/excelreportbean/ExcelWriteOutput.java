package com.framework.excelreportbean;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by Lenovo on 8/5/2018.
 */
public class ExcelWriteOutput {


    //public static List<ExcelReportBean> excelReport=new ArrayList<>();

    public static XSSFCellStyle headerStyle,Regstyle,robodyStyle,testcaseStyle,transnumberstyle,transdatestyle;

    public static enum ExcelHeaders{
        UserName("UserName"),
        Password("Password"),
        Message("Message")
        ;
        String name;
        ExcelHeaders(String name){
            this.name=name;
        }
        public String getName(){return this.name;}
    }



    public static void CreateDataDetailsToExcel(List<ExcelReportBean> excelReportBean, String fileName)throws FileNotFoundException, IOException {
        try{

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));

            XSSFWorkbook workbook = new XSSFWorkbook();


            XSSFSheet sheet = workbook.createSheet("UserDetails");
            int rowCounter=0;
            Row row = sheet.createRow(rowCounter);
            for(int x=0;x<ExcelHeaders.values().length;x++){
                Cell cell = row.createCell(ExcelHeaders.values()[x].ordinal());
                cell.setCellValue(ExcelHeaders.values()[x].getName());
                cell.setCellStyle(headerStyle);
            }

            for(ExcelReportBean excelReport : excelReportBean){
                row = sheet.createRow(++rowCounter);
                Cell cell = row.createCell(ExcelHeaders.UserName.ordinal());
                cell.setCellValue(excelReport.getUserName());
                cell.setCellStyle(robodyStyle);


                cell = row.createCell(ExcelHeaders.Password.ordinal());
                cell.setCellValue(excelReport.getPassword());
                cell.setCellStyle(testcaseStyle);

            }
       /* try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
 	       workbook.write(outputStream);*/

            try  {
                //  workbook.write(outputStream);
               // FileOutputStream outputStream = new FileOutputStream("New.xlsx");
                FileOutputStream outputStream = new FileOutputStream("testOutput"+File.separator+fileName + ".xlsx");
                workbook.write(outputStream);
                workbook.close();
                    System.out.println("Output file new.xlsx created");
            }
            catch(Exception e){

                throw new RuntimeException(e);
            }

        }catch(Exception e){

            throw new RuntimeException(e);
        }
    }
}
