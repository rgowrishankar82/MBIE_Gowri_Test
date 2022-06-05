Feature: MBIE - Demo Product store
		# Buy a Product using check-out
		# Use the following Scenarios to test
	
	Scenario: Open the Browser
    Given Open chrome browser
    And Open application

Scenario Outline: Login
		When I navigate to login page
		Then Enter user-id and password
		And Should see home screen
		
Scenario Outline: Purchase
		Given I search and select a product
		And Add to cart
		When Go to cart
		And Enter details of '<Name>','<Country>','<City>','<CreditCard>','<Month>','<Year>'
		And Check out
		Then Validate Order placed successfully
	
	Examples:
    	|	Name	|	Country	    |	City	   | CreditCard          | Month | Year |
    	|	Tester|	New Zealand	|	Auckland | 4422 3322 5566 8866 | 12    | 2025 |
   	
  Scenario: Close the browser
  	And Logout
  	And Close chrome browser