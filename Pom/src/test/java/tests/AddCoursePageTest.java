package tests;

import base.BaseTest;
import com.aventstack.extentreports.Status;

import org.lms.listeners.ExtentReportListener;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ExcelReader;

import java.io.IOException;


@Listeners(ExtentReportListener.class)
public class AddCoursePageTest  extends BaseTest
{

    @DataProvider(name = "addcoursedata")
    public Object[][] getaddcoursetestdata() throws IOException
    {
        return ExcelReader.readExcelData("D:\\Addcoursedata.xlsx", 0);
    }


    @Test(dataProvider = "addcoursedata",priority =0)
    public void isimagemandatoryalertshowing(String title, String category, String subcategory,
                                        String description, String whoseCourseFor, String requirements, String achievements)
    {


        addCoursePage=homepage.navigatetoaddcoursepage();
        String addcourseurl=addCoursePage.getaddcourseurl();
        System.out.println(addcourseurl);
        ExtentReportListener.getTest().assignCategory("AddCoursemodule");

        ExtentReportListener.getTest().info("All the parameter entered");
        ExtentReportListener.getTest().info("Image is not upload");
        ExtentReportListener.getTest().info("Expected to show Alert");
        Assert.assertEquals(addcourseurl,"https://pdmrindia.co.in/tester/LMS/knowledge-bank/trainer/course/add/title","navigated to the wrong page");
        String text=addCoursePage.addCourse(title, category, subcategory, description, whoseCourseFor
                ,requirements, achievements);
        Assert.assertEquals(text,"Thumbnail upload is mand.","Error is not showing ");
        ExtentReportListener.getTest().info(text+" "+"Alert is showing");
    }

    @DataProvider(name = "validaddcoursedata")
    public Object[][] getvalidaddcoursetestdata() throws IOException
    {
        return ExcelReader.readExcelData("D:\\Addcoursedata.xlsx", 1);
    }

    @Test(dataProvider = "validaddcoursedata",priority =1)
    public void istestAddCourseissuccess(String title, String category, String subcategory,
                                       String description, String whoseCourseFor, String requirements, String achievements, String imgname) throws InterruptedException {

        ExtentReportListener.getTest().assignCategory("AddCoursemodule");
        ExtentReportListener.getTest().info("All the parameter entered");

        ExtentReportListener.getTest().info("Upload the image");
        ExtentReportListener.getTest().info("Expected to add course successfully ");

       addCoursePage=homepage.navigatetoaddcoursepage();
      String headertext=addCoursePage.isaddCoursesuccess(title, category, subcategory, description, whoseCourseFor
                , requirements, achievements, imgname);

        System.out.println(headertext);

        Assert.assertEquals(headertext,"Add Material","addcourse_is_failed");
        ExtentReportListener.getTest().info("course added  successfully ");
        //System.out.println("text is"+" "+text);

       // ExtentReportListener.getTest().info("");


      //  Assert.assertNotEquals(errormessage,"Thumbnail upload is mandatory.","Error is not showing ");








}

  /*  @Test(priority =2)
    public void ismaterialadded() throws InterruptedException {
        ExtentReportListener.getTest().assignCategory("AddCoursemodule");
        ExtentReportListener.getTest().info("All the parameter entered");

        ExtentReportListener.getTest().info("Upload the image");
        ExtentReportListener.getTest().info("Expected to add course successfully ");
        addCoursePage.ismaterialadded();


    }*/




}


