Feature: Placeorder

Scenario Outline:Placing the order successfully
Given the user is on the login page
When the user enter username as "<Username>" and password as "<Password>" and click login button
And the user selects the product
And the user clicks on Add to Cart button
And the user clicks on the Cart icon
And the user clicks on the Checkout button
And the user enter customer information and click Continue button
And the user verifies the product and click Finish button
Then the user clicks the logout button and validate the login button in the login page


Examples:  
|Username|Password|
|standard_user|secret_sauce|
|problem_user|secret_sauce|