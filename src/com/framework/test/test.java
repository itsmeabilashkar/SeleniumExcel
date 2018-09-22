package com.framework.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.baseclass.BaseClass;
import com.framework.excelreportbean.ExcelReportBean;
import com.framework.excelreportbean.ExcelWriteOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Lenovo on 7/28/2018.
 */

public class test {
    public WebDriver driver;
    public String userName,pwd;
    int value;
    
    @BeforeTest
    public void before() throws Exception {
        File src = new File("testData\\testData.xlsx");
        // File src= new File("D:\\\\New folder\\testData.xlsx");
        //FileReader fr=new FileReader("test-data/NormalArticles.txt");

        FileInputStream fileInputStream = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
        XSSFSheet config = wb.getSheetAt(0);
        XSSFSheet data = wb.getSheetAt(1);
        
        String filepath=  "./driver/chromedriver.exe";
        String path = config.getRow(1).getCell(0).getStringCellValue();
        String browser = config.getRow(1).getCell(1).getStringCellValue();
        System.out.println(path);
        System.out.println(browser);
        userName = data.getRow(1).getCell(0).getStringCellValue();
        value =(int) data.getRow(1).getCell(1).getNumericCellValue();
        pwd = data.getRow(1).getCell(2).getStringCellValue();

        if (browser.equals("FireFox")) {
            System.setProperty("webdriver.gecko.driver", path);

            driver = new FirefoxDriver();
            System.out.println("Hello Google...");
            driver.get("http://google.com");
            BaseClass.excelReport.add(new ExcelReportBean(userName,pwd));

            driver.quit();

            new ExcelWriteOutput().CreateDataDetailsToExcel(BaseClass.excelReport,"new");

        } else if(browser.equals("chrome"))
        {
        	System.setProperty("webdriver.chrome.driver",filepath );
        	driver= new ChromeDriver();
        	
        	  System.out.println("Hello Google...");
              driver.get("http://gmail.com");
              System.out.println(userName);
              System.out.println(pwd);
              BaseClass.excelReport.add(new ExcelReportBean(userName,pwd));
          
        	
        }
        else {
        	System.out.println("Normal path");
        }

    }
    @Test
    public void test() throws InterruptedException  {
    	 
    	      // Enter Username on the element found by above desc.

          driver.findElement(By.xpath("//input[@type='email']")).sendKeys(userName);

          driver.findElement(By.xpath("//*[@id='identifierNext']")).click();
     
          // Find the element that's ID attribute is 'pwd' (Password)
   
          synchronized (driver)
          {
        	  driver.wait(5000);
          }
         
	
     
          driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
          // Now submit the form. WebDriver will find the form for us from the element
          driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
     
          synchronized (driver)
          {
        	  driver.wait(8000);
          }
         
          
          driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[3]/div[1]/a/span")).click();
         
     
    
     
          // Print a Log In message to the screen
     
          System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
     
          // Find the element that's ID attribute is 'account_logout' (Log Out)
          ChromeOptions options = new ChromeOptions ();

          //options.addExtensions (new File(“/path/to/extension.crx”));

          DesiredCapabilities capabilities = new DesiredCapabilities ();

          capabilities.setCapability(ChromeOptions.CAPABILITY, options);
     
      }
    @AfterMethod
    
    public void afterMethod() {
   
  	  // Close the driver
   
      // driver.quit();
   
    }
}
