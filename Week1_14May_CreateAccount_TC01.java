package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week1_14May_CreateAccount_TC01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//Launch Chromedriver
		WebDriverManager.chromedriver().setup();
		
		//Handling notifications
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
	    
	    // Click on New button
	    driver.findElement(By.xpath("//a[@title='New']")).click();
	    
	    //Enter 'your name' as account name
	    driver.findElement(By.xpath(".//input[@name='Name']")).sendKeys("YourName");
	    
	    // Click on Ownership field
	    WebElement ownership = driver.findElement(By.xpath("(//button[@data-value='--None--'])[3]"));
	    Actions action = new Actions(driver);
	    action.moveToElement(ownership).click().build().perform();
       
	    // Select Ownership as Public 
	    WebElement ownership1 = driver.findElement(By.xpath("//span[text()='Public']"));
	    action.moveToElement(ownership1).click().build().perform();
	    
	    //Click save 
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        
  	    //Verify Account name and Storing the text of the heading in a string   
        WebElement element = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"));
        
        String text=element.getText();
        
        
        

        System.out.println(text);
        String expectedHeading = "+Created";
        
        if(expectedHeading.equalsIgnoreCase(expectedHeading))
          	System.out.println("The expected heading is same as actual heading");
    		else
          	System.out.println("The expected heading doesn't match the actual heading");
//     
	}

}
