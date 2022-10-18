package pages;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.CommonUtilities;



public class commonPage {
	
	WebDriver driver;
	CommonUtilities comUtil;
	
	
	public commonPage() {
		comUtil = new CommonUtilities();
		}

	public void BrowserOpen() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mehir\\eclipse-workspace\\Amazon_Project\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();	   
	}
	
	public void OpenAmazonUrl() {
		String url1="http://www.amazon.com";
		driver.get(url1);
				
		String url=driver.getCurrentUrl();
			if (url.equalsIgnoreCase(url)){
				System.out.println("Home page Displayed Successfully");
			}else {
				System.out.println("Home page not displayed");
			}			
		}
	   
	public void PageTitle() {
		String title="Amazon.com. Spend less. Smile more.";
		assertEquals(title, driver.getTitle());
		System.out.println("Amazon main page title is :" + driver.getTitle());		
		}

	public void searchForElectronicGiftCard() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("electronic gift card");
		//driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("electronic gift card"); 
		WebElement sub=driver.findElement(By.xpath("//input[@type='submit']"));
		sub.click();
		System.out.println("After search, Page title is :" + driver.getTitle());
	}

	public void userClickOnStarbucksGiftCards() throws InterruptedException {
		//driver.findElement(By.xpath("//a[contains(text(), '2')]")).click();
		driver.findElement(By.xpath("//span[text()='Starbucks Gift Cards - Email Delivery']")).click();
		System.out.println("Page title is :" + driver.getTitle());
		comUtil.forceWait(200);
		String actual=driver.findElement(By.xpath("//span[text()='Starbucks Gift Cards - Email Delivery']")).getText();
		Assert.assertEquals(actual,"Starbucks Gift Cards - Email Delivery");
		System.out.println(actual);
	}
	
	
	public void userSelectGiftCard() {
		driver.findElement(By.xpath("//button[@value='100.00']")).click();
		String CardValue=driver.findElement(By.xpath("//span[contains(text(),'Hope you enjoy this gift card')]//../..//span[text()='$100.00']")).getText();
		Assert.assertEquals(CardValue,"$100.00");
		System.out.println("Gift card Value is :" + CardValue);
		String GiftCard=driver.findElement(By.xpath("//span[contains(text(),'Hope you enjoy this gift card')]")).getText();
		Assert.assertEquals(GiftCard,"Hope you enjoy this gift card!");
		System.out.println("Ecard message is :  " +GiftCard);
	}
	
		
	public void InputBuyerInformation() throws InterruptedException {
		driver.findElement(By.xpath("//textarea[@placeholder='Enter an email for each recipient']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Your name']")).sendKeys("Jhon");
		driver.findElement(By.xpath("//textarea[@name='message']")).clear();
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Thank you!!");
		driver.findElement(By.xpath("//input[@id='gc-order-form-quantity']")).clear();
		driver.findElement(By.xpath("//input[@id='gc-order-form-quantity']")).sendKeys("1");
		driver.findElement(By.xpath("//i[@class='a-icon a-icon-calendar']")).click();
		driver.findElement(By.xpath("//a[text()='31']")).click();
		comUtil.forceWait(400);
		
	}
	
	public void userValidateCartSubtotalValue() {
		driver.findElement(By.xpath("//span[@id='a-autoid-0']")).click();
		System.out.println("Page title is :" + driver.getTitle());
		
		String AddedCard=driver.findElement(By.xpath("//span[contains(text(),'Added to Cart')]")).getText();
		Assert.assertEquals(AddedCard,"Added to Cart");
		System.out.println("Added card message :  " +AddedCard);
		
		String Promomessage=driver.findElement(By.xpath("//div[@class='a-section maple-banner__text']")).getText();
		System.out.println("Promotional message is :" +Promomessage);
	
	  // Validate Cart Subtotal
		String SubtotalValue=driver.findElement(By.xpath("(//span[text()='00']//..//span[text()='100'])[1]")).getText();
			Assert.assertEquals(SubtotalValue,"100");
			System.out.println("Card Subtotal Value is :" +SubtotalValue);
		  if(SubtotalValue.contains("100")) {
		   System.out.println("User validate Cart subtotal field value of $100, Validation PASSED");
		  }
		  else {
		   System.out.println("User Verification Failed,Test case Failed");
		  }
		 }	
}
