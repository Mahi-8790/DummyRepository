package Testng_package;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	public class Loginpage {
	    WebDriver driver;
	    By username = By.id("user_login");
	    By password = By.id("user_password");
	    By loginButton = By.xpath("//*[@id=\"login_form\"]/div[2]/input");

	    public Loginpage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void login(String user, String pass) {
	        driver.findElement(username).sendKeys(user);
	        driver.findElement(password).sendKeys(pass);
	        driver.findElement(loginButton).click();
	    }
	}



