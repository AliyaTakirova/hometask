import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BringItOn {

    private static final String PASTE_TITLE = "how to gain dominance among developers";

    private static final String FULL_TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {

        driver = new ChromeDriver();

    }

    @Test(description = "Just second test. Bring it on")
    public void test() {

        driver.manage().window().maximize();
        driver.get("https://pastebin.com");

        WebElement newPasteField = driver.findElement(By.xpath("//textarea[@id='postform-text']"));
        newPasteField.sendKeys("git config --global user.name  \"New Sheriff in Town\"\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\ngit push origin master --force");

        WebElement syntaxHighlightingDropdown = driver.findElement(By.id("select2-postform-format-container"));
        syntaxHighlightingDropdown.click();

        WebElement bashItem = driver.findElement(By.xpath("//li[@role='option' and text()='Bash']"));
        bashItem.click();

        WebElement expirationDropdownArrow = driver.findElement(By.xpath("//span[@role='presentation' and @class='select2-selection__arrow' and ancestor::*[@class='form-group field-postform-expiration']]"));
        expirationDropdownArrow.click();

        WebElement tenMinutesItem = driver.findElement(By.xpath("//li[text()='10 Minutes']"));
        tenMinutesItem.click();

        WebElement pasteNameField = driver.findElement(By.xpath("//input[@class='form-control']"));
        pasteNameField.sendKeys(PASTE_TITLE);

        WebElement submitNewPaste = driver.findElement(By.xpath("//button[@type='submit']"));
        submitNewPaste.click();

        WebElement pasteTitle = new WebDriverWait(driver, 5000).until(ExpectedConditions.visibilityOfElementLocated(By.className("info-top")));

        String bashHighlight = driver.findElement(By.xpath("//span[text()='git config']")).getCssValue("Color");

        WebElement newPasteField2 = driver.findElement(By.xpath("//textarea[@class='textarea']"));

        Assert.assertEquals(pasteTitle.getText(), PASTE_TITLE, "Search results are empty");

        Assert.assertFalse(bashHighlight.isEmpty(), "Bash is not highlighted");

        Assert.assertEquals(newPasteField2.getText(), FULL_TEXT, "Search results are empty");

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
