package tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.LoadRegisterHappyDataExcel;
import pages.HomePage;
import pages.RegisterPage;

public class Register_happyScenario extends TestBase {
 HomePage homeObj;
 RegisterPage registerObj;
 
 public void initializeObj() {
   homeObj =new HomePage(driver);
    registerObj=new RegisterPage(driver);
 }
 @DataProvider(name="RegisterHappyData")
   public Object[][] getRegisterHappyData() throws IOException {
   return LoadRegisterHappyDataExcel.getRegisterHappyData();
   }
  @Test(dataProvider = "RegisterHappyData")
  public void testRegister_vaildMandatoryAndOptionalFields (String name,String email,String password,String day,String month,String year,String firstName,
    String lastName,String Company,String Address,String Address2,String country,String state, String city,String zipCode, String MobileNumber)  {
  initializeObj();
  homeObj.openLoginSignUpPage();
  Assert.assertEquals(registerObj.RegisterMessage.getText(),"New User Signup!");
  
  registerObj.userCanRegister(name,email);
  registerObj.userCanEnterAccountInformation(password,day, month, year,firstName, lastName, Company, Address, Address2, country, state,city, zipCode,MobileNumber);
  Assert.assertTrue(registerObj.SuccessMassage.getText().equalsIgnoreCase("Account Created!"));
  
  
  registerObj.userCanContinueeAccount();
  Assert.assertTrue(registerObj.DeleteAccountBtn.isEnabled());
  
  
  registerObj.userCanDeleteAccount();
  Assert.assertTrue(registerObj.AccountDeletedMassege.getText().equalsIgnoreCase("Account Deleted!"));
  
  registerObj.userCanContinueeAccount();
  }
  

  
}