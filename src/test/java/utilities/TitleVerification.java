package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {


    public static void main(String[] args) throws Exception{

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driverc =   getDriver.createDriver("chrome");

        driverc.get(urls.get(0));

        Thread.sleep(3000);//for demo, wait 3 seconds
        String title1 = driverc.getTitle();//returns <title>Some title</title> text
        String titleUrl1 = driverc.getCurrentUrl();//returns <url>

        driverc.get(urls.get(1));

        Thread.sleep(3000);//for demo, wait 3 seconds
        String title2 = driverc.getTitle();//returns <title>Some title</title> text
        String titleUrl2 = driverc.getCurrentUrl();//returns <url>
        driverc.get(urls.get(2));

        Thread.sleep(3000);//for demo, wait 3 seconds
        String title3 = driverc.getTitle();//returns <title>Some title</title> text
        String titleUrl3 = driverc.getCurrentUrl();//returns <url>

        if (title1.equals(title2) && title1.equals(title3)){

            System.out.println("Test Passed!");
        }

        if (titleUrl2.contains(titleUrl1) && titleUrl3.contains(titleUrl1)){

            System.out.println("URL Test Passed!");
        }
        driverc.close();//to close browser
        //browser cannot close itself
    }


}
