import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PastebinPage;

import static driver.DriverManager.getDriver;

public class HelloWebDriver {

    //private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        DriverManager.createDriver();
        getDriver().manage().window().maximize();
    }

    @Test(description = "Just first test. I can win")
    public void test() {
        getDriver().get("https://pastebin.com");

        PastebinPage pastebinPage = new PastebinPage();

        pastebinPage.sendKeystonewPasteField();
        pastebinPage.clickOnExpirationDropdownArrow();
        pastebinPage.clickOntenMinutesItem();
        pastebinPage.sendKeystoPasteNameField();
        pastebinPage.clickOnSubmitNewPaste();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverManager.quitDriver();
    }
}