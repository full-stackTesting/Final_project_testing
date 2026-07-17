package pages;
//Done 
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageBase {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "email")
	WebElement emailTxt;
	
	@FindBy(name = "password")
	WebElement passtxt;
	
	@FindBy(css= "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button")
	WebElement loginBtn;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/h2")
	public WebElement loginMsg;
	
	@FindBy(xpath  = "//*[@id=\"form\"]/div/div/div[1]/div/form/p")
	public WebElement errorMsg;
	
	@FindBy(linkText = "Logout")
	public WebElement logoutBtn;
	
	public void userCanLogin(String email, String password) {
		emailTxt.sendKeys(email);
		passtxt.sendKeys(password);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
	}
	
	public void userCanLogout() {
		logoutBtn.click();
	}
}