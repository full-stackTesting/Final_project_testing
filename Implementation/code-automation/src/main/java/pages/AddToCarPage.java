package pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCarPage extends PageBase {

    WebDriverWait wait;
    JavascriptExecutor js;

    public AddToCarPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
    }

    @FindBy(css = "a.add-to-cart[data-product-id='1']")
    WebElement firstProductBtn;

    @FindBy(css = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div:nth-child(3) > div > div.single-products")
    WebElement firstProductContainer;

    @FindBy(css = "#cartModal .modal-footer button")
    WebElement continueShoppingBtn;

    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")
    WebElement viewCartBtn;
    
    @FindBy(css = "div.features_items div.product-image-wrapper:first-of-type a.add-to-cart")
    WebElement firstSearchedProductBtn;

    @FindBy(css = "div.features_items div.product-image-wrapper:first-of-type")
    WebElement firstSearchedProductContainer;

    public void userSelectFirstSearchedProduct() {

        js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            firstSearchedProductContainer);

        Actions actions = new Actions(driver);
        actions.moveToElement(firstSearchedProductContainer).perform();

        wait.until(ExpectedConditions.elementToBeClickable(firstSearchedProductBtn));

        try {
            firstSearchedProductBtn.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", firstSearchedProductBtn);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal")));
    }

    public void userSelectProduct() {
        js.executeScript("arguments[0].scrollIntoView({behavior:'instant', block:'start'});", firstProductContainer);

        Actions actions = new Actions(driver);
        actions.moveToElement(firstProductContainer).perform();

        wait.until(ExpectedConditions.elementToBeClickable(firstProductBtn));

        try {
            firstProductBtn.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", firstProductBtn);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal")));
    }

    public void userContinueShopping() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn)).click();
    }

    public void userViewCart() {

        wait.until(ExpectedConditions.visibilityOf(viewCartBtn));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", viewCartBtn);

        try {

            wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn));
            viewCartBtn.click();

        } catch (Exception e) {

            js.executeScript("arguments[0].click();", viewCartBtn);

        }
    }
}