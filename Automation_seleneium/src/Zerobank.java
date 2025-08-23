import org.openqa.selenium.chrome.*;
import org.openqa.selenium.*;
public class Zerobank {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();


		driver.get("http://zero.webappsecurity.com/login.html");
        System.out.println("welcome to login page");
        
        {
        	System.out.println("Manual test : : -->check user is unable to login with"
        + "invalid username and valid password");
        }
        

        driver.findElement(By.id("user_login")).click();
        driver.findElement(By.id("user_login")).sendKeys("852852");
        
        
        driver.findElement(By.id("user_password")).click();
        driver.findElement(By.id("user_password")).sendKeys("password");
        
        driver.findElement(By.name("submit")).click();
        Thread.sleep(5000);
        System.out.println("login unsuccess");
        
        
        {
        	System.out.println("Manual test : : -->check user is unable to login with"
        + "valid username and invalid password");
        }
        
        driver.findElement(By.id("user_login")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        
        
        driver.findElement(By.id("user_password")).click();
        driver.findElement(By.id("user_password")).sendKeys("852852");
        
        driver.findElement(By.name("submit")).click();
        Thread.sleep(5000);
        System.out.println("login unsuccess");
        
        
        
        
        
        driver.findElement(By.id("user_login")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        
        
        driver.findElement(By.id("user_password")).click();
        driver.findElement(By.id("user_password")).sendKeys("password");
        
        driver.findElement(By.name("submit")).click();
        System.out.println("login successfully");
        
        
        
        Thread.sleep(3000);
        driver.close();
	}

}
