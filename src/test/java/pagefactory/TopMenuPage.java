package pagefactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuPage {

	Actions actions;
	WebDriverWait wait;
	Logger logger = Logger.getLogger(TopMenuPage.class.getName());

	
	public TopMenuPage(WebDriver webDriver){
		PageFactory.initElements(webDriver, this);
		actions = new Actions(webDriver);
		wait = new WebDriverWait(webDriver, 5000);
		logger.info("TopMenuPage Instantiated");
	}
	
	//WebElement dressesMenuElement = webDriver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]"));

	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]")
	public WebElement dressesMenuElement;
	
	@FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[3]/a")
	public WebElement summerDressesElement;
	
	
	
	
	public void hoverOnMainMenu(String mainMenuItem) {
		if(mainMenuItem.equalsIgnoreCase("Dresses")) {
			actions.moveToElement(dressesMenuElement).build().perform();
			logger.info("Hovered on Dresses Menu");
		}
	}
	
	public void clickOnSubMenu(String subMenuItem) {
		if(subMenuItem.equalsIgnoreCase("Summer Dresses")) {
			wait.until(ExpectedConditions.elementToBeClickable(summerDressesElement));
			summerDressesElement.click();
			logger.info("Clicked on Summer Dresses sub Menu");

		}
	}
	
	
}
