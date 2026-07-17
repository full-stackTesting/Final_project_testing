package tests;

import java.io.File;
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

public class TC24_DownloadInvoice extends TestBase {
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

	// ---- Helper: polls the download folder until the file appears or timeout is reached ----
	private boolean isFileDownloaded(String downloadDir, String fileNamePattern, int timeoutSeconds)
			throws InterruptedException {
		File dir = new File(downloadDir);
		long endTime = System.currentTimeMillis() + (timeoutSeconds * 1000L);

		while (System.currentTimeMillis() < endTime) {
			File[] files = dir.listFiles((d, name) -> name.matches(fileNamePattern) && !name.endsWith(".crdownload"));
			if (files != null && files.length > 0) {
				return true;
			}
			Thread.sleep(500);
		}
		return false;
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

		// 14. Verify Address Details and Review Your Order
		Assert.assertTrue(checkoutObj.address_Delivery.isDisplayed());
		Assert.assertTrue(checkoutObj.address_invoice.isDisplayed());

		// 15. Enter description in comment text area and click 'Place Order'
		checkoutObj.useraddComment("thank you a lot");
		checkoutObj.userplaceOrder();

		// 16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
		paymentObj.userEnterpaymentInfo(cardName, cardNumber, cvc, expiryMonth, expiryYear);
	

		// 18. Verify success message 'Your order has been placed successfully!'
//		Assert.assertTrue(paymentObj.orderPlacedMsg.getText().equalsIgnoreCase("Your order has been placed successfully!"));

		// 19. Click 'Download Invoice' button and verify invoice is downloaded successfully
		// 19. Click 'Download Invoice' button and verify invoice is downloaded successfully
		String downloadDir = System.getProperty("user.home") + "/Downloads";

		checkoutObj.clickDownloadInvoice();

		boolean invoiceDownloaded = isFileDownloaded(downloadDir, "invoice.*\\.txt", 10);
		Assert.assertTrue(invoiceDownloaded, "Invoice file was not downloaded within the expected time");
paymentObj.usercontinue();
		// 20. Delete Account
		homeobj.usercandeletAcc();
	}
}