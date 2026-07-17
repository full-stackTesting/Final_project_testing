package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageBase{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Signup / Login")
	WebElement loginbtn;
	
	@FindBy(xpath = "//a[@href='/products']")
	WebElement productsBtn;
	
	@FindBy(linkText = "Home")
	public WebElement homePageBtn;
	
	@FindBy(linkText = "Cart")
	public WebElement cartBtn;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsBtn;
	
	@FindBy(linkText = "Logout")
	WebElement logoutBtn;
	
	@FindBy(linkText = "Delete Account")
	WebElement deletAccBtn;
	
	  @FindBy(linkText = "Continue")
	  WebElement ContinueDeletBtn;
	
	  @FindBy(linkText = "Test Cases")
	  WebElement testBtn;
	  
	  @FindBy(linkText = "Home")
	  WebElement homeBtn;
	  
	  @FindBy(xpath = "//a[contains(.,'Logged in as')]")
	  public WebElement loggedInAsUsername;

	  // ===== الإضافات الجديدة (Scroll Up/Down) =====
	  @FindBy(css = "h2.title.text-center")
	  WebElement subscriptionTitle;

	  @FindBy(xpath = "//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]")
	  WebElement fullFledgedText;

	  @FindBy(id = "scrollUp")
	  WebElement scrollUpArrow;
	  // ================================================
	  
	public void openLoginSignUpPage() {
		loginbtn.click();
	}
	
	public void openProductsPage() {
	    wait.until(ExpectedConditions.elementToBeClickable(productsBtn));
	    try {
	        productsBtn.click();
	    } catch (Exception e) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", productsBtn);
	    }
	}
	public void opencartPage() {
		cartBtn.click();
	}
    public void usercanlogout() {
		logoutBtn.click();
	}
		  
    public void usercandeletAcc() {
		deletAccBtn.click();
		ContinueDeletBtn.click();
	}
		 
   public void userOpenTestCasesPage() {
	testBtn.click();
   }
   
   public void openContactUsPage() {
		contactUsBtn.click();
   }
   public void openHomePage() {
		homeBtn.click();
   }

   // ===== الإضافات الجديدة (Scroll Up/Down) =====
   public void scrollToBottom() {
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
   }

   public boolean isSubscriptionVisible() {
       wait.until(ExpectedConditions.visibilityOf(subscriptionTitle));
       return subscriptionTitle.isDisplayed();
   }

   public void clickScrollUpArrow() {
       wait.until(ExpectedConditions.elementToBeClickable(scrollUpArrow));
       scrollUpArrow.click();
   }

   public void scrollToTopUsingJS() {
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollTo(0, 0);");
   }

   public boolean isFullFledgedTextVisible() {
       wait.until(ExpectedConditions.visibilityOf(fullFledgedText));
       return fullFledgedText.isDisplayed();
   }
   // ================================================
		  
}