package tests;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddToCarPage;
import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ProductsPage;
import pages.RegisterPage;

public class TC16_LoginBeforeCheckout extends TestBase {
	HomePage homeobj;
	RegisterPage regObj;
	CartPage cartObj;
	ProductsPage productObj;
	CheckOutPage checkoutObj;
	PaymentPage paymentObj;
	AddToCarPage addpageObj;
	LoginPage loginobj;

	public void initializeObjects() {
		homeobj = new HomePage(driver);
		productObj = new ProductsPage(driver);
		cartObj = new CartPage(driver);
		regObj = new RegisterPage(driver);
		checkoutObj = new CheckOutPage(driver);
		paymentObj = new PaymentPage(driver);
		addpageObj = new AddToCarPage(driver);
		loginobj = new LoginPage(driver);
	}

	@DataProvider(name = "loginCheckoutData")
	public Object[][] getLoginCheckoutData() throws IOException {

	    String filePath = System.getProperty("user.dir") + "/src/test/java/excelFile/data.xlsx";

	    FileInputStream stream = new FileInputStream(filePath);

	    XSSFWorkbook workBook = new XSSFWorkbook(stream);

	    XSSFSheet loginSheet = workBook.getSheet("Login Happy");
	    XSSFSheet paymentSheet = workBook.getSheet("Payment");

	    int nRows = loginSheet.getLastRowNum() + 1;

	    int loginCols = 2;      // Email + Password
	    int paymentCols = 5;    // Card Name + Card Number + CVC + Month + Year
	    int totalCols = loginCols + paymentCols;

	    Object[][] fullData = new Object[nRows][totalCols];

	    DataFormatter formatter = new DataFormatter();

	    for (int i = 0; i < nRows; i++) {

	        XSSFRow loginRow = loginSheet.getRow(i);

	        for (int j = 0; j < loginCols; j++) {
	            fullData[i][j] = formatter.formatCellValue(loginRow.getCell(j));
	        }

	        XSSFRow payRow = paymentSheet.getRow(i);

	        for (int j = 0; j < paymentCols; j++) {
	            fullData[i][loginCols + j] = formatter.formatCellValue(payRow.getCell(j));
	        }
	    }

	    workBook.close();
	    stream.close();

	    return fullData;
	}

	@Test(dataProvider = "loginCheckoutData")
	public void CheckoutTest(String email, String password,
	        String cardName, String cardNumber, String cvc,
	        String expiryMonth, String expiryYear)  {

	    initializeObjects();

	    // Verify that home page is visible successfully
	    Assert.assertTrue(homeobj.homePageBtn.isDisplayed());

	    // Open Login Page
	    homeobj.openLoginSignUpPage();

	    // Login
	    loginobj.userCanLogin(email, password);

	    // Verify Logged in
	    Assert.assertTrue(homeobj.loggedInAsUsername.isDisplayed());

	    // Open Products Page
	    homeobj.openProductsPage();

	    // Add Product
	    addpageObj.userSelectProduct();

	    // View Cart
	    addpageObj.userViewCart();

	    // Verify Cart Page
	    Assert.assertTrue(driver.getCurrentUrl().contains("/view_cart"));

	    // Proceed To Checkout
	    cartObj.userProceedToCheckout();

	    // Verify Address Details
	    Assert.assertTrue(checkoutObj.address_Delivery.isDisplayed());
	    Assert.assertTrue(checkoutObj.address_invoice.isDisplayed());

	    // Add Comment & Place Order
	    checkoutObj.useraddComment("thank you a lot");
	    checkoutObj.userplaceOrder();

	    // Payment
	    paymentObj.userEnterpaymentInfo(cardName, cardNumber, cvc,
	            expiryMonth, expiryYear);

	    homeobj.usercanlogout();
	}
}