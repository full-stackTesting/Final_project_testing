package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.LoadLoginHappyData;
import pages.HomePage;
import pages.LoginPage;

public class Login_happyScenario extends TestBase {
	HomePage homeObject;
	LoginPage loginObject;
	
	public void initializeObjects() {
		homeObject = new HomePage(driver);
		loginObject = new LoginPage(driver);
	}
	
	
	@DataProvider(name = "loginHappyData")
	public Object[][] getLoginHappyData() throws IOException {
		return LoadLoginHappyData.getLoginHappyData();
	}
  @Test(dataProvider = "loginHappyData")
  public void testLogin_CorrectUsernameAndMatchingPassword(String email, String password) throws InterruptedException {
	  initializeObjects();
	  Assert.assertEquals(homeObject.homePageBtn.getCssValue("color"), "rgba(255, 165, 0, 1)");
	  homeObject.openLoginSignUpPage();
	  Assert.assertEquals(loginObject.loginMsg.getText(), "Login to your account");

	  loginObject.userCanLogin(email,password);
	  Assert.assertTrue(loginObject.logoutBtn.isEnabled());

	  loginObject.userCanLogout();
	  Assert.assertEquals(loginObject.loginMsg.getText(), "Login to your account");

  }
}