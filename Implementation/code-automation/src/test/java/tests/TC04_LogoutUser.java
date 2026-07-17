package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.LoadLoginHappyData;
import pages.HomePage;
import pages.LoginPage;

public class TC04_LogoutUser extends TestBase {
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
    public void testUserLogout(String email, String password) throws InterruptedException {
        initializeObjects();

        // تسجيل الدخول الأول كـ Precondition عشان نقدر نعمل Logout
        homeObject.openLoginSignUpPage();
        loginObject.userCanLogin(email, password);
        Assert.assertTrue(loginObject.logoutBtn.isEnabled());

        // الجزء الأساسي: اختبار الـ Logout
        loginObject.userCanLogout();
        Assert.assertEquals(loginObject.loginMsg.getText(), "Login to your account");
    }
}