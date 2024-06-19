package org.lms.pagefactory;

import com.microsoft.playwright.*;

import javax.naming.Context;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class PageFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
    Properties prop;

    String username="//*[@type='text']";
    String password="//*[@type='password']";

    public  Page initbrowser(Properties prop)
    {
        String browserName=prop.getProperty("Browser");
        System.out.println(browserName);
        playwright=Playwright.create();
        switch (browserName.toLowerCase())
        {
            case "chromium":
               browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "firefox":
                browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "webkit":
              browser=  playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            default:
                System.out.println("no parameter");
                break;
        }

         context=browser.newContext(new Browser.NewContextOptions().setViewportSize(1900,1080));
         page=context.newPage();
         page.navigate(prop.getProperty("url"));
         page.locator(username).fill(prop.getProperty("username"));
         page.locator(password).fill(prop.getProperty("password"));
         page.keyboard().press("Enter");

         return page;
    }




    public Properties initprop() throws IOException {
        FileInputStream fio=new FileInputStream("Base.properties");
         prop=new Properties();
        prop.load(fio);
        return prop;
    }
}
