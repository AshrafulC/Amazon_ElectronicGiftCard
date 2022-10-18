package misc;




import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;






public class ElectronicGiftCard {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Navigate to Amazon.com on browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayesh\\eclipse-workspace\\Amazon_Project\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		String title="Amazon.com. Spend less. Smile more.";
		Assert.assertEquals(title, driver.getTitle());
		System.out.println("Amazon main page title is :" + driver.getTitle());
		
		
		
		//Search for electronic gift card
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("electronic gift card");
		//driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("electronic gift card");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("After search, Page title is :" + driver.getTitle());
		
		
		
		//Select and Click on Starbucks Gift Card- Email Delivery
		
		driver.findElement(By.xpath("//a[contains(text(), '2')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Starbucks Gift Cards - Email Delivery']")).click();
		System.out.println("Page title is :" + driver.getTitle());
		String actual=driver.findElement(By.xpath("//span[text()='Starbucks Gift Cards - Email Delivery']")).getText();
		Assert.assertEquals(actual,"Starbucks Gift Cards - Email Delivery");
		System.out.println(actual);
		

		
		//Select $ 100 Gift card and the ecard with any Thank you wording available
		driver.findElement(By.xpath("//button[@value='100.00']")).click();
		String CardValue=driver.findElement(By.xpath("//span[contains(text(),'Hope you enjoy this gift card')]//../..//span[text()='$100.00']")).getText();
		Assert.assertEquals(CardValue,"$100.00");
		System.out.println("Gift card Value is :" + CardValue);
		String GiftCard=driver.findElement(By.xpath("//span[contains(text(),'Hope you enjoy this gift card')]")).getText();
		Assert.assertEquals(GiftCard,"Hope you enjoy this gift card!");
		System.out.println("Ecard message is :  " +GiftCard);
		
		
		
		
		//Enter To, form and any Special message with Delivery scheduled for October 31st 2022
		driver.findElement(By.xpath("//textarea[@placeholder='Enter an email for each recipient']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Your name']")).sendKeys("Jhon");
		driver.findElement(By.xpath("//textarea[@name='message']")).clear();
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Thank you!!");
		driver.findElement(By.xpath("//input[@id='gc-order-form-quantity']")).clear();
		driver.findElement(By.xpath("//input[@id='gc-order-form-quantity']")).sendKeys("1");
		driver.findElement(By.xpath("//i[@class='a-icon a-icon-calendar']")).click();
		driver.findElement(By.xpath("//a[text()='31']")).click();
		Thread.sleep(3000);
		
		
		
		//Add to cart and validate Cart Sub total field value of $100 
		driver.findElement(By.xpath("//span[@id='a-autoid-0']")).click();
		System.out.println("Page title is :" + driver.getTitle());
		
		String AddedCard=driver.findElement(By.xpath("//span[contains(text(),'Added to Cart')]")).getText();
		Assert.assertEquals(AddedCard,"Added to Cart");
		System.out.println("Added card message :  " +AddedCard);
		
		
		
		String SubtotalValue=driver.findElement(By.xpath("(//span[text()='00']//..//span[text()='100'])[1]")).getText();
		Assert.assertEquals(SubtotalValue,"100");
		System.out.println("Card Subtotal Value is :" +SubtotalValue);
		
		String Promomessage=driver.findElement(By.xpath("//div[@class='a-section maple-banner__text']")).getText();
		System.out.println("Promotional message is :" +Promomessage);
				
		}
	
}
