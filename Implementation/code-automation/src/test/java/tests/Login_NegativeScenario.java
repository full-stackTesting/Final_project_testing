package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.LoadLoginNegativeData;
import pages.HomePage;
import pages.LoginPage;

public class Login_NegativeScenario extends TestBase {
	HomePage homeObject;
	LoginPage loginObject;
	
	public void initializeObjects() {
		homeObject = new HomePage(driver);
		loginObject = new LoginPage(driver);
	}
	
	
	@DataProvider(name = "loginNegativeData")
	public Object[][] getLoginNegativeData() throws IOException {
		return LoadLoginNegativeData.getLoginNegativeData();
	}
	
	int count = 0;
	
  @Test(dataProvider = "loginNegativeData")
  public void testLogin_IcorrectData(String email, String password) throws InterruptedException {
	  initializeObjects();
	  if(count == 0)
	  Assert.assertEquals(homeObject.homePageBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");
	  homeObject.openLoginSignUpPage();
	  Assert.assertEquals(loginObject.loginMsg.getText(), "Login to your account");
	  loginObject.userCanLogin(email,password);
	  Assert.assertEquals(loginObject.errorMsg.getText(), "Your email or password is incorrect!");
	  count++;

  }
}