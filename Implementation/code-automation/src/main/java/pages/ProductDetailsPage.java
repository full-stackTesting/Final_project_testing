package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

    JavascriptExecutor js;
    Actions actions;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    @FindBy(xpath = "//a[@href='/products']")
    WebElement productsBtn;

    @FindBy(xpath = "(//div[@class='product-image-wrapper'])[1]")
    WebElement firstProduct;

    @FindBy(xpath = "(//div[@class='product-image-wrapper'])[2]")
    WebElement secondProduct;

    @FindBy(xpath = "//a[@data-product-id='1']")
    WebElement firstAddCart;

    @FindBy(xpath = "//a[@data-product-id='2']")
    WebElement secondAddCart;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement continueShopping;

    @FindBy(xpath = "//u[text()='View Cart']")
    WebElement viewCart;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    WebElement firstViewProduct;

    @FindBy(id = "quantity")
    WebElement quantityTxt;

    @FindBy(xpath = "//button[contains(@class,'cart')]")
    WebElement addToCartBtn;

    public void openProductsPage() {
        js.executeScript("arguments[0].click();", productsBtn);
    }

    public void addFirstProduct() {
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", firstProduct);
        actions.moveToElement(firstProduct).perform();
        js.executeScript("arguments[0].click();", firstAddCart);
    }

    public void addSecondProduct() {
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", secondProduct);
        actions.moveToElement(secondProduct).perform();
        js.executeScript("arguments[0].click();", secondAddCart);
    }

    public void continueShopping() {
        continueShopping.click();
    }

    public void openCart() {
        viewCart.click();
    }

    public void openFirstProductDetails() {
        js.executeScript("arguments[0].click();", firstViewProduct);
    }

    public void changeQuantity(String quantity) {
        quantityTxt.clear();
        quantityTxt.sendKeys(quantity);
    }

    public void addCurrentProductToCart() {
        js.executeScript("arguments[0].click();", addToCartBtn);
    }
}