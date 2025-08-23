package Testng_package;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.interactions.Actions;


public class project {
	WebDriver driver;
  @Test
  public void login() throws InterruptedException, IOException {
	/*  WebElement login2=driver.findElement(By.xpath("//*[@id=\"gh\"]/nav/div[1]/span[1]/span/a"));
	  login2.click();
	  
	  WebElement login12=driver.findElement(By.id("checkbox"));
	  login12.click();
	  login12.sendKeys(Keys.ENTER);
	  
	
	  
	  WebElement login=driver.findElement(By.id("userid"));
	  login.sendKeys("mahi879082@gmail.com");
	  login.sendKeys(Keys.ENTER);
	  
	  WebElement login1=driver.findElement(By.id("pass"));
	  login.click();
	  Thread.sleep(5000);
	 
	  login1.sendKeys("8919215039@Mk");
	  
	  login1.sendKeys(Keys.ENTER);
	  
	  
	 // WebElement login4=driver.findElement(By.id("passkeys-cancel-btn"));
	  //login4.click();
	  //Thread.sleep(3000);
	  //login4.click();*/
	  
	/*  WebElement search=driver.findElement(By.xpath("//*[@id=\"gh-ac\"]"));
	  search.click();
	  search.sendKeys("macbook pro");
	  search.sendKeys(Keys.ENTER);
	  
	  WebElement select=driver.findElement(By.xpath("//*[@id=\"item451abbf3e5\"]/div/div[2]/a/div/span"));
	  select.click();
	  Thread.sleep(2000);
	  select.sendKeys(Keys.ENTER);
	  
	  driver.navigate().refresh();
	  
	  WebElement add=driver.findElement(By.xpath("//*[@id=\"atcBtn_btn_1\"]/span/span"));
	  add.click();
	  
	  add.sendKeys(Keys.ENTER);
	  */
	  
	  
	  
	  
	/*  WebElement cat=driver.findElement(By.id("gh-cat"));
	  cat.click();
	  
	  WebElement cat1=driver.findElement(By.id("gh-cat"));
	  cat1.click();
	  cat1.sendKeys("Art");
	  
	  WebElement ser=driver.findElement(By.xpath("//*[@id=\"gh-search-btn\"]/span"));
	  ser.click();
	  */
	  
	  
	  
	  
	  
	  
	  
	 
	  
	  
	  
	  
	  
	  
	  driver.navigate().refresh();
	  
	  
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  
	  driver=new ChromeDriver();
	  driver.get("https://www.ebay.com/");
      driver.manage().window().maximize();
      Thread.sleep(5000);
  }

  @AfterTest
  public void afterTest() {
	  
  }

}



/*

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class  project {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String baseUrl = "https://www.ebay.com";

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        if (driver != null) driver.quit();
    }

    private void goHome() {
        driver.navigate().to(baseUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[aria-label='Search for anything']")));
    }

    private void signIn(String user, String pass) {
        goHome();
        // Sign in link typically at top; text/aria may vary per region
        driver.findElement(By.linkText("Sign in")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")));
        driver.findElement(By.id("userid")).clear();
        driver.findElement(By.id("userid")).sendKeys(user);
        driver.findElement(By.id("signin-continue-btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        driver.findElement(By.id("pass")).sendKeys(pass);
        driver.findElement(By.id("sgnBt")).click();
        // Verify by presence of My eBay or avatar/menu
        wait.until(ExpectedConditions.or(
            ExpectedConditions.visibilityOfElementLocated(By.linkText("My eBay")),
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label*='Account']"))
        ));
    }

    @Test(priority = 1)
    public void tc01_login() {
        signIn(System.getProperty("EBAY_USER"), System.getProperty("EBAY_PASS"));
        boolean signedIn = driver.findElements(By.linkText("My eBay")).size() > 0
                || driver.findElements(By.cssSelector("button[aria-label*='Account']")).size() > 0;
        Assert.assertTrue(signedIn, "Expected to be signed in.");
        // Post-condition: stay logged in
    }

    @Test(priority = 2, dependsOnMethods = "tc01_login")
    public void tc02_multiSearchUsingArray() {
        goHome();
        String[] terms = new String[]{"iPhone 13 case", "PS4 controller", "wireless earbuds"};
        for (String q : terms) {
            WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[aria-label='Search for anything']")));
            search.clear();
            search.sendKeys(q);
            driver.findElement(By.id("gh-btn")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.srp-results, div[data-testid='srp-main-content']")));
            // Validate results contain items
            int items = driver.findElements(By.cssSelector("li.s-item, div.s-item__wrapper")).size();
            Assert.assertTrue(items > 0, "No results for: " + q);
        }
        // Post-condition: on last search results page
    }

    @Test(priority = 3, dependsOnMethods = "tc01_login")
    public void tc03_addToCart() {
        goHome();
        // Search a likely fixed-price item
        driver.findElement(By.cssSelector("input[aria-label='Search for anything']")).sendKeys("USB C cable");
        driver.findElement(By.id("gh-btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.srp-results")));
        // Open first result detail page
        WebElement first = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.srp-results li.s-item a.s-item__link")));
        String listingHref = first.getAttribute("href");
        first.click();
        // Switch if opened in same tab
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1, #LeftSummaryPanel, #mainContent")));
        // Add to cart (button text may be "Add to cart")
        List<WebElement> addButtons = driver.findElements(By.cssSelector("a[aria-label='Add to cart'], button#atcRedesignId_btn, button[aria-label='Add to cart']"));
        if (addButtons.isEmpty()) {
            // Some listings require selecting variation first (size/color), pick defaults if present
            List<WebElement> selects = driver.findElements(By.cssSelector("select"));
            for (WebElement s : selects) {
                Select sel = new Select(s);
                if (sel.getOptions().size() > 1) sel.selectByIndex(1);
            }
            addButtons = driver.findElements(By.cssSelector("button[aria-label='Add to cart'], button#atcRedesignId_btn"));
        }
        Assert.assertFalse(addButtons.isEmpty(), "Add to cart not found for: " + listingHref);
        addButtons.get(0).click();
        // Confirmation and cart count
        wait.until(ExpectedConditions.or(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='atc-layer, .atc-layer']")),
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[aria-label*='Cart']"))
        ));
        // Go to cart
        driver.findElement(By.cssSelector("a[aria-label*='Cart']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CartSummary")));
        int cartLines = driver.findElements(By.cssSelector("[data-test-id='cart-item'], .cart-bucket-lineitem")).size();
        Assert.assertTrue(cartLines >= 1, "Cart should have at least 1 item.");
        // Post-condition: item present in cart
    }

    @Test(priority = 4, dependsOnMethods = "tc03_addToCart")
    public void tc04_deleteFromCart() {
        // Assumes cart open or navigate
        driver.findElement(By.cssSelector("a[aria-label*='Cart']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CartSummary")));
        List<WebElement> removeButtons = driver.findElements(By.xpath("//button[contains(.,'Remove') or contains(.,'Delete')]"));
        if (removeButtons.isEmpty()) {
            removeButtons = driver.findElements(By.cssSelector("button[data-test-id*='REMOVE'], button[aria-label*='Remove']"));
        }
        Assert.assertFalse(removeButtons.isEmpty(), "No remove button found.");
        int before = driver.findElements(By.cssSelector("[data-test-id='cart-item'], .cart-bucket-lineitem")).size();
        removeButtons.get(0).click();
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("[data-test-id='cart-item'], .cart-bucket-lineitem"), before));
        // Post-condition: cart reduced or empty
    }

    @Test(priority = 5, dependsOnMethods = "tc01_login")
    public void tc05_changeLoginName() {
        // Navigate to account settings / personal info
        goHome();
        // Open account menu
        driver.findElement(By.cssSelector("button[aria-label*='Account']")).click();
        // A link to Account settings/My eBay Summary
        driver.findElement(By.linkText("Account settings")).click();
        // Switch to settings page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1, h2")));
        // Locate name edit (selectors vary; pseudo)
        // Example pattern: Personal info -> Edit name
        driver.findElement(By.partialLinkText("Personal info")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a, button")));
        List<WebElement> editName = driver.findElements(By.xpath("//button[contains(.,'Edit')][ancestor::section[contains(.,'Name')]]|//a[contains(.,'Edit')][ancestor::section[contains(.,'Name')]]"));
        Assert.assertFalse(editName.isEmpty(), "Edit Name not found.");
        editName.get(0).click();
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name*='name']")));
        String newName = "QA Tester " + System.currentTimeMillis()%1000;
        nameField.clear();
        nameField.sendKeys(newName);
        driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
        // Verify updated
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(.,'" + newName + "')]")));
        // Post-condition: profile shows updated name
    }

    @Test(priority = 6, dependsOnMethods = "tc01_login")
    public void tc06_changeAddress() {
        goHome();
        driver.findElement(By.cssSelector("button[aria-label*='Account']")).click();
        driver.findElement(By.linkText("Account settings")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1, h2")));
        driver.findElement(By.partialLinkText("Addresses")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section")));
        // Edit primary shipping
        List<WebElement> editAddr = driver.findElements(By.xpath("//button[contains(.,'Edit')][ancestor::section[contains(.,'Shipping')]]|//a[contains(.,'Edit')][ancestor::section[contains(.,'Shipping')]]"));
        Assert.assertFalse(editAddr.isEmpty(), "Edit shipping address not found.");
        editAddr.get(0).click();
        WebElement line1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name*='street'], input[name*='address1']")));
        line1.clear();
        line1.sendKeys("123 Test Street");
        WebElement city = driver.findElement(By.cssSelector("input[name*='city']"));
        city.clear(); city.sendKeys("San Jose");
        WebElement state = driver.findElement(By.cssSelector("select[name*='state']"));
        new Select(state).selectByVisibleText("California");
        WebElement zip = driver.findElement(By.cssSelector("input[name*='zip']"));
        zip.clear(); zip.sendKeys("95131");
        driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
        // Verify appears as default
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(.,'123 Test Street')]")));
        // Post-condition: default address updated
    }

    @Test(priority = 7)
    public void tc07_shopByCategories() {
        goHome();
        driver.findElement(By.id("gh-shop-a")).click(); // Shop by category toggle
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-sbc")));
        // Choose Electronics -> Cell Phones & Accessories
        driver.findElement(By.linkText("Electronics")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1, nav[aria-label='Breadcrumbs']")));
        // Optional subcategory navigation if visible
        List<WebElement> sub = driver.findElements(By.partialLinkText("Cell Phones"));
        if (!sub.isEmpty()) sub.get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.srp-results, #mainContent")));
        // Validate category page
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("electronics") || driver.getTitle().toLowerCase().contains("cell"), "Category title mismatch");
        // Post-condition: category page open
    }

    @Test(priority = 8)
    public void tc08_rightClickImageOpenAndVerifyDescription() {
        goHome();
        driver.findElement(By.cssSelector("input[aria-label='Search for anything']")).sendKeys("wireless mouse");
        driver.findElement(By.id("gh-btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.srp-results")));
        WebElement imgLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.srp-results li.s-item a.s-item__link")));
        String openInNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        imgLink.sendKeys(openInNewTab);
        // Switch to new tab
        String original = driver.getWindowHandle();
        for (String h : driver.getWindowHandles()) {
            if (!h.equals(original)) {
                driver.switchTo().window(h);
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        // Scroll to description/details
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 800);");
        // eBay may host description in an iframe or section
        List<WebElement> desc = driver.findElements(By.cssSelector("#viTabs_0_is, #desc_ifr, section[aria-label*='Description'], #vi-desc-maincntr"));
        Assert.assertTrue(desc.size() > 0, "Description section not found");
        // Post-condition: listing tab remains open
    }

    @Test(priority = 9)
    public void tc09_shopByAllCategories() {
        goHome();
        driver.findElement(By.id("gh-shop-a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-sbc")));
        WebElement allCats = driver.findElement(By.linkText("See all categories"));
        allCats.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1, .all-categories")));
        // open a few categories
        driver.findElement(By.linkText("Fashion")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.srp-results, #mainContent")));
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1, .all-categories")));
        driver.findElement(By.linkText("Home & Garden")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.srp-results, #mainContent")));
        // Post-condition: last category page open
    }

    @Test(priority = 10)
    public void tc10_changeLanguageRegion() {
        goHome();
        // Footer flag: change country/region; language changes partially by region
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        // Click the country/region/flag selector; text varies per region
        List<WebElement> flag = driver.findElements(By.cssSelector("button[aria-label*='Country'], a[aria-label*='Country'], a[aria-label*='Site'], a[aria-label*='region']"));
        if (flag.isEmpty()) {
            flag = driver.findElements(By.linkText("United States"));
        }
        Assert.assertFalse(flag.isEmpty(), "Country/region selector not found");
        flag.get(0).click();
        // Choose Spain or Italy to observe language shift
        List<WebElement> regionLinks = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("a[href*='ebay.es'], a[href*='ebay.it'], a[href*='ebay.de']")));
        regionLinks.get(0).click();
        // Validate partial language change (categories in target language)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body")));
        String title = driver.getTitle().toLowerCase();
        boolean localized = title.contains("espa") || title.contains("ital") || title.contains("alem");
        Assert.assertTrue(localized, "Expected localized marketplace title");
        // Post-condition: site in selected region; can revert similarly
    }
}


*/
















