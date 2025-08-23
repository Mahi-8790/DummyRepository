import org.openqa.selenium.chrome.*;
import org.openqa.selenium.*;
public class orangehrm {
	
	public static void orangelogin(WebDriver driver, String user1, String pass1, String testexecution) throws InterruptedException {
		System.out.println("manual test--->"+testexecution);
		
		
		WebElement user=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		user.sendKeys(user1);
		
		WebElement pass=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		pass.sendKeys(pass1);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		Thread.sleep(3000);
	}
	
	
	


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
		System.out.println("welcome to login page");
		
		orangelogin(driver, "Admin", "admin","unable to login");
		orangelogin(driver, "hello", "admin123","unable to login");
		orangelogin(driver, "Admi85n", "ad456min","unable to login");
		orangelogin(driver, "", "","unable to login");
		orangelogin(driver, "Admin", "admin123","able to login");

	}

}
