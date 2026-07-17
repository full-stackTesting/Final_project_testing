package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.TestCasePage;

public class TC07_TestCasesTest extends TestBase {

    HomePage homeobj;
    TestCasePage testobj;

    @BeforeMethod
    public void setupPages() {

        homeobj = new HomePage(driver);
        testobj = new TestCasePage(driver);

    }

    @Test
    public void verifyTestCasesPage() {

        homeobj.userOpenTestCasesPage();

        Assert.assertTrue(testobj.TestcasesMsg.getText().equalsIgnoreCase("Test Cases"));

    }
}