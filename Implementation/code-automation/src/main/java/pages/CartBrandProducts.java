package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartBrandProducts  extends PageBase {
 
     public CartBrandProducts(WebDriver driver) {
  super(driver);
 }

 
     @FindBy(css = ".brands_products h2")
     public WebElement brandsTitle;

     @FindBy(xpath = "//a[contains(@href,'/brand_products/Polo')]")
     WebElement polo;

     @FindBy(xpath = "//a[contains(@href,'/brand_products/H&M')]")
     WebElement hm;

     @FindBy(xpath = "//a[contains(@href,'/brand_products/Madame')]")
     WebElement madame;

     @FindBy(xpath = "//a[contains(@href,'/brand_products/Mast & Harbour')]")
     WebElement mastHarbour;

     @FindBy(xpath = "//a[contains(@href,'/brand_products/Babyhug')]")
     WebElement babyhug;

     @FindBy(xpath = "//a[contains(@href,'/brand_products/Allen Solly Junior')]")
     WebElement allenSollyJunior;

     @FindBy(xpath = "//a[contains(@href,'/brand_products/Kookie Kids')]")
     WebElement kookieKids;

     @FindBy(xpath = "//a[contains(@href,'/brand_products/Biba')]")
     WebElement biba;

     @FindBy(css = ".title.text-center")
     public WebElement successHeader;

     public void openPolo() {
         clickByJS(polo);
     }

     public void openHM() {
         clickByJS(hm);
     }

     public void openMadame() {
         clickByJS(madame);
     }

     public void openMastHarbour() {
         clickByJS(mastHarbour);
     }

     public void openBabyhug() {
         clickByJS(babyhug);
     }

     public void openAllenSollyJunior() {
         clickByJS(allenSollyJunior);
     }

     public void openKookieKids() {
         clickByJS(kookieKids);
     }

     public void openBiba() {
         clickByJS(biba);
     }
}