package objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Test1 {
WebDriver driver;

	

	@BeforeMethod

	public void setUp()

	{

	driver=new ChromeDriver();

	driver.get("https://amazon.in");

	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	@Test

	public void verifyTitle()

	{

	String actualTitle=driver.getTitle();

	String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

	Assert.assertEquals(actualTitle, expectedTitle);

	}
  
	

	@Test

	public void verifyLogo()

	{

	boolean flag=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
    Assert.assertTrue(flag);
    

	}

	@Test

	public void testProductSearch(){
		
	

    
	WebElement text=driver.findElement(By.id("twotabsearchtextbox"));
	text.sendKeys("Mobiles");
	driver.findElement(By.id("nav-search-submit-button")).click();
	WebElement resulttext= driver.findElement(By.xpath("//span[text()='1-16 of over 7,000 results for']"));
	String actualresult= resulttext.getText();
	String expectedresult="1-16 of over 7,000 results for";

	Assert.assertEquals(actualresult, expectedresult);

	}
	
	
	
	@AfterMethod

	public void closepage()

	{

	driver.quit();

	}




}

