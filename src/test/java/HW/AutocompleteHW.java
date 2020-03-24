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

public class AutocompleteHW {

    private String URL = "https://practice-cybertekschool.herokuapp.com/";
    private WebDriver driver;
    // p tag name of success message
    // one xpath for all inputs: //label[text()='Label name']/..//input
    private By firstNameBy = By.name("firstname");
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
    private By signUpBy = By.id("wooden_spoon");

    @Test
/*Test case #8
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “Autocomplete”.
Step 3. Enter “United States of America” into country input box.
Step 4. Verify that following message is displayed: “You selected: United States of America”*/

    public void AutoComplete() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[3]/a")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/form/input")).click();
        //*[@id="content"]/div/form/input
        BrowserUtils.wait(3);

        BrowserUtils.wait(5);
        String expected = "You selected: United States of America";
        String actual = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(actual, expected);

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