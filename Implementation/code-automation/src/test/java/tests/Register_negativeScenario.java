package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.LoadRegisterNegativeDataExcel;
import pages.HomePage;
import pages.RegisterPage;

public class Register_negativeScenario extends TestBase {
 HomePage homeObj;
 RegisterPage registerObj;
 public void initializeObj() {
   homeObj =new HomePage(driver);
    registerObj=new RegisterPage(driver);
 }
  @DataProvider(name="RegisterNegativeData")
  public Object[][] getRegisterNegativeData() throws IOException {
  return LoadRegisterNegativeDataExcel.getRegisterNegativeData();
  }
  @Test(dataProvider = "RegisterNegativeData")
  public void testRegister_NameWithExistingEmail (String name,String email) throws InterruptedException {
  initializeObj();
  homeObj.openLoginSignUpPage();
  Assert.assertEquals(registerObj.RegisterMessage.getText(),"New User Signup!");
  registerObj.userCanRegister(name,email);
  
     Assert.assertTrue(registerObj.errorMassege.getText().equalsIgnoreCase("Email Address already exist!"));
  

  }
}