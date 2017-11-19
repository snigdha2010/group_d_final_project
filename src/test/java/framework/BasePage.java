package framework;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import stepdefinition.SharedSD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mohammadmuntakim on 6/9/17.
 */
public class BasePage {


	private static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(java.util.NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementNotFoundException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public void clickOn(By locator) {
		try {
			webAction(locator).click();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public void sendText(By locator, String text) {
		try {
			webAction(locator).sendKeys(text);
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}
	}

	public String getTextFromElement(By locator) {
		String text = null;
		try {
			text = webAction(locator).getText();
		} catch (NoSuchElementException e) {
			Assert.fail("Element is not found with this locator: " + locator.toString());
			e.printStackTrace();
		}

		return text;
	}

	public void selectAutoComplete(By autoCompleteTextField, String partialText, By suggestedList, String valueToBeSelected) {
		webAction(autoCompleteTextField).sendKeys(partialText);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Fluent wait is not implemented here
		List<WebElement> list = SharedSD.getDriver().findElements(suggestedList);
		for (WebElement ele : list) {
			if (ele.getText().contains(valueToBeSelected)) {
				ele.click();
				break;
			}
		}
	}

	public void selectCurrentDateFromCalender(String datePattern, By calendarField, By listOfDays) {
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		Date date = new Date();
		String todayDate = sdf.format(date);

		webAction(calendarField).click();
		//Fluent wait is not implemented here
		List<WebElement> days = SharedSD.getDriver().findElements(listOfDays);

		for (WebElement day : days) {
			String expectedDay = day.getText();
			if (expectedDay.equals(todayDate)) {
				day.click();
				break;
			}
		}
	}

	public void selectReturnDateFromCalender(String datePattern, By calendarField,int amountToAdd, By listOfDays) {
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		Date date = new Date();
		//add days to current date
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE,amountToAdd); // 7 is the days you want to add or subtract
		date = cal.getTime();
		String endDate = sdf.format(date);


		webAction(calendarField).click();
		//Fluent wait is not implemented here
		List<WebElement> days = SharedSD.getDriver().findElements(listOfDays);

		for (WebElement day : days) {
			String expectedDay = day.getText();
			if (expectedDay.contains(endDate)) {
				day.click();
				break;
			}

		}
	}

	public void selectAnyDateFromCalender(By calendarField, By listOfDays, String dateToSelect) throws InterruptedException {


		webAction(calendarField).click();
		//Fluent wait is not implemented here
		Thread.sleep(3000);
		List<WebElement> days = SharedSD.getDriver().findElements(listOfDays);

		for (WebElement day : days) {
			String expectedDay = day.getText();
			if (expectedDay.equals(dateToSelect)) {
				day.click();
				break;
			}

		}
	}

	public void selectFromDropDown(By dropdownField, String visibleText) {
		// Select value from drop
		Select dropdown = new Select(webAction(dropdownField));
		// Select element by visible text
		dropdown.selectByVisibleText(visibleText);
	}

	public void selectFromDropDown(By dropdownField, int index) {
		// Select value from drop
		Select dropdown = new Select(webAction(dropdownField));
		// Select element by index
		dropdown.selectByIndex(index);
	}


	public void mouseOver(By hoverOverElement) {
		WebElement element = webAction(hoverOverElement);
		Actions action = new Actions(SharedSD.getDriver());
		action.moveToElement(element).build().perform();
	}

	// Switches to window based of index
	public static void switchToWidnow(int index) {

		List<String> listOfWindows = new ArrayList<String>(SharedSD.getDriver().getWindowHandles());
		SharedSD.getDriver().switchTo().window(listOfWindows.get(index));
	}

	// Closes current window and switches back to root window
	public static void switchToRootWindowAndCloseCurrentBrowser() {
		List<String> listOfWindows = new ArrayList<String>(SharedSD.getDriver().getWindowHandles());

		for(int i = 1; i < listOfWindows.size(); i++){
			SharedSD.getDriver().switchTo().window(listOfWindows.get(i));
			SharedSD.getDriver().close();
		}
		SharedSD.getDriver().switchTo().window(listOfWindows.get(0));
	}
	public void clickOnBrowserBackArrow() {
		SharedSD.getDriver().navigate().back();
	}

	public void clickOnBrowserForwardArrow() {
		SharedSD.getDriver().navigate().forward();
	}

	public void refreshBrowser() {
		SharedSD.getDriver().navigate().refresh();
	}
}
