package pagefactory;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummerDressesPage {

	Actions actions;
	WebDriverWait wait;
	Logger logger = Logger.getLogger(SummerDressesPage.class.getName());

	public SummerDressesPage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
		actions = new Actions(webDriver);
		wait = new WebDriverWait(webDriver, 5);
		logger.info("SummerDressesPage Instantiated");

	}

	@FindBy(xpath = "//*[@class=\"product-container\"]")
	public List<WebElement> allSummerDressesElements;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")
	public WebElement continueShoppingButtonElement;

	@FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
	public WebElement viewCartButtonElement;

	public void addDressToCart(int index) {
		logger.info("Adding element : " + index);
		WebElement eachSummerDressElement = allSummerDressesElements.get(index);
		actions.moveToElement(eachSummerDressElement).build().perform();
		WebElement addToCartButtonElement = eachSummerDressElement
				.findElement(By.cssSelector("a[title*='Add to cart']"));
		// WebElement addToCartButtonElement =
		// wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(eachSummerDressElement,
		// By.cssSelector("a[title*='Add to cart']")));
		addToCartButtonElement.click();
	}

	public void clickContinueShoppingButton() {
		continueShoppingButtonElement.click();

	}

	public void clickViewCartButton() {
		viewCartButtonElement.click();
		logger.info("View Cart button clicked");
	}

}
