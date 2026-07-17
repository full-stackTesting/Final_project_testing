package tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class TC06_ContactUsForm extends TestBase {

    @Test
    public void testContactUsForm() throws IOException, InterruptedException {

        HomePage home = new HomePage(driver);
        ContactUsPage contact = new ContactUsPage(driver);

        // Verify Home Page
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));

        // Open Contact Us Page
        home.openContactUsPage();

        // Verify Get In Touch
        Assert.assertTrue(contact.contactUsMessage.isDisplayed());

        // Create file for upload
        File file = new File("testfile.txt");
        file.createNewFile();

        // Fill Contact Form
        contact.userCanContactUs_DirectWay(
                "Esraa Mostafa",
                "eng.esraamostafa50@gmail.com",
                "Test Subject",
                "Test Message for Contact Us Form",
                file.getAbsolutePath());

     

        // Accept Alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

      

        // Verify Success Message
        Assert.assertTrue(contact.successMessage.isDisplayed());

        // Back Home
        home.openHomePage();

        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));

    }
}