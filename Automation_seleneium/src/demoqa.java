import org.openqa.selenium.chrome.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
public class demoqa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		Thread.sleep(3000);
		
	/*	WebElement fname=driver.findElement(By.id("firstName"));
		fname.sendKeys("ravi");
		
		WebElement lname=driver.findElement(By.id("lastName"));
		lname.sendKeys("kumar");
		
		WebElement email=driver.findElement(By.id("userEmail"));
		email.sendKeys("abc@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label")).click();
		
		
		
		driver.findElement(By.id("dateOfBirthInput")).click();
		WebElement year=driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select/option[126]"));
		Select sel=new Select(year);
		sel.selectByValue("2025");
		  
		//year=//*[@id="dateOfBirth"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select/option[126]
		//month=//*[@id="dateOfBirth"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select/option[6]
		// day=//*[@id="dateOfBirth"]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[3]
		
		
		WebElement month=driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select/option[6]"));
		Select sel1=new Select(month);
		sel1.selectByValue("June");
		
	
		
		
		driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[3]")).click();
		
		
		*/
		String[] subjects= {"maths", "phy", "Eco", "Eng"};
		
		WebElement sub=driver.findElement(By.id("subjectsInput"));
		for(String subject:subjects)
		{
			sub.sendKeys(subject);
			Thread.sleep(1000);
			sub.sendKeys(Keys.ENTER);
		}
		/*sub.sendKeys("Maths");
		sub.sendKeys(Keys.ENTER);
		sub.sendKeys("Phy");
		sub.sendKeys(Keys.ENTER);
		sub.sendKeys("co");
		sub.sendKeys(Keys.ARROW_DOWN);
		sub.sendKeys(Keys.ENTER);*/
		
		WebElement img=driver.findElement(By.id("uploadPicture"));
		img.sendKeys("C:\\Users\\mahender reddy\\OneDrive\\Pictures\\Screenshots\\Screenshot (3).png");
		
		WebElement state=driver.findElement(By.id("react-select-3-input"));
		
		state.sendKeys("NCR");
		state.sendKeys(Keys.ENTER);
		
		
		WebElement city=driver.findElement(By.id("react-select-4-input"));
		city.sendKeys("Delhi");
		city.sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.id("submit")).click();		
		 

	}

}


// #dateOfBirth > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__month > div:nth-child(3) > div.react-datepicker__day.react-datepicker__day--012.react-datepicker__day--selected.react-datepicker__day--today
// id="firstName" #dateOfBirth > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__header__dropdown.react-datepicker__header__dropdown--select > div.react-datepicker__year-dropdown-container.react-datepicker__year-dropdown-container--select > select





