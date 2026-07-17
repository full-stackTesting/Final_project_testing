package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends PageBase{
	
  public RegisterPage(WebDriver driver) {
  super(driver);
 }

  @FindBy(name="name")
  WebElement nameTxt;
  
  @FindBy(css = "#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)")
  WebElement emailTxt;
  
  @FindBy(css="#form > div > div > div:nth-child(3) > div > form > button")
  WebElement signuoBtn;
  
  @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/h2")
   public WebElement RegisterMessage;
  
  @FindBy(css="#form > div > div > div > h2 > b")
 public  WebElement SuccessMassage;
  
  @FindBy(css="#form > div > div > div:nth-child(3) > div > form > p")
  public WebElement errorMassege;

  @FindBy(id="uniform-id_gender2")
  WebElement femaleGenderRadionBtn;
  
  @FindBy(id="password")
  WebElement passwordTxt;
  
  @FindBy(id="days")
  WebElement days;
  
  @FindBy(id="months")
  WebElement months;
  
  @FindBy(id="years")
  WebElement years;
  
  @FindBy(id="newsletter")
  WebElement newsletterCheck;
  
  @FindBy(id="optin")
  WebElement Recivescheck;
  
  @FindBy(id="first_name")
  WebElement firstNameTxt;
  
  @FindBy(id="last_name")
  WebElement lastNameTxt;
  
  @FindBy(id="company")
  WebElement companyTxt;
  
  @FindBy(id="address1")
  WebElement address1Txt;
  
  @FindBy(id="address2")
  WebElement address2Txt;
  
  @FindBy(id="country")
  WebElement countryList;
  
  @FindBy(id="state")
  WebElement stateTxt;
  
  @FindBy(id="city")
  WebElement cityTxt;
  
  @FindBy(id="zipcode")
  WebElement zipcodeTxt;
  
  @FindBy(id="mobile_number")
  WebElement mobileNumberTxt;
  
  @FindBy(css="#form > div > div > div > div > form > button")
  WebElement CreateAccountBtn;
  
  @FindBy(linkText = "Continue")
  WebElement ContinueBtn;
  
  @FindBy(linkText = "Delete Account")
  public WebElement DeleteAccountBtn;
  
  @FindBy(css="#form > div > div > div > h2 > b")
  public WebElement AccountDeletedMassege;
  
  
  public void userCanRegister(String name,String email) {
   nameTxt.sendKeys(name);
   emailTxt.sendKeys(email);
   signuoBtn.click();
  }
  
  public void userCanEnterAccountInformation(String password,String day,String month,String year,String firstName,String lastName,String Company,
    String Address,String Address2,String country,String state, String city,String zipCode, String MobileNumber) {
   femaleGenderRadionBtn.click();
   
   passwordTxt.sendKeys(password);
   
   Select makeDaysList=new Select(days);
   makeDaysList.selectByContainsVisibleText(day);
   
   Select makeMonthsList=new Select(months);
   makeMonthsList.selectByContainsVisibleText(month);
   
   Select makeYearsList=new Select(years);
   makeYearsList.selectByContainsVisibleText(year);
   
   newsletterCheck.click();
   
   Recivescheck.click();
   
   firstNameTxt.sendKeys(firstName);
   
   lastNameTxt.sendKeys(lastName);
   
   companyTxt.sendKeys(Company);
   
   address1Txt.sendKeys(Address); 
   
   address2Txt.sendKeys(Address2);
   
   Select makeCountryList =new Select(countryList);
   makeCountryList.selectByValue(country);
   
   stateTxt.sendKeys(state);
   
   cityTxt.sendKeys(city);
   
   zipcodeTxt.sendKeys(zipCode);
   
   mobileNumberTxt.sendKeys(MobileNumber);
   
   CreateAccountBtn.click();
   
   
  }
  public void userCanEnterAccountInformation(String password,String firstName,String lastName,
    String Address,String country,String state, String city,String zipCode, String MobileNumber) {
   
   passwordTxt.sendKeys(password);
   
   firstNameTxt.sendKeys(firstName);
   
   lastNameTxt.sendKeys(lastName);
   
   
   address1Txt.sendKeys(Address); 
   
   
   Select makeCountryList =new Select(countryList);
   makeCountryList.selectByValue(country);
   
   stateTxt.sendKeys(state);
   
   cityTxt.sendKeys(city);
   
   zipcodeTxt.sendKeys(zipCode);
   
   mobileNumberTxt.sendKeys(MobileNumber);
CreateAccountBtn.click();
   
   
  }
  
  public void userCanContinueeAccount() {
   ContinueBtn.click();
 
}
  public void userCanDeleteAccount() {
   DeleteAccountBtn.click();
 
}
  
  
}