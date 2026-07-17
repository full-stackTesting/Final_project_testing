package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products_CategoryAnd_Brands extends PageBase{
  public Products_CategoryAnd_Brands(WebDriver driver) {
	  super(driver);	
		}
  @FindBy(css="body > section > div > div.row > div.col-sm-9.padding-right > div > h2")
  public WebElement SucesscategoryHeader;
  
  @FindBy(xpath = "//a[@href='#Women']")
  WebElement WomenCatagory;

  @FindBy(xpath = "//a[contains(text(),'Dress')]")
  WebElement DressSubCatagoryWomen;

  @FindBy(xpath = "//a[contains(text(),'Tops')]")
  WebElement TopsSubCatagory;

  @FindBy(xpath = "//a[contains(text(),'Saree')]")
  WebElement SareeSubCatagory;


  @FindBy(xpath = "//a[@href='#Men']")
  WebElement MenCatagory;

  @FindBy(xpath = "//a[contains(text(),'Tshirts')]")
  WebElement TshirtsSubCatagory;

  @FindBy(xpath = "//a[contains(text(),'Jeans')]")
  WebElement JeansSubCatagory;


  @FindBy(xpath = "//a[@href='#Kids']")
  public WebElement KidsCatagory;

  @FindBy(xpath = "//a[@href='/category_products/4']")
  WebElement DressSubCatagoryKids;

  @FindBy(xpath = "//a[contains(text(),'Tops & Shirts')]")
  WebElement TopsAndShirtsSubCatagory;
  
 
  
  public void userCanOpenWomenCtegoryAndDress() {
   WomenCatagory.click();
   DressSubCatagoryWomen.click();
  }
  
  public void userCanOpenWomenCtegoryAndTops() {
   WomenCatagory.click();
   TopsSubCatagory.click();
  }
  
  public void userCanOpenWomenCtegoryAndSaree() {
   WomenCatagory.click();
   SareeSubCatagory.click();
  }
  
  public void userCanOpenMenCtegoryAndTshirts() {
   MenCatagory.click();
   TshirtsSubCatagory.click();
  }
  
  public void userCanOpenMenCtegoryAndJeans() {
   MenCatagory.click();
   JeansSubCatagory.click();
  }
  
  public void userCanOpenKidsCtegoryAndDress() {
      clickByJS(KidsCatagory);
      clickByJS(DressSubCatagoryKids);
  }

  public void userCanOpenKidsCtegoryAndTops_Shirts() {
      clickByJS(KidsCatagory);
      clickByJS(TopsAndShirtsSubCatagory);
  }
  
 
}