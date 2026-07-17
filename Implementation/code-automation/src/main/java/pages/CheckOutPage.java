package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageBase{
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="address_delivery")
	public WebElement address_Delivery;
	
	@FindBy(id = "address_invoice")
	public WebElement address_invoice;
	
	@FindBy(className = "form-control")
	WebElement commentBox;
	
	@FindBy(linkText = "Place Order")
	WebElement PlaceOrderBtn;
	
	@FindBy(linkText = "Delete Account")
	WebElement deletAccBtn;
	
	  @FindBy(linkText = "Continue")
	  WebElement ContinueDeletBtn;
	  
	  @FindBy(css = "a.btn.btn-default.check_out")
	  WebElement downloadInvoiceBtn;

	
	  public void useraddComment(String comment){

	        commentBox.sendKeys(comment);

	    }

	    public void userplaceOrder(){

	       PlaceOrderBtn.click();

	    }
	    
	    public void userdeleteAccount() {
			deletAccBtn.click();
			ContinueDeletBtn.click();
		
		}
	    
	    public void clickDownloadInvoice() {
	        downloadInvoiceBtn.click();
	    }
	
	

}
