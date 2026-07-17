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
import pages.PaymentPage;
import pages.ProductsPage;
import pages.RegisterPage;

public class TC23_VerifyAddressDetailsInCheckout extends TestBase {
	HomePage homeobj;
	RegisterPage regObj;
	CartPage cartObj;
	ProductsPage productObj;
	CheckOutPage checkoutObj;
	PaymentPage paymentObj;
	AddToCarPage addpageObj;

	public void initializeObjects() {
		homeobj = new HomePage(driver);
		productObj = new ProductsPage(driver);
		cartObj = new CartPage(driver);
		regObj = new RegisterPage(driver);
		checkoutObj = new CheckOutPage(driver);
		paymentObj = new PaymentPage(driver);
		addpageObj = new AddToCarPage(driver);
	}

	@DataProvider(name = "registerCheckoutData")
	public Object[][] getRegisterCheckoutData() throws IOException {

		String filePath = System.getProperty("user.dir") + "/src/test/java/excelFile/data.xlsx";

		FileInputStream stream = new FileInputStream(filePath);

		XSSFWorkbook workBook = new XSSFWorkbook(stream);
		XSSFSheet registerHappySheet = workBook.getSheet("Register Happy");
		XSSFSheet paymentSheet = workBook.getSheet("Payment");

		int nRows = registerHappySheet.getLastRowNum() + 1;
		int registerCols = 16;
		int paymentCols = 5;
		int totalCols = registerCols + paymentCols;

		Object[][] fullData = new Object[nRows][totalCols];
		DataFormatter formatter = new DataFormatter();

		for (int i = 0; i < nRows; i++) {

			XSSFRow regRow = registerHappySheet.getRow(i);
			for (int j = 0; j < registerCols; j++) {
				fullData[i][j] = formatter.formatCellValue(regRow.getCell(j));
			}

			XSSFRow payRow = paymentSheet.getRow(i);
			for (int j = 0; j < paymentCols; j++) {
				fullData[i][registerCols + j] = formatter.formatCellValue(payRow.getCell(j));
			}
		}

		workBook.close();

		return fullData;
	}

	@Test(dataProvider = "registerCheckoutData")
	public void CheckoutTest(String name, String email, String password, String day, String month, String year,
			String firstName, String lastName, String company, String address, String address2, String country,
			String state, String city, String zipCode, String mobileNumber,
			String cardName, String cardNumber, String cvc, String expiryMonth, String expiryYear) throws InterruptedException {

		initializeObjects();

		// 3. Verify that home page is visible successfully
		Assert.assertTrue(homeobj.homePageBtn.isDisplayed());

		// 4. Add products to cart
		homeobj.openLoginSignUpPage();
		

		// 9. Fill all details in Signup and create account
		regObj.userCanRegister(name, email);
		regObj.userCanEnterAccountInformation(password, day, month, year, firstName, lastName, company, address,
				address2, country, state, city, zipCode, mobileNumber);

		// 10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
		Assert.assertTrue(regObj.SuccessMassage.getText().equalsIgnoreCase("Account Created!"));
		regObj.userCanContinueeAccount();

		// 11. Verify ' Logged in as username' at top
//		Assert.assertTrue(homeobj.loggedInAsUsername.getText().contains(name));
		

		homeobj.openProductsPage();
		addpageObj.userSelectProduct();
		// 5. Click 'Cart' button
		addpageObj.userViewCart();

		// 6. Verify that cart page is displayed
		Assert.assertTrue(driver.getCurrentUrl().contains("/view_cart"));

		// 7. Click Proceed To Checkout
		cartObj.userProceedToCheckout();
		

		// 12. Verify delivery address matches registration data
		String deliveryAddressText = checkoutObj.address_Delivery.getText();

		Assert.assertTrue(deliveryAddressText.contains(firstName + " " + lastName),
		        "First/last name not found in delivery address");
		Assert.assertTrue(deliveryAddressText.contains(address),
		        "Address line 1 not found in delivery address");
		Assert.assertTrue(deliveryAddressText.contains(city),
		        "City not found in delivery address");
		Assert.assertTrue(deliveryAddressText.contains(state),
		        "State not found in delivery address");
		Assert.assertTrue(deliveryAddressText.contains(zipCode),
		        "Zip code not found in delivery address");
		Assert.assertTrue(deliveryAddressText.contains(country),
		        "Country not found in delivery address");
		Assert.assertTrue(deliveryAddressText.contains(mobileNumber),
		        "Mobile number not found in delivery address");

		// 13. Verify billing address matches registration data
		String billingAddressText = checkoutObj.address_invoice.getText();

		Assert.assertTrue(billingAddressText.contains(firstName + " " + lastName),
		        "First/last name not found in billing address");
		Assert.assertTrue(billingAddressText.contains(address),
		        "Address line 1 not found in billing address");
		Assert.assertTrue(billingAddressText.contains(city),
		        "City not found in billing address");
		Assert.assertTrue(billingAddressText.contains(state),
		        "State not found in billing address");
		Assert.assertTrue(billingAddressText.contains(zipCode),
		        "Zip code not found in billing address");
		Assert.assertTrue(billingAddressText.contains(country),
		        "Country not found in billing address");
	
		// 19. Delete Account
		checkoutObj.userdeleteAccount();

    	
	}
}