package pages;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends PageBase {
	
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
	}
	@FindBy(name = "name_on_card")
	WebElement nameOnCardTxt;
	
	@FindBy(name="card_number")
	WebElement cardNumberTxt;
	
	@FindBy(name = "cvc")
	WebElement cvcTxt;
	
	@FindBy(name="expiry_month")
	WebElement expiryMonthTxt;
	 
	@FindBy(name = "expiry_year")
	WebElement expiryYearTxt;
	
	@FindBy(id = "submit")
	WebElement payBtn;
	
	
	@FindBy(css = "#form > div > div > div > h2 > b")
	public WebElement orderPlacedMsg;
	
	@FindBy(linkText = "Continue")
	WebElement continewBtn;
	
	public void userEnterpaymentInfo(String name , String cardNum , String cvc , String expiryMonth, String expiryYear ) {
		wait.until(ExpectedConditions.visibilityOf(nameOnCardTxt));
		
		nameOnCardTxt.sendKeys(name);
		cardNumberTxt.sendKeys(cardNum);
		cvcTxt.sendKeys(cvc);
		expiryMonthTxt.sendKeys(expiryMonth);
		expiryYearTxt.sendKeys(expiryYear);
		
		js.executeScript("arguments[0].scrollIntoView({behavior:'instant', block:'center'});", payBtn);
		
		wait.until(ExpectedConditions.elementToBeClickable(payBtn));
		
		try {
			payBtn.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", payBtn);
		}
		
		wait.until(ExpectedConditions.visibilityOf(orderPlacedMsg));
		
	
		
	}
	public void usercontinue() {
		continewBtn.click();
	}
	
}