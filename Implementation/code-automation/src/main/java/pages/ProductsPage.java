package pages;
//Done 
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends PageBase {
	public WebDriverWait wait;
	public JavascriptExecutor js;

	public ProductsPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
	}

	// تم توحيد اللوكيتور ده مع searchedProductsMsg لأنه نفس العنصر بالظبط
	// (h2.title جوه div.features_items) والنص بيتغير حسب حالة الصفحة
	@FindBy(css = "div.features_items h2.title")
	public WebElement allProductsMsg;

	@FindBy(css = "div.features_items div.col-sm-4")
	public List<WebElement> productList;

	@FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div:nth-child(3) > div > div.choose > ul > li > a")
	WebElement viewFirstProduct;

	@FindBy(css = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > h2")
	public WebElement productName;

	@FindBy(css = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > span")
	public WebElement productPrice;

	@FindBy(css = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > p:nth-child(3)")
	public WebElement productCategory;

	@FindBy(css = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > p:nth-child(6)")
	public WebElement productAvailability;

	@FindBy(css = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > p:nth-child(7)")
	public WebElement productCondition;

	@FindBy(css = "body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > p:nth-child(8)")
	public WebElement productBrand;

	@FindBy(id = "search_product")
	WebElement searchBox;
	@FindBy(id = "search_product")
	public WebElement searchInput;
	@FindBy(id = "submit_search")
	public WebElement searchBtn;
	@FindBy(css = "div.features_items h2.title")
	public WebElement searchedProductsMsg;
	@FindBy(css = "div.features_items div.col-sm-4")
	public List<WebElement> searchResults;

	@FindBy(css = "a[href='#reviews']")
	public WebElement writeReviewTab;
	@FindBy(id = "name")
	public WebElement reviewName;
	@FindBy(id = "email")
	public WebElement reviewEmail;
	@FindBy(id = "review")
	public WebElement reviewText;
	@FindBy(id = "button-review")
	public WebElement submitReviewBtn;
	@FindBy(css = "div.alert-success span")
	public WebElement reviewSuccessMsg;

	public void scrollToSearchBox() {
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", searchBox);
	}

	public void viewFirstProductPage() {
		wait.until(ExpectedConditions.visibilityOf(viewFirstProduct));
		js.executeScript("arguments[0].click();", viewFirstProduct);
		wait.until(ExpectedConditions.visibilityOf(productName));
	}

	public void searchForProduct(String productName) {
	    wait.until(ExpectedConditions.visibilityOf(searchInput));
	    searchInput.sendKeys(productName);
	    js.executeScript("arguments[0].click();", searchBtn);

	    // استني لحد ما النص يحتوي فعليًا على "Searched Products" (مع تجاهل المسافات الزيادة)
	    wait.until(driver -> {
	        String text = searchedProductsMsg.getText();
	        return text != null && text.trim().equalsIgnoreCase("Searched Products");
	    });
	}

	public void submitReview(String name, String email, String review) {
		wait.until(ExpectedConditions.visibilityOf(reviewName));
		reviewName.sendKeys(name);
		reviewEmail.sendKeys(email);
		reviewText.sendKeys(review);
		js.executeScript("arguments[0].click();", submitReviewBtn);
		wait.until(ExpectedConditions.visibilityOf(reviewSuccessMsg));
	}
}