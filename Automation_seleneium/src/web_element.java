import org.openqa.selenium.chrome.*;
import org.openqa.selenium.*;

public class web_element {
	
	public static void loginstep(WebDriver driver, String user1, String pass1, String testexecution) throws InterruptedException {
		System.out.println("manual test--->"+testexecution);
		
		WebElement user=driver.findElement(By.id("user_login"));
		user.sendKeys(user1);
		
		WebElement pass=driver.findElement(By.id("user_password"));
		pass.sendKeys(pass1);
		
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();

		driver.get("http://zero.webappsecurity.com/login.html");
        System.out.println("welcome to login page");
        
        
        loginstep(driver,"852258", "password", "unable to login");
        loginstep(driver,"username", "852258", "unable to login");
        loginstep(driver,"852258klj", "582password", "unable to login");
        loginstep(driver,"852258lkjh", "p85assword", "unable to login");
        loginstep(driver,"username", "password", "able to login");
        
        
        
	}

}
