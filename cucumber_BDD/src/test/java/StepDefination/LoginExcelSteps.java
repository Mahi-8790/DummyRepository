package StepDefination;
import io.cucumber.java.en.Given;

public class LoginExcelSteps {

	 
	
 @Given("user logs in using row {int}")
	    public void user_logs_in_using_row(Integer rowNumber) {
	        String filePath = "src/test/resources/testdata/LoginData.xlsx";
	        String username = ExcelReader.getCellValue("C:\\Users\\mahender reddy\\Downloads\\Excelsheet1.xlsx", "Sheet1", rowNumber, 0);
	        String password = ExcelReader.getCellValue("C:\\Users\\mahender reddy\\Downloads\\Excelsheet1.xlsx", "Sheet1", rowNumber, 1);
	 
	        System.out.println("Username: " + username + " | Password: " + password);
	        // You can now use this data for login
	    }
	}
	 
	