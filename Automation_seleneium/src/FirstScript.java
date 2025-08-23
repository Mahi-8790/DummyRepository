import org.openqa.selenium.chrome.*;
import org.openqa.selenium.*;

public class FirstScript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
System.out.println("hi my firstscript");
WebDriver driver=new ChromeDriver();


driver.get("https://www.selenium.dev/");
String expectedurl="https://www.selenium.dev/";
String actualurl=driver.getCurrentUrl();

String expectedtitle="Selenium";
String actualtitle=driver.getTitle();
System.out.println("expectedtitle="+expectedtitle);
System.out.println("actualtitle="+actualtitle);

driver.manage().window().maximize();
Thread.sleep(500);


if(expectedurl.equals(actualurl)) {
	System.out.println("url valid");
}
else {
	System.out.println("url invalid");
}

if(expectedtitle.equals(actualtitle)) {
	System.out.println("valid title");
}
else {
	System.out.println("title invalid");
}
driver.close();
System.out.println("page load successfully");
}

	}


