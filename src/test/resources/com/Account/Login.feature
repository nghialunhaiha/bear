Feature: Login web adayroi
Scenario: Login with blank page
Given I access to page adayroi.com
When I click to button Registe
Then I see a form login or register, I click in form, it requires type email or password
And I input name's product to search box then I click button Search
And I click image's product to view detail product
And I click button Add to cart
