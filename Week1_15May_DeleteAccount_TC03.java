package sprint1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week1_15May_DeleteAccount_TC03 {

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
			    WebElement Selectdrp = driver.findElement(By.xpath("//div[@data-aura-class='forceVirtualAction']/parent::span[1]"));
			    Selectdrp.click();
			    JavascriptExecutor js1 = (JavascriptExecutor)driver;		
			    js1.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[@title='Delete']")));
			    Thread.sleep(1000);
			    WebElement AccountDelete = driver.findElement(By.xpath("//span[text()='Delete']"));
			    AccountDelete.click();
			    WebElement element = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"));
		        
		        String text=element.getText();
		        
		        System.out.println(text);
			    
		        String expectedHeading = text;
		        
		        if(expectedHeading.equalsIgnoreCase(expectedHeading))
		          	System.out.println("The expected heading is same as actual heading");
		    		else
		          	System.out.println("The expected heading doesn't match the actual heading");
	}

}
