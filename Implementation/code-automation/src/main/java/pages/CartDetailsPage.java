package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartDetailsPage extends PageBase {

    JavascriptExecutor js;

    public CartDetailsPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//a[@href='/view_cart']")
    WebElement cartBtn;

    @FindBy(xpath = "//table[@id='cart_info_table']//tbody/tr")
    List<WebElement> cartItems;

    @FindBy(className = "cart_quantity_delete")
    WebElement deleteBtn;

    @FindBy(xpath = "//td[@class='cart_quantity']//button")
    WebElement quantity;

    @FindBy(xpath = "(//td[@class='cart_price'])[1]")
    WebElement firstPrice;

    @FindBy(xpath = "(//td[@class='cart_total'])[1]")
    WebElement firstTotal;

    @FindBy(xpath = "(//td[@class='cart_price'])[2]")
    WebElement secondPrice;

    @FindBy(xpath = "(//td[@class='cart_total'])[2]")
    WebElement secondTotal;

    public void openCartPage() {
        js.executeScript("arguments[0].click();", cartBtn);
    }

    public int getProductsCount() {
        return cartItems.size();
    }

    public String getQuantity() {
        return quantity.getText();
    }

    public boolean firstProductPriceDisplayed() {
        return firstPrice.isDisplayed();
    }

    public boolean firstProductTotalDisplayed() {
        return firstTotal.isDisplayed();
    }

    public boolean secondProductPriceDisplayed() {
        return secondPrice.isDisplayed();
    }

    public boolean secondProductTotalDisplayed() {
        return secondTotal.isDisplayed();
    }

    public void removeProduct() {
        js.executeScript("arguments[0].click();", deleteBtn);
    }
}