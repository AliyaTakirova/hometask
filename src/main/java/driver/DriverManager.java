package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    static WebDriver driver;

    public static void createDriver(){
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void quitDriver(){
        getDriver().quit();
        driver = null;
    }
}

