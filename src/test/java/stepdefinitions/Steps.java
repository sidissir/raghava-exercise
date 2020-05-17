package stepdefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.CartPage;
import pagefactory.SummerDressesPage;
import pagefactory.TopMenuPage;
import utils.JavascriptUtils;
import webdriver.TestBase;

public class Steps {
	WebDriver webDriver;
	TopMenuPage topMenuPage;
	SummerDressesPage summerDressesPage;
	CartPage cartPage;
	JavascriptUtils javascriptUtils;
	Logger logger = Logger.getLogger(Steps.class.getName());

	@Before
	public void setUp() {
		logger.info("Inside Before Hook");
		webDriver = TestBase.getInstance().getWebDriver();
		topMenuPage = new TopMenuPage(webDriver);
		summerDressesPage = new SummerDressesPage(webDriver);
		cartPage = new CartPage(webDriver);
		javascriptUtils = new JavascriptUtils();
	}

	@After
	public void cleanUp() {
		logger.info("Inside After Hook");
		webDriver.quit();
	}

	@Given("I am on home page")
	public void i_am_on_home_page() {
		logger.info("Opening URL in browser");
		String webSiteURL = System.getProperty("url");
		webDriver.get(webSiteURL);
		logger.info("Home Page title : " + webDriver.getTitle());

	}

	@When("I hover on {string} main menu")
	public void i_hover_on_main_menu(String mainMenuItem) {
		logger.info("mainMenuItem : " + mainMenuItem);
		topMenuPage.hoverOnMainMenu(mainMenuItem);
	}

	@When("I click on {string} sub menu")
	public void i_click_on_sub_menu(String subMenuitem) {
		logger.info("Sub Menu item : " + subMenuitem);
		topMenuPage.clickOnSubMenu(subMenuitem);
		logger.info("Summer Dresses Page Title : " + webDriver.getTitle());
		javascriptUtils.scrollIntoview(webDriver);
	}

	@When("I add first {int} summer dresses to cart")
	public void i_add_first_summer_dresses_to_cart(Integer numberOfSummerDressesToBeAddedTocart) {
	   logger.info("Total Number of dresses to be added to Cart : " + numberOfSummerDressesToBeAddedTocart);
		for(int i=0;i<numberOfSummerDressesToBeAddedTocart;i++) {
			summerDressesPage.addDressToCart(i);
			summerDressesPage.clickContinueShoppingButton();
		}
	}

	
	/*
	 * @When("I add first item to cart") public void i_add_first_item_to_cart() {
	 * 
	 * summerDressesPage.addDressToCart(0);
	 * summerDressesPage.clickContinueShoppingButton(); }
	 * 
	 * @When("I add second item to cart") public void i_add_second_item_to_cart() {
	 * summerDressesPage.addDressToCart(1);
	 * summerDressesPage.clickContinueShoppingButton(); }
	 * 
	 * @When("I add third item to cart") public void i_add_third_item_to_cart() {
	 * summerDressesPage.addDressToCart(2);
	 * summerDressesPage.clickContinueShoppingButton(); }
	 */

	@When("I click on view cart button")
	public void i_click_on_view_cart_button() {
		summerDressesPage.clickViewCartButton();
		logger.info("Cart Page Title : " +  webDriver.getTitle());
	}

	@When("I proceed to checkout")
	public void i_proceed_to_checkout() {
		cartPage.getTheCountOfElementsInCart();
		cartPage.clickProceedToCheckoutButton();
	}

	@Then("I should be asked to sign in")
	public void i_should_be_asked_to_sign_in() {
		String actualSignInPagetitle = webDriver.getTitle();
		logger.info("Actual Sign In Page Title : " +  actualSignInPagetitle);
		String expectedSignInPageTitle = System.getProperty("expected-sigin-page-title");
		Assert.assertEquals(actualSignInPagetitle, expectedSignInPageTitle, "Sign In is not being asked !!");
	}
}
