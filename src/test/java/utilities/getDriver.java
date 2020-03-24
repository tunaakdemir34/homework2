package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class getDriver {

    /**
     * You homework will be to improve this method!
     * This method return webdriver object based on browser type
     * If you want to use chrome browser, just provide chrome as a parameter
     *
     * @return webdriver object
     */
    public static WebDriver createDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            //to fix [1583364253.062][SEVERE]: Timed out receiving message from renderer: 0.100
            WebDriverManager.chromedriver().version("79.0").setup();
            return new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
        //    System.setProperty("webdriver.edge.driver","C:\\Program Files (x86)\\Microsoft Web Driver\\MicrosoftWebDriver.exe");
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        } else
            // WebDriverManager.safaridriver().setup();
            return null;
        }
    }


       /* public getDriver() {}

        private static WebDriver driver;

        public static WebDriver createDriver(String browser) {

                switch ("browser") {
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case "ie":
                        WebDriverManager.iedriver().setup();
                        driver = new EdgeDriver();
                        break;
                }

            return driver;
        }

        public static void closeDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }*/



