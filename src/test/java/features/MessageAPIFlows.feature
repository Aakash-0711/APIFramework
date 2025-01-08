Feature: Message Sending Service
 
  
  Scenario: Successfully sending an message with complete and valid information
    Given I want to send an message through the system
    And I have provided all required personal details in "src\\test\\resources\\requestPayLoad\\SuccessfulPostPayLoad.json"
    When I submit the message request
    Then the system should confirm the message has been sent successfully as 201
    And I should receive a positive confirmation message
     | name        | Aakash         |
     | email       | booking@gmail.com  |
     
     
   
   Scenario: Trying to send an email with an incorrectly formatted email address
    Given I want to send an message through the system
    But I have entered an email address in an incorrect format in "src\\test\\resources\\requestPayLoad\\InvalidEmailAddress.json"
    When I submit the message request
    Then the system should reject the submission as 400
    
    Scenario: To view the already created particular message
     Given I want to view the particular message created
     When I submit the message request
     Then the system should confirm the message has been sent successfully as 200
     And I should receive a positive confirmation message
     | name        | Aakash         |
    
    Scenario: Successfully update the existing record by changing the email address
     Given I want to update the existing message by changing the email address
     And I have provided all required personal details in "src\\test\\resources\\requestPayLoad\\updateEmailAddress.json"
     When I submit the message request
     Then the system should confirm the message has been sent successfully as 200
    
    Scenario: Successfully delete the existing message record
    Given I want to delete the existing date
    When I submit the message request
    Then the system should confirm the message has been sent successfully as 200
 
    
    
   

    
	
 