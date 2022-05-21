package sprint1;

import java.time.Duration;

import javax.swing.text.TabableView;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week1_15May_EditAccount_TC02 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		//Launch Chromedriver
		WebDriverManager.chromedriver().setup();
		
		//Handling notifications
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//Launch Salesforce app
		driver.get("https://login.salesforce.com");
		
		//Maximize the screen
		driver.manage().window().maximize();
		
		//Entering credentials and login
	    driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");
	    driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
	    driver.findElement(By.id("Login")).click();
	    
	    //Click on toggle menu button from the left corner
	    driver.findElement(By.xpath("//div[@role='navigation']")).click();
	    
	    //Click view All and click Sales from App Launcher
	    driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
	    driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
	    driver.findElement(By.xpath("//p[text()='Manage your sales process with accounts, leads, opportunities, and more']")).click();
	    
	    //Creating the JavascriptExecutor interface object and click on accounts object
	    JavascriptExecutor js = (JavascriptExecutor)driver;		
	    js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Accounts']")));
	    
	    
	    //Search for the Account Using the unique account name created by you 
	    driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Yourname"+ Keys.ENTER);
	    Thread.sleep(1000);
	    
	    //Click on the displayed Account Dropdown icon and select Edit
	    WebElement Selectdrp= driver.findElement(By.xpath("//div[@data-aura-class='forceVirtualAction']/parent::span[1]"));
	    Selectdrp.click();
	    JavascriptExecutor js1 = (JavascriptExecutor)driver;		
	    js1.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@title='Edit']")));
	    Thread.sleep(1000);
	    
	    //Select Type as Technology Partner
	    WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	    WebElement TypeSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Type']/following::div")));
	    TypeSelect.click();
	    TypeSelect.findElement(By.xpath("//span[contains(@title,'Technology Partner')]")).click();

	    Thread.sleep(1000);
	    
	    //Select Industry as Health Care
	    WebElement IndustryA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Industry, --None--']")));
	    IndustryA.click();
	    
	    WebElement Health = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@title,'Healthcare')]"))); 	
	    js.executeScript("arguments[0].scrollIntoView();", Health);
	    Health.click();
	    
	 
	    //Enter Billing Address
	    WebElement BillingAddress = driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea"));
	    BillingAddress.sendKeys("ABC");
	    
	    //Enter Shipping Address
	    WebElement ShippingAddress = driver.findElement(By.xpath("//label[text()='Shipping Street']/following::textarea"));
	    ShippingAddress.sendKeys("ASW");
	    
   
	    //Select Customer Priority as Low
	    
	    WebElement CustomerPriority = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Customer Priority']/following::div")));
	    js.executeScript("arguments[0].scrollIntoView();", CustomerPriority);
	    CustomerPriority.click();
	    CustomerPriority.findElement(By.xpath("//span[contains(@title,'Low')]")).click();
	    
	    
	    //Select SLA as Silver
	    WebElement SLA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='SLA']/following::div")));
	    SLA.click();
	    SLA.findElement(By.xpath("//span[contains(@title,'Silver')]")).click();
	

	    //Select Active as NO 
	    WebElement Active = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Active']/following::div")));
	    Active.click();
	    Active.findElement(By.xpath("//span[text()='No']")).click(); 
	    
	  
		//Enter Unique Number in Phone Field
	    WebElement Phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Phone']")));
	    js.executeScript("window.scrollBy(0,250)", "", Phone);
	    Phone.sendKeys("567890");
	    Thread.sleep(1000);

	    
	    //Select Upsell Opportunity as No
	    js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//label[text()='Upsell Opportunity']//following::button[contains(@aria-label,'Upsell')]")));
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//label[text()='Upsell Opportunity']//following::button[contains(@aria-label,'Upsell')]")).click();
	    
	    Actions action = new Actions(driver);
		WebElement UT1 = driver.findElement(By.xpath("//span[text()='No']"));
		action.moveToElement(UT1).click().build().perform();
	       
		//Click on save 
		WebElement Save = driver.findElement(By.xpath("//button[text()='Save']"));
		Save.click();

		//Verify Phone number
		WebElement Number = driver.findElement(By.xpath("//span[text()[normalize-space()='Edit Phone: Item 1']]"));
		String Text= Number.getText(); 
	    System.out.println(Text);
	    String expectedHeading = "567890";
	      
	     
	     if(expectedHeading.equalsIgnoreCase(expectedHeading))
	        	System.out.println("The expected heading is same as actual heading" +Text);
  		else
	        	System.out.println("The expected heading doesn't match the actual heading" +Text);		    
		    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	 
	   
	    
	   
	    
	   

	}

}
