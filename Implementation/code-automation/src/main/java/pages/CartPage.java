package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase{
	public CartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Proceed To Checkout")
	WebElement ProceedtoCheckoutBtn;
	
	@FindBy(linkText = "Continue On Cart")
	WebElement ContinueOnCartBtn;
	
	@FindBy(linkText = "Register / Login")
	WebElement RegAndLoginBtn;
	
	public void userProceedToCheckout() {
		ProceedtoCheckoutBtn.click();
	}
	
	public void userContinouCart() {
		ContinueOnCartBtn.click();
	}
	
	public void userRegisterOrLogin() {
		RegAndLoginBtn.click();
	}

}
