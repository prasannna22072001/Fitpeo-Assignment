package Fitpeo.Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase extends BaseTest {

	@Test
	public void testcase1() throws InterruptedException {

		String expected = "823";
		String number = "560";

		WebElements WebA = new WebElements(driver);

		// Navigate to the Revenue Calculator Page:
		WebElement RevenuePage = WebA.revenuepageWebElement();
		RevenuePage.click();

		// Scroll Down to the Slider section:
		WebElement scrollBarElement = WebA.scrollBarWebElement();
		Actions actions = new Actions(driver);
		actions.moveToElement(scrollBarElement).build().perform();

		// Adjust the Slider
		WebElement sliderElement = WebA.SlideBarWebElement();
		actions.dragAndDropBy(sliderElement, (int) 94, 0).build().perform();
		WebElement value = WebA.ValueIs();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String text = (String) js.executeScript("return arguments[0].value;", value);
		Assert.assertEquals(text, expected); // here i used assertion to validate the actual and expected values

		// Update the Text Field:
		value.sendKeys(Keys.CONTROL, "a");
		value.sendKeys(Keys.BACK_SPACE); // we can use Keys.DELETE
		value.sendKeys(number);

		// Validate Slider Value:
		String sliderValue = sliderElement.getAttribute("value");
		Assert.assertEquals(sliderValue, number);

		//Select CPT Codes:
		List<WebElement> cpt = WebA.CPT();

		String[] CPTlabels = { "CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474" };

		for (int i = 0; i <= 3; i++) {
			String Singlelables = CPTlabels[i];
			WebElement CPTbox = cpt.stream().filter(e -> e.getText().equalsIgnoreCase(Singlelables)).findFirst()  //used the concept of streams in java for more dynamic approach
					.orElse(null);
			CPTbox.findElement(By.xpath("following-sibling::label/span[1]")).click();
		}
		
		
		// Verify that the header displaying
		WebElement cost = WebA.Reimbursement();
		String TotalCost = cost.getText();
		String result = TotalCost.replace("$", ""); /// removed dollar sign with ".replace" method in java

		System.out.println(result);

		Assert.assertEquals(result, "75600");
	
	}

}
