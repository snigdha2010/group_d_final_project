package framework;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

	private By pageHeader = By.xpath(".//*[@id='no-results']");

	public String getPageHeader() {

		return getTextFromElement(pageHeader);
	}

	private By result = By.xpath(".//*[@id='trip-summary']/dl/dd[1]");

	public String getResult() {

		return getTextFromElement(result);
	}
}
