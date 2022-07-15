@PlanITAutomation
Feature: Testing the Plan IT Automation cases


	@TC1
  Scenario: This scenario is to test wether "Home,Shop,Contact,Login, Cart" tabs 
  					are available at the top section.
    Given User logs into the application in "Chrome" browser
    Then User checks wether "Home,Shop,Contact,Login,Cart" menu are available in the top section
    And User checks wether it is navigated to "Home" menu
  
  @TC2
  Scenario: This scenario is to test when Start stopping button is clicked, 
  					user gets naviageted to Shop section.
    Given User logs into the application in "Chrome" browser
    And User clicks "Start Shopping" button
    Then User checks wether it is navigated to "Shop" menu
  
  @TC3
  Scenario: This scenario is to test when user plans to buy some toys in the Shop section, 
  					and toy count is updated near Cart keyword at the top section.
    Given User logs into the application in "Chrome" browser
    And User clicks "Start Shopping" button
    When User buys "Teddy Bear" toy
    And  User buys "Teddy Bear" toy
    And User buys "Handmade Doll" toy
    Then User checks "3" items added near the Cart keyword at the top
    
  @TC4
  Scenario: This scenario is to test when user plans to buy some toys in the Shop section, 
  					and quantity of the toy are updated as expected.
    Given User logs into the application in "Chrome" browser
    And User clicks "Start Shopping" button
    When User buys "Teddy Bear" toy
    And  User buys "Teddy Bear" toy
    And User buys "Handmade Doll" toy
    Then User clicks "Cart" button
    And User checks wether "Teddy Bear" toy with "2" quantity in the list
    And User checks wether "Handmade Doll" toy with "1" quantity in the list
    
  @TC5
	Scenario: This scenario is to test when user plans to buy some toys in the Shop section, 
  					and price of the toy are updated as expected.
    Given User logs into the application in "Chrome" browser
    And User clicks "Start Shopping" button
    When User buys "Teddy Bear" toy
    And  User buys "Teddy Bear" toy
    And User buys "Handmade Doll" toy
    Then User clicks "Cart" button
    And User checks the subtotal of "Teddy Bear" to be "$25.98"
    And User checks the subtotal of "Handmade Doll" to be "$10.99"
    And User checks the total of the cart to be "$36.97"  

	@TC6
	Scenario: This scenario is to test wether "Remove" action works as expected.
    Given User logs into the application in "Chrome" browser
    And User clicks "Start Shopping" button
    When User buys "Teddy Bear" toy
    And  User buys "Teddy Bear" toy
    And User buys "Handmade Doll" toy
    Then User clicks "Cart" button
    And User removes "Teddy Bear" toy from the cart list
    And User clicks "Yes" button
    And User checks wether "Teddy Bear" toy is not present in the cart list
    And User checks the total of the cart to be "$10.99"
    
  @TC7
	Scenario: This scenario is to test wether "Empty Cart" action works as expected.
    Given User logs into the application in "Chrome" browser
    And User clicks "Start Shopping" button
    When User buys "Teddy Bear" toy
    And  User buys "Teddy Bear" toy
    And User buys "Handmade Doll" toy
    Then User clicks "Cart" button
    And User clicks "Empty Cart" button
    And User clicks "Yes" button
    And User checks wether "cart is empty" alert present in the "Cart" page
    And User checks "0" items added near the Cart keyword at the top
  
  @TC8
	Scenario: This scenario is to test wether mandatory fields are validated as expected in Checkout page.
    Given User logs into the application in "Chrome" browser
    And User clicks "Start Shopping" button
    When User buys "Teddy Bear" toy
    And  User buys "Teddy Bear" toy
    And User buys "Handmade Doll" toy
    Then User clicks "Cart" button
    And User clicks "Check Out" button
    And User clicks "Submit" button
    And User checks wether mandatory fields validation alert comes to the "checkout" page
    
  @TC9
	Scenario Outline: E2E sceario
    Given User logs into the application in "Chrome" browser
    And User clicks "Start Shopping" button
    When User buys "Teddy Bear" toy
    And  User buys "Teddy Bear" toy
    And User buys "Handmade Doll" toy
    Then User clicks "Cart" button
    And User clicks "Check Out" button
    And User enters "Forename" as <Forename>
    And User enters "Surname" as <Surname>
    And User enters "Email" as <Email>
    And User enters "Telephone" as <Telephone>
    And User enters "Address" as <Address>
    And User selects "Card Type" as <Card Type>    
    And User enters "Card Number" as <Card Number>
    And User clicks "Submit" button
    And User checks wether "Thanks John" alert present in the "Cart" page
    
  Examples:
  | Forename | Surname 	| Email 											 | Telephone 			| Address 					 | Card Type | Card Number					 |
  | "John"   | "Example"| "john.example@planit.net.au" | "02 1234 5678" | "101 Example Road" | "Visa"		 | "1234 9876 1234 9876" |

  @TC10
  Scenario:  This scenario is to test wether mandatory fields are validated as expected in Contact page.
  	Given User logs into the application in "Chrome" browser
    Then User clicks "Contact" button
    And User clicks "Submit" button
    And User checks wether mandatory fields validation alert comes to the "contact" page

	@TC11
	Scenario Outline: This scenario is to test wether Contact section works as expected.
    Given User logs into the application in "Chrome" browser
   	Then User clicks "Contact" button
    And User enters "Forename" as <Forename>
    And User enters "Surname" as <Surname>
    And User enters "Email" as <Email>
    And User enters "Telephone" as <Telephone>
    And User enters "Message" as <Message>
    And User clicks "Submit" button
    And User checks wether "Thanks John" alert present in the "Contact" page
  
  Examples:
  | Forename | Surname 	| Email 											 | Telephone 			| Message 					   |
  | "John"   | "Example"| "john.example@planit.net.au" | "02 1234 5678" | "Tell us about it.." |
    
    
  @TC12
  Scenario: This scenario is to test wether Login section works as expected.
    Given User logs into the application in "Chrome" browser
   	Then User clicks "Login" button
   	And User enters "Username" as "Shreesh"
    And User enters "Password" as "Shreesh"
    And User clicks "Login" button in the modal
    And User checks wether "Your login details are incorrect" alert present in the "Login" page