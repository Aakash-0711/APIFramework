Feature: Message Sending Service
 
 

  Feature: Message Sending Service
  Scenario: Successfully sending an message with complete and valid information
    Given I want to send an message through the system
    And I have provided all required personal details in "src\\test\\resources\\requestPayLoad\\SuccessfulPostPayLoad.json"
    When I submit the message request
    Then the system should confirm the message has been sent successfully as 201
    And I should receive a positive confirmation message
     | name        | Aakash         |
     | email       | booking@gmail.com  |
    
	
 