package HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class StatusCodeHW {

    private String URL = "http://practice.cybertekschool.com/";
    private WebDriver driver;


    @Test
/*Test case #9
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “200”.
Step 4. Verify that following message is displayed:
“This page returned a 200 status code”
Test case #10
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “301”.
Step 4. Verify that following message is displayed:
“This page returned a 301 status code”
Test case #11
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “404”.
Step 5. Verify that following message is displayed:
“This page returned a 404 status code”
Test case #12
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “500”.
Step 5. Verify that following message is displayed:
“This page returned a c500 status code”*/

    public void statusCode200() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[46]/a")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/a")).click();

        String actual = driver.findElement(By.cssSelector("p")).getText();

        System.out.println("actual = " + actual);

        // WebElement warningMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/text()[1]"));
        // Assert.assertTrue(warningMessage.isDisplayed());

        String expected = "This page returned a 200 status code.";
//        String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/p/text()[1]")).getText();
//
        Assert.assertTrue(actual.contains(expected));



//        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[46]/a")).click();
//        BrowserUtils.wait(3);
//        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/a")).click();
//
//       // WebElement warningMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/text()[1]"));
//       // Assert.assertTrue(warningMessage.isDisplayed());
//
//        List<WebElement> elements=driver.findElements(By.xpath("//a[contains(@href,'status_codes')]"));
//        elements.get(0).click();
//        BrowserUtils.wait(2);
//
//        String actual = driver.findElement(By.tagName("p")).getText();
//
//        System.out.println("actual = " + actual);

        // WebElement warningMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/text()[1]"));
        // Assert.assertTrue(warningMessage.isDisplayed());

    //    String expected = "This page returned a 404 status code.";
//        String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/p/text()[1]")).getText();
//
//        Assert.assertEquals(actual, expected);
//

//        //Creating the JavascriptExecutor interface object by Type casting
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//
//        //Fetching the Domain Name of the site. Tostring() change object to name.
//        String Text = js.executeScript("return document.getElementsByClassName(\"example\").toString;").toString();
//        System.out.println("Domain name of the site = " + Text);

       // WebDriverWait wait = new WebDriverWait(driver,  10);
       // wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("//*[@id=\"content\"]/div/p[text()[1]))));
// click on the compose button as soon as the "compose" button is visible
      //  String act = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[text(),'\n" +
       //                 "    This page returned a 200 status code.')]")).getText();


   // @AfterMethod
     //   public void teardown(){
// closes all the browser windows opened by web driver

   // }

//}

      //  String act= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/p[contains(text()=' status code')]")).getText();
//        if(act.contains("This page returned a 200 status code.")){
//            System.out.println("pass");;
//        }else {
//            System.out.println("Fail");
//        }
//        BrowserUtils.wait(1);
//        String exp = "200 status code";
//        Assert.assertEquals(exp,Text,"Test pass !");
//
//        driver.quit();
    }
@Test
    public void statusCode301() {
    driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[46]/a")).click();
    BrowserUtils.wait(3);
    driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/a")).click();

    String actual = driver.findElement(By.cssSelector("p")).getText();

    System.out.println("actual = " + actual);

    // WebElement warningMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/text()[1]"));
    // Assert.assertTrue(warningMessage.isDisplayed());

    String expected = "This page returned a 301 status code.";
//        String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/p/text()[1]")).getText();
//
    Assert.assertTrue(actual.contains(expected));

    }

    @Test
    public void statusCode404() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[46]/a")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/a")).click();

        String actual = driver.findElement(By.cssSelector("p")).getText();

        System.out.println("actual = " + actual);

        // WebElement warningMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/text()[1]"));
        // Assert.assertTrue(warningMessage.isDisplayed());

        String expected = "This page returned a 404 status code.";
//        String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/p/text()[1]")).getText();
//
        Assert.assertTrue(actual.contains(expected));

    } @Test
    public void statusCode500() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[46]/a")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[4]/a")).click();

        String actual = driver.findElement(By.cssSelector("p")).getText();

        System.out.println("actual = " + actual);

        // WebElement warningMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/text()[1]"));
        // Assert.assertTrue(warningMessage.isDisplayed());

        String expected = "This page returned a 500 status code.";
//        String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/p/text()[1]")).getText();
//
        Assert.assertTrue(actual.contains(expected));

    }



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}