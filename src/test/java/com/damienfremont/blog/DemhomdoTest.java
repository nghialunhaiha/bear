package com.damienfremont.blog;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.java8.En;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(format = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json" })
@CucumberOptions(strict = false, features = "features", format = { "pretty", "json:target/cucumber.json" }, tags = {
		"~@ignore" })
public class DemhomdoTest implements En {
	public DemhomdoTest() {
		Given("^nghia ngu$", () -> {
			// Write code here that turns the phrase above into concrete actions
			System.out.println(": NGhia ngu");
		});

		When("^Thao xinh gai$", () -> {
			// Write code here that turns the phrase above into concrete actions
			System.out.println(": NGhia ngu");
		});

		Then("^Nghia xau trai$", () -> {
			// Write code here that turns the phrase above into concrete actions
			System.out.println(": NGhia ngu");
		});

	}

}
