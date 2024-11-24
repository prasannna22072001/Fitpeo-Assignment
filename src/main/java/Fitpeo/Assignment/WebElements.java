package Fitpeo.Assignment;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebElements extends WaitMethods {

	WebDriver driver;

	public WebElements(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/// i used the PageFactory concept for creating WebElements

	@FindBy(xpath = "//a[@href='/revenue-calculator']")
	WebElement RevenuePage;

	@FindBy(xpath = "//p[.='Total Recurring Reimbursement for all Patients Per Month']")
	WebElement scrollBar;

	@FindBy(xpath = "//input[@type='number']")
	WebElement value;

	@FindBy(xpath = "//input[@aria-orientation='horizontal']")
	WebElement slide;

	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 inter css-1s3unkt']")
	List<WebElement> CPTcodes;

	@FindBy(xpath = "//p[contains(.,'Total Recurring Reimbursement for all Patients Per Month:')]/p")
	WebElement TotalCost;

	public WebElement revenuepageWebElement() {

		return RevenuePage;
	}

	public WebElement scrollBarWebElement() {
		waitForElementToAppear(scrollBar); // here i used explicit wait where the code is provided in "WaitMethods"
											// class
		return scrollBar;
	}

	public WebElement SlideBarWebElement() {

		return slide;
	}

	public WebElement ValueIs() {
		return value;
	}

	public List<WebElement> CPT() {

		return CPTcodes;
	}

	public WebElement Reimbursement() {
		return TotalCost;
	}
}
