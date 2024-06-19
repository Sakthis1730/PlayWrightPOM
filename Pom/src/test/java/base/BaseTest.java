package base;

import com.microsoft.playwright.Page;
import org.lms.listeners.*;
import org.lms.pagefactory.PageFactory;
import org.lms.pages.AddCoursePage;
import org.lms.pages.HomePage;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    Page page;
    PageFactory pf;
    Properties prop;

   protected HomePage homepage;
   protected AddCoursePage addCoursePage;


   @BeforeClass
   public void startbrwoser() throws IOException {
       pf=new PageFactory();
       prop=pf.initprop();
       page=pf.initbrowser(prop);
       homepage=new HomePage(page);
       ExtentReportListener.setPage(page);
      // page.context().tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));

   }





    @AfterClass
   public void teardown()
   {

    //   page.context().tracing().stopChunk(new Tracing.StopChunkOptions().setPath(Paths.get("trace.zip")));

       page.context().browser().close();
   }



}
