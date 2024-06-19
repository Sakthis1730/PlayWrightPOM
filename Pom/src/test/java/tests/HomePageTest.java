package tests;

import base.BaseTest;
import org.lms.listeners.ExtentReportListener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(org.lms.listeners.ExtentReportListener.class)
public class HomePageTest extends BaseTest {


   @Test
    public void verifyhometitle()
    {
     String titlename= homepage.verifytitle();

        ExtentReportListener.getTest().assignCategory("HomePageTests");
        ExtentReportListener.getTest().info("Login successfully");
        ExtentReportListener.getTest().info("verifing the title");
        ExtentReportListener.getTest().info("Title expected as LMS");






        Assert.assertEquals(titlename,"LMS","title wrong");
        ExtentReportListener.getTest().info("Title is right");



    }


    @Test
    public void verifyurl()
    {
       String urlname= homepage.verifyurl();

        ExtentReportListener.getTest().assignCategory("HomePageTests");
        ExtentReportListener.getTest().info("Login successfully");
        ExtentReportListener.getTest().info("verifing the url");
        ExtentReportListener.getTest().info("url expected as https://pdmrindia.co.in/tester/LMS/auth/signin");

        Assert.assertEquals(urlname,"https://pdmrindia.co.in/tester/LMS/auth/signin","Wrong url");
        ExtentReportListener.getTest().info(" url is right");

    }



}
