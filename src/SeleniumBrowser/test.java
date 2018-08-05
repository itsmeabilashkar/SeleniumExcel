package SeleniumBrowser;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Lenovo on 7/28/2018.
 */
@Test()
public class test {

    public static void main(String args[]) throws Exception {
        File src= new File("testData\\testData.xlsx");
       // File src= new File("D:\\\\New folder\\testData.xlsx");
        //FileReader fr=new FileReader("test-data/NormalArticles.txt");

        FileInputStream fileInputStream= new FileInputStream(src);
        XSSFWorkbook wb= new XSSFWorkbook(fileInputStream);
        XSSFSheet config= wb.getSheetAt(0);
        XSSFSheet data= wb.getSheetAt(1);
        String path=config.getRow(1).getCell(0).getStringCellValue();
        String browser = config.getRow(1).getCell(1).getStringCellValue();
        System.out.println(path);
        System.out.println(browser);


        if(browser.equals("FireFox")){
            System.setProperty("webdriver.gecko.driver", path);

            WebDriver driver = new FirefoxDriver();
            System.out.println("Hello Google...");
            driver.get("http://google.com");
            driver.quit();
            FileOutputStream fr=new FileOutputStream("test-data/FragArticles.xlsx");
            XSSFWorkbook
        }
else{
            System.out.println("Normal path");
        }

    }

    }
