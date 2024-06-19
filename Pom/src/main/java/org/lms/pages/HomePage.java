package org.lms.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private  Page page;
    private String lmslogo = "//img[@alt='LMS logo']";
    private String knowledgebank = "//p[text()='Knowledge Bank']";
    private String trainer = "//img[@alt='Trainer']";
    private String Add_course = "//img[@alt='Add Course']";


    public HomePage(Page page)
    {
        this.page=page;
    }

  public String verifyurl()
  {
      return page.url();
  }

  public String verifytitle()
  {
      return page.title();
  }

  public AddCoursePage navigatetoaddcoursepage()
  {
        page.locator(lmslogo).click();
        page.locator(knowledgebank).click();
        page.locator(trainer).click();
        page.locator(Add_course).click();
        return new AddCoursePage(page);
  }

}
