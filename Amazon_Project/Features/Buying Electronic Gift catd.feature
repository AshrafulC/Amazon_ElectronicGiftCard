Feature: Add electronic gift card in cart

Scenario: Successful Add electronic gift card with valid credentials
	Given User Lunch Chrome browser
	When User opens URL
  Then Page Title should be "Amazon.com. Spend less. Smile more."
	Then User search for electronic gift card
	Then User click on Starbucks Gift cards- Email delivery
	Then User select gift card
	And User input buyer information
	And User validate Cart subtotal value
#	And Close browser