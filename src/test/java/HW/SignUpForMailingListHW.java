package HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.util.List;

public class SignUpForMailingListHW {


    private String URL2 = "https://www.tempmailaddress.com/";
    private WebDriver driver;

    private By validNameBy = By.name("full_name");
    private By lastNameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    //gender
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");

    private By dateOfBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");

    //languages
    private By cplusplusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javascriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");
    //sign up button
    private By signUpBy = By.name("wooden_spoon");


    @Test
   /* Test case #6
Step 1. Go to "https://www.tempmailaddress.com/"
Step 2. Copy and save email as a string.
Step 3. Then go to “https://practicecybertekschool.herokuapp.com”
Step 4. And click on “Sign Up For Mailing List".
Step 5. Enter any valid name.
Step 6. Enter email from the Step 2.
Step 7. Click Sign Up
Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
Step 9. Navigate back to the “https://www.tempmailaddress.com/”
Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
Step 11. Click on that email to open it.
Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
Step 13. Verify that subject is: “Thanks for subscribing to practice.cyberteks*/

    public void MAilingListTest(){
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/a")).click();
        String email = driver.findElement(By.id("email")).getText();
        String URL = "https://practice-cybertekschool.herokuapp.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[43]/a")).click();
        driver.findElement(validNameBy).sendKeys("Tuna Akdemir");
        BrowserUtils.wait(3);
        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(signUpBy).click();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.name("signup_message")).getText();

        Assert.assertEquals(actual, expected);
        BrowserUtils.wait(3);
        driver.navigate().back();
        BrowserUtils.wait(3);
        driver.navigate().back();
        BrowserUtils.wait(3);
        driver.navigate().back();
        BrowserUtils.wait(3);
        driver.navigate().refresh();
        BrowserUtils.wait(3);
        List<WebElement> mails = driver.findElements(By.xpath("//tr[contains(@class,'hidden')]"));
        String exp = "do-not-reply@practice.cybertekschool.com";
        for (int i=0;i<mails.size();i++){
            if(mails.get(i).getText().contains(expected)){
                mails.get(i).click();
                break;
            } }
        String act = driver.findElement(By.xpath("//span[@id='odesilatel']")).getText();
        Assert.assertEquals(exp,act,"TestFail !");
        List<WebElement> mailText = driver.findElements(By.xpath("//html/body/br"));
        for(WebElement each : mailText){
            if(each.getText().contains("Cybertek Support")){
                System.out.println("Test Pass !!!");
            }else {
                System.out.println("Test Fail !!!");
            } } }

    // WebElement warningMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/form/div[8]/div/small[2]"));
       // Assert.assertTrue(warningMessage.isDisplayed());

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL2);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}