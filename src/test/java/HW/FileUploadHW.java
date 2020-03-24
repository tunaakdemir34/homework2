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

public class FileUploadHW {

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
/*Test case #7
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “File Upload".
Step 3. Upload any file with .txt extension from your computer.
Step 4. Click “Upload” button.
Step 5. Verify that subject is: “File Uploaded!”
Step 6. Verify that uploaded file name is displayed.
Note: use element.sendKeys(“/file/path”) with specifying path to the file for uploading. Run this method against “Choose File” button.*/

    public void uploadedFile() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[18]/a")).click();
        BrowserUtils.wait(3);
        WebElement upload = driver.findElement(By.id("file-upload"));
        BrowserUtils.wait(3);
        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //I am gonna upload pom.xml file
        //   String filePath = System.getProperty("user.dir")+"/pom.xml";
        //it work only for my computer because only have this file
        //and my computer username is different than yours
        String filePath = System.getProperty("user.dir")+"/pom.xml";
        //it work only for my computer because only have this file
        //and my computer username is different than yours
     //   String file2Path = "/Users/studio2/Downloads/image (2).png";
//        doesn't work, should be on your computer
//        String cloudFile = "https://cybertek-appium.s3.amazonaws.com/etsy.apk";

        System.out.println(filePath);//print path

        upload.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();//click to upload


        BrowserUtils.wait(5);
        String expected = "pom.xml";
        String actual = driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actual, expected);

//        WebElement warningMessage = driver.findElement(By.id("uploaded-files"));
//        Assert.assertTrue(warningMessage.isDisplayed());
    }

    @Test

    public void uploadedFile2() {

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(5);

        WebElement upload = driver.findElement(By.id("file-upload"));

        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //I am gonna upload pom.xml file
        String filePath = System.getProperty("user.dir")+"/pom.xml";
        //it work only for my computer because only have this file
        //and my computer username is different than yours
        String file2Path = "Users/tunaa/Downloads/git-cheat-sheet-education.pdf";
//        doesn't work, should be on your computer
//        String cloudFile = "https://cybertek-appium.s3.amazonaws.com/etsy.apk";

        System.out.println(filePath);//print path

        upload.sendKeys(file2Path);

        driver.findElement(By.id("file-submit")).click();//click to upload

        String expected = "git-cheat-sheet-education.pdf";
        String actual = driver.findElement(By.id("uploaded-files")).getText();

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