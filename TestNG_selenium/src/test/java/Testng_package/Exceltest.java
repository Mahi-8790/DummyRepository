package Testng_package;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.collections4.Get;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class Exceltest {
  @Test(dataProvider = "exceldata")
  public void testLogin(String username1, String password1) {
	  System.out.println("username="+username1 + " | Password "+password1); ;
       WebDriver driver=new ChromeDriver();
       driver.get("http://zero.webappsecurity.com/login.html");
       WebElement user=driver.findElement(By.id("user_login"));
       user.sendKeys(username1);
       WebElement pass=driver.findElement(By.id("user_password"));
       pass.sendKeys(password1);
       driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/input")).click();
       
  }

  @DataProvider (name ="excelData")
  
  
  public Object[][] exceldp() throws  IOException {
	  String excelPath="C:\\javaXl\\Excelsheet1.xlsx\"";
	  String sheetname="Sheet1";
	  
	  FileInputStream fis=new FileInputStream(excelPath);
	  Workbook workbook=WorkbookFactory.create(fis);
	  Sheet sheet=workbook.getSheet(sheetname);
	  
	  int rows=sheet.getPhysicalNumberOfRows();
	  int col=sheet.getRow(0).getLastCellNum();
	  
	  Object[][] data=new Object[rows-1][col];
	  for(int i=0;i<rows;i++) {
		  Row row=sheet.getRow(i);
		  for(int j=0; j<col; j++) {
			  Cell cell=row.getCell(j);
			  data[i-1][j]=(cell==null)?"":cell.toString();
			  
		  }
	  }
    workbook.close();
    fis.close();
    return data;
      
    };
  }

