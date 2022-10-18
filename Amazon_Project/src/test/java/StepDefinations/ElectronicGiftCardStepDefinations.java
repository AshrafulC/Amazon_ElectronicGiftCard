package StepDefinations;


import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.commonPage;
import utilities.CommonUtilities;


public class ElectronicGiftCardStepDefinations {
	WebDriver driver;
	commonPage comPage; 
	CommonUtilities comUtil;
	
	
	public ElectronicGiftCardStepDefinations() {
		comPage = new commonPage();
		comUtil = new CommonUtilities();
	}
	@Given("User Lunch Chrome browser")
	public void user_lunch_chrome_browser() {
		comPage.BrowserOpen();
	}

	@When("User opens URL")
	public void user_opens_url() {
		comPage.OpenAmazonUrl();
	}
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String string) {
		comPage.PageTitle();
	}

	
	
	@Then("User search for electronic gift card")
	public void user_search_for_electronic_gift_card() {
		comPage.searchForElectronicGiftCard();
	}

	@Then("User click on Starbucks Gift cards- Email delivery")
	public void user_click_on_starbucks_gift_cards_email_delivery() throws InterruptedException {
		comPage.userClickOnStarbucksGiftCards();
	}
	
	
	@Then("User select gift card")
	public void user_select_gift_card() {
		comPage.userSelectGiftCard();
	}

	@Then("User input buyer information")
	public void user_input_buyer_information() throws InterruptedException {
		comPage.InputBuyerInformation();
	}

	@Then("User validate Cart subtotal value")
	public void user_validate_cart_subtotal_value() {
		comPage.userValidateCartSubtotalValue();
	}

//	@Then("Close browser")
//	public void close_browser() {
//		driver.close();
//	 
//	}	
	
	
}
