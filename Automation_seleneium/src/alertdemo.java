/*import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alertdemo {
	
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		
		WebElement samplealert=driver.findElement(By.id("alertButton"));
		samplealert.click();
		Thread.sleep(4000);
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		
		
		WebElement timealert=driver.findElement(By.id("timerAlertButton"));
		timealert.click();
		Thread.sleep(7000);
		Alert alert2=driver.switchTo().alert();
		alert2.accept();
		
		Thread.sleep(3000);
		WebElement confirmalert=driver.findElement(By.id("confirmButton"));
		confirmalert.click();
		Thread.sleep(3000);
		Alert alert3=driver.switchTo().alert();
		alert1.sendKeys("Harry");
		alert1.accept();
		
		
		
		
	}

}*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class alertdemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(5000);
        driver.manage().window().maximize();

        // Simple Alert
        WebElement sampleAlert = driver.findElement(By.id("alertButton"));
        sampleAlert.click();
        Thread.sleep(4000);
        Alert alert1 = driver.switchTo().alert(); 
        alert1.accept();

        // Timed Alert
        WebElement timeAlert = driver.findElement(By.id("timerAlertButton"));
        timeAlert.click();
        Thread.sleep(7000);
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();

        // Confirmation Alert
        WebElement confirmAlert = driver.findElement(By.id("confirmButton"));
        confirmAlert.click();
        Thread.sleep(3000);
        Alert alert3 = driver.switchTo().alert();
        alert3.dismiss(); // or accept()

        // Prompt Alert
        WebElement promptAlert = driver.findElement(By.id("promtButton"));
        promptAlert.click();
        Thread.sleep(3000);
        Alert alert4 = driver.switchTo().alert();
        alert4.sendKeys("Harry");
        alert4.accept();

        driver.quit();
    }
}
	
	
	
	
