Feature: Login web adayroi
Scenario: Login with blank page
Given I access to page "https://www.adayroi.com/"
When I click to button Register
Then I see a form login or register, I click in form, it requires type email or password