package curs11;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumLocators {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://keybooks.ro/"); }

	@Test
	public void linkTextLocator() { //cauta textul care se afla intre tagurile html, in cazul asta Books
		//<a href="https://keybooks.ro/shop/">Books</a>
		//getText() --> <a href...> textul de aici </a>
		
		WebElement booksLink = driver.findElement(By.linkText("BOOKS"));
		booksLink.click();
		assertEquals(driver.getCurrentUrl(), "https://keybooks.ro/shop/");
		
		// asta e la fel ca liniile 28 29 - driver.findElement(By.linkText("Books")).click();
		
	}
	
	// linkText si partialLinkText functioneaza doar pe tagnameuri de tip <a...>
	
	@Test(priority=1)
	public void partialLinkTextLocator() {
		
		WebElement cookingBookLink = driver.findElement(By.partialLinkText("Cooking"));
		cookingBookLink.click();
		String actualPageUrl = driver.getCurrentUrl();
		assertEquals(actualPageUrl, "https://keybooks.ro/shop/cooking-with-love/");
	}
	
	@Test(priority = 2)
	public void classNameLocator() {
		WebElement price = driver.findElement(By.className("price"));
		assertTrue(price.isDisplayed());
		String priceValue = price.getText();
		System.out.println(priceValue);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red')", price);
	}
	
	@Test(priority = 3)
	public void idLocator() throws InterruptedException {
		
		WebElement tabReview = driver.findElement(By.id("tab-title-reviews"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red')", tabReview);
		Thread.sleep(5000);
		tabReview.click();
	}
	
	@Test(priority=4)
	public void xpathLocator() throws InterruptedException {
		WebElement commentBox = driver.findElement(By.xpath("//textarea[@id='comment']"));
		//Thread.sleep(5000);
		commentBox.sendKeys("My Comment"); 
	}
	
	@Test(priority=5)
	public void nameLocator() throws InterruptedException {
		
		WebElement nameBox = driver.findElement(By.name("author"));
		nameBox.sendKeys("Test Ceva");
		Thread.sleep(3000);
		nameBox.clear();
		Thread.sleep(3000);
		nameBox.sendKeys("JB");
	}
	@Test(priority=6)
	public void cssSelector() {
		//input[type='email] --> cssSelector
		// //input[@type='email'] --> Xpath
		WebElement emailBox = driver.findElement(By.cssSelector("input[type='email']"));
		emailBox.sendKeys("test@test.test");
		
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}

}
