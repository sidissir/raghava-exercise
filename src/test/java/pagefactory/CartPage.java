package pagefactory;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver.TestBase;

public class CartPage {

	Logger logger = Logger.getLogger(CartPage.class.getName());

	public CartPage(WebDriver webDriver){
		PageFactory.initElements(webDriver, this);
		logger.info("CartPage Instantiated");
	}
	
	@FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr")
	public List<WebElement> elementsInCart;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
	public WebElement proceedToCheckoutButtonElement;
	
	public int getTheCountOfElementsInCart() {
		logger.info("Elements in the cart : " + elementsInCart.size());
		return elementsInCart.size();
	}
	
	public void clickProceedToCheckoutButton() {
		proceedToCheckoutButtonElement.click();
		logger.info("Proceed to Check out button clicked");
	}
	
}
