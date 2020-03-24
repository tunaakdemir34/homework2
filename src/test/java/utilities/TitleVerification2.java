package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {


    public static void main(String[] args) throws Exception{

        List<String> urls = Arrays.asList("https://www.luluandgeorgia.com/",
                "https://wayfair.com/", "https://walmart.com", "https://www.westelm.com/");

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

            System.out.println("Test Passed Lulu!");
        }else {System.out.println("Test Failed Lulu!");
        }

        driverc.get(urls.get(1));

        Thread.sleep(3000);//for demo, wait 3 seconds
        String title2 = driverc.getTitle();//returns <title>Some title</title> text
        String titleUrl2 = driverc.getCurrentUrl();//returns <url>
        String title2w = title2.replaceAll("\\s", "");

        String title2w2= title2w.toUpperCase();
        String titleUrl2U= titleUrl2.toUpperCase();

        System.out.println(title2w);

        if (titleUrl2U.contains(title2w2)){

            System.out.println("Test Passed wayfair!");
        }else {System.out.println("Test Failed wayfair!");
        }

        driverc.get(urls.get(2));

        Thread.sleep(3000);//for demo, wait 3 seconds
        String title3 = driverc.getTitle();//returns <title>Some title</title> text
        String titleUrl3 = driverc.getCurrentUrl();//returns <url>
        String title3w = title3.replaceAll("\\s", "");

        String title3w3= title3w.toUpperCase();
        String titleUrl3U= titleUrl3.toUpperCase();

        System.out.println(title3w);

        if (titleUrl3U.contains(title3w3)){

            System.out.println("Test Passed walmart!");
        }else {System.out.println("Test Failed walmart!");
        }
        driverc.get(urls.get(3));

        Thread.sleep(3000);//for demo, wait 3 seconds
        String title4 = driverc.getTitle();//returns <title>Some title</title> text
        String titleUrl4 = driverc.getCurrentUrl();//returns <url>
        String title4w = title4.replaceAll("\\s", "");
        String title4w4= title4w.toUpperCase();
        String titleUrl4U= titleUrl4.toUpperCase();

        System.out.println(title4w);

        if (titleUrl4U.contains(title4w4)){

            System.out.println("Test Passed westelm!");
        }else {System.out.println("Test Failed westelm!");
        }
        driverc.close();//to close browser
        //browser cannot close itself
    }


}