package HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

public class RegistrationFormHW {

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
   /* Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”
    Step 3. Enter “wrong_dob” into date of birth input box.
    Step 4. Verify that warning message is displayed: “The date of birth is not valid”*/

    public void InvalidDOB(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(dateOfBirthBy).sendKeys("a");
        BrowserUtils.wait(3);
        WebElement warningMessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/form/div[8]/div/small[2]"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }


    @Test

    /*Test case #2
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”
    Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript*/

    public void ProgramingLanguagesDisplayed(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(cplusplusBy).click();
        driver.findElement(javaBy).click();
        driver.findElement(javascriptBy).click();

        BrowserUtils.wait(3);
        WebElement displayedc = driver.findElement(By.id("inlineCheckbox1"));
        WebElement displayedjava = driver.findElement(By.id("inlineCheckbox2"));
        WebElement displayedjavascript = driver.findElement(By.id("inlineCheckbox3"));
        Assert.assertTrue(displayedc.isDisplayed());
        Assert.assertTrue(displayedjava.isDisplayed());
        Assert.assertTrue(displayedjavascript.isDisplayed());
    }

    @Test

    /*Test case #3
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”
    Step 3. Enter only one alphabetic character into first name input box.
    Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”*/

    public void verifyFirstNameLengthTest(){

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();

        driver.findElement(firstNameBy).sendKeys("a");
        BrowserUtils.wait(3);
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }

    @Test

   /* case #4
    Step 1. Go to https://practicecybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    Step 3. Enter only one alphabetic character into last name input box.
    Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”*/

    public void verifyLastNameLengthTest(){

        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();

        driver.findElement(lastNameBy).sendKeys("a");
        BrowserUtils.wait(3);
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }
    @Test

    /*Test case #5
    Step 1. Go to “https://practicecybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”
    Step 3. Enter any valid first name.
    Step 4. Enter any valid last name.
    Step 5. Enter any valid user name.
    Step 6. Enter any valid password.
    Step 7. Enter any valid phone number.
    Step 8. Select gender.
    Step 9. Enter any valid date of birth.
    Step 10. Select any department.
    Step 11. Enter any job title.
    Step 12. Select java as a programming language.
    Step 13. Click Sign up.
    Step 14. Verify that following success message is
    displayed: “You've successfully completed registration!”*/


    public void successfullyCompletedTest(){
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();

        driver.findElement(firstNameBy).sendKeys("Tuna");
        driver.findElement(lastNameBy).sendKeys("Akdemir");
        driver.findElement(usernameBy).sendKeys("Akdemir");
        driver.findElement(passwordBy).sendKeys("Akdemir123");
        driver.findElement(emailBy).sendKeys("akdemir@gmail.com");
        driver.findElement(phoneBy).sendKeys("401-543-5509");
        driver.findElement(maleBy).click();
        driver.findElement(dateOfBirthBy).sendKeys("04/08/1981");
        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Agriculture");
        Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
        jobTitleSelect.selectByVisibleText("SDET");
        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();

        BrowserUtils.wait(5);

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

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