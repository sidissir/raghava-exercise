package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavascriptUtils {

	public void scrollIntoview(WebDriver webDriver) {
		JavascriptExecutor js = (JavascriptExecutor)webDriver;
		js.executeScript("window.scrollBy(0,500)");	}
}
