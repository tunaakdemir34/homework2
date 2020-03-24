package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {


    public static void main(String[] args) throws Exception{

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driverc =   getDriver.createDriver("chrome");

        driverc.get(urls.get(0));

        Thread.sleep(3000);//for demo, wait 3 seconds
        String title1 = driverc.getTitle();//returns <title>Some title</title> text
        String titleUrl1 = driverc.getCurrentUrl();//returns <url>
        String title1w = title1.replaceAll("\\s", "");
        String title1w2= title1w.toUpperCase();
        String titleUrl1U= titleUrl1.toUpperCase();

        System.out.println(title1w);

        if (titleUrl1U.contains(title1w2)) {

            System.out.println("Test Passed 1!");
        }else {System.out.println("Test Failed 1!");
        }

        driverc.close();//to close browser

        WebDriver driverc2 =   getDriver.createDriver("chrome");

        driverc2.get(urls.get(1));


        Thread.sleep(3000);//for demo, wait 3 seconds
        String title2 = driverc2.getTitle();//returns <title>Some title</title> text
        String titleUrl2 = driverc2.getCurrentUrl();//returns <url>
        String title2w = title2.replaceAll("\\s", "");

        String title2w2= title2w.toUpperCase();
        String titleUrl2U= titleUrl2.toUpperCase();

        System.out.println(title2w);

        if (titleUrl2U.contains(title2w2)){

            System.out.println("Test Passed 2!");
        }else {System.out.println("Test Failed 2!");
        }

        driverc2.close();//to close browser

        WebDriver driverc3 =   getDriver.createDriver("chrome");

        driverc3.get(urls.get(2));

        Thread.sleep(3000);//for demo, wait 3 seconds
        String title3 = driverc3.getTitle();//returns <title>Some title</title> text
        String titleUrl3 = driverc3.getCurrentUrl();//returns <url>
        String title3w = title3.replaceAll("\\s", "");

        String title3w3= title3w.toUpperCase();
        String titleUrl3U= titleUrl3.toUpperCase();

        System.out.println(title1w);

        if (titleUrl3U.contains(title3w3)){

            System.out.println("Test Passed 3!");
        }else {System.out.println("Test Failed 3!");
        }
        driverc.get(urls.get(3));

        Thread.sleep(3000);//for demo, wait 3 seconds

        driverc3.quit();//to close browser
        //browser cannot close itself
    }


}