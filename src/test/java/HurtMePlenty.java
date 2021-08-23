import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

public class HurtMePlenty {
    public static void main(String[] args) throws InterruptedException {
    }
    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");

        WebElement searchInput = driver.findElement(By.id("//*[@role='searchbox']"));
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator" + '\n');

        WebElement firstLink = driver.findElement(By.xpath("//*[@href='https://cloud.google.com/products/calculator?hl=en']"));
        firstLink.click();

        //не заработал WebElement computeEngine = driver.findElement(By.xpath("//*[@class='hexagon-in2' and ancestor::*[@title='Compute Engine' and @class='hexagon-in1']]"));
        //computeEngine.click();

        WebElement numberOfInstances = driver.findElement(By.xpath("//*[@id='input_1958']"));
        numberOfInstances.click();

        WebElement instancesFour = driver.findElement(By.xpath("//li[text()='10 Minutes']"));
        instancesFour.click();

        WebElement pasteNameField = driver.findElement(By.xpath("//input[@class='form-control']"));
        pasteNameField.sendKeys("helloweb");

        WebElement submitNewPaste = driver.findElement(By.xpath("//button[@type='submit']"));
        submitNewPaste.click();

    }
}
