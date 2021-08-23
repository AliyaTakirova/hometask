package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastebinPage extends DriverManager {

    public PastebinPage() {
        PageFactory.initElements(getDriver(),this);
    }
    //WebElement newPasteField = getDriver().findElement(By.xpath("//textarea [@id='postform-text']"));
    @FindBy(xpath = "//textarea [@id='postform-text']")
    WebElement newPasteField;

    //WebElement expirationDropdownArrow = getDriver().findElement(By.xpath("//span[@role='presentation' and @class='select2-selection__arrow' and ancestor::*[@class='form-group field-postform-expiration']]"));
    @FindBy(xpath = "//span[@role='presentation' and @class='select2-selection__arrow' and ancestor::*[@class='form-group field-postform-expiration']]")
    WebElement expirationDropdownArrow;

    //WebElement tenMinutesItem = getDriver().findElement(By.xpath("//li[text()='10 Minutes']"));
    @FindBy(xpath = "//li[text()='10 Minutes']")
    WebElement tenMinutesItem;

    //WebElement pasteNameField = getDriver().findElement(By.xpath("//input[@class='form-control']"));
    @FindBy(xpath = "//input[@class='form-control']")
    WebElement pasteNameField;

    //WebElement submitNewPaste = getDriver().findElement(By.xpath("//button[@type='submit']"));
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitNewPaste;

            public void sendKeystonewPasteField() {
        newPasteField.sendKeys("Hello from WebDriver");
    }

    public void clickOnExpirationDropdownArrow() {
        expirationDropdownArrow.click();
    }

    public void clickOntenMinutesItem() {
        tenMinutesItem.click();
    }

    public void sendKeystoPasteNameField() {
        pasteNameField.sendKeys("helloweb");
    }

    public void clickOnSubmitNewPaste() {
        submitNewPaste.click();
    }
}

