package com.Account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.adayroi.core.Custom;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Demo {
	WebDriver driver = DriverUtil.getInstance("Chrome");

	@Given("^I access to page \"([^\"]*)\"$")
	public void i_access_to_page(String baseUrl) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		baseUrl = "http://adayroi.com";
		driver.get(baseUrl);

	}

	@When("^I click to button Register$")
	public void i_click_to_button_Register() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id='header__main__segment_user_info__text__title']")).click();
		driver.findElement(By.xpath("//*[@id='header__main__segment_user_info__menu__item_user_login']/div")).click();
	}

	@Then("^I see a form login or register, I click in form, it requires type email or password$")
	public void i_see_a_form_login_or_register_I_click_in_form_it_requires_type_email_or_password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I input name's product to search box then I click button Search$")
	public void i_input_name_s_product_to_search_box_then_I_click_button_Search() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement loginFrame = driver.findElement(By.id("auth_iframe"));
		driver.switchTo().frame(loginFrame);
		if (Custom.waitElementDisplay(driver, By.xpath("//*[@id='Email']"), 20)) {
			WebElement email = driver.findElement(By.xpath("//*[@id='Email']"));
			email.sendKeys("v.thaodt2@adayroi.com");
			WebElement password = driver.findElement(By.xpath("//*[@id='Password']"));
			password.sendKeys("123456m");
			driver.findElement(By.xpath("/html/body/div/div/div[1]/form/button")).click();
		}
	}

	@Then("^I click image's product to view detail product$")
	public void i_click_image_s_product_to_view_detail_product() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement searchBox = driver.findElement(By.xpath("//*[@id='header__main__segment_search__form__input']"));
		searchBox.sendKeys("Tivi");
		WebElement buttonSearch = driver.findElement(By.xpath("//*[@id='header__main__segment_search__form__submit']"));
		buttonSearch.click();
	}

	@Then("^I click button Add to cart$")
	public void i_click_button_Add_to_cart() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		WebElement buttonAddtoCart = driver.findElement(By.xpath("//*[@id='top_shopping_button']"));
	    buttonAddtoCart.click();
	}

}
