package org.lms.pages;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class AddCoursePage {

    private Page page;
    private String titleinput = "id=course_title";
    private String cateogryinput = "id=course_category";
    private String subcateogryinput = "id=course_sub_category";
    private String courseinput = "id=course_type";
    private String coursetypesinput = "//p[text()='Process']";
    private String relatedinput = "//*[text()='Related Department']//preceding::input[1]";
    private String relatedtypesinput = "//*[@id=\"root\"]/div/main/section/div/section/div/form/div[1]/div[3]/div[2]/div/ul/li[1]";
    private String descriptioninput = "id=course_description";
    public String whoisthecourseforinput = "id=who_is_this_course_for";
    private String requirementsinput = "id=requirements";
    private String skillsacheivedinput = "id=skills_achieved";
    private String nextbuttoninput = "//button[@type='submit']";

    private String imagealerterrorrinput = "//*[text()='Thumbnail upload is mandatory.']";
    private String imageuploadbuttoninput = "//*[text()='Upload Image']";
    private String imguploadedname = "//span[text()='automation1.jpg']";
    private String relatedtyeerrorr="id=assign_to";
    private String addmaterialheader="//li[text()='Add Material']";
    private String uploadaddmaterialbutton="//button[text()='Upload document']";
    private String lmslogo = "//img[@alt='LMS logo']";
    private String knowledgebank = "//p[text()='Knowledge Bank']";
    private String trainer = "//img[@alt='Trainer']";
    private String Add_course = "//img[@alt='Add Course']";

    private String mod_title="module_title_0";
    private String mod_quiz="//input[@id='quiz_0']";
    private String subtitle="//input[@id='sub_module_title_0_0']";
    private String uploadvid="//button[text()='Upload video']";
    private String uploaddoc="//button[text()='Upload document']";
    private String prev_button="//input[@id='Previous']";
    private String verify_upload_doc="//button[.='Upload video']//following::p[1]";
    private String add_material_page_nxt_button="//button[text()='Add Module']//following::button";




    public AddCoursePage(Page page) {
        this.page = page;
    }

    public String getaddcourseurl() {
        return page.url();
    }

    public String addCourse(String title, String category, String subcategory, String description,
                            String whoseCourseFor, String requirements, String achievements) {
        page.reload();
        page.locator(titleinput).type(title);
        page.locator(cateogryinput).type(category);
        page.locator(subcateogryinput).type(subcategory);
        page.click(courseinput);
        page.click(coursetypesinput);
        page.click(relatedinput);
         page.waitForSelector(relatedtypesinput).click();
       // page.waitForSelector(relatedtypesinput).click();

        page.locator(descriptioninput).type(description);
        page.locator(whoisthecourseforinput).type(whoseCourseFor);

        page.locator(requirementsinput).type(requirements);
        page.locator(skillsacheivedinput).type(achievements);
        //page.keyboard().press("Enter");

        // Attempt to submit without an image
        page.click(nextbuttoninput);

        String text = page.locator(imagealerterrorrinput).textContent();
        System.out.println(text);
        return text;
    }

    public String isaddCoursesuccess(String title, String category, String subcategory, String description,
                                     String whoseCourseFor, String requirements, String achievements, String imgname) throws InterruptedException {
        page.reload();
        page.locator(titleinput).type(title);
        page.locator(cateogryinput).type(category);
        page.locator(subcateogryinput).type(subcategory);
        page.click(courseinput);
        page.click(coursetypesinput);
        page.click(relatedinput);
        page.waitForSelector(relatedtypesinput).click();

        page.locator(descriptioninput).type(description);
        page.locator(whoisthecourseforinput).type(whoseCourseFor);

        page.locator(requirementsinput).type(requirements);
        page.locator(skillsacheivedinput).type(achievements);

        //page.locator(imageuploadbuttoninput).click();

        FileChooser fileChooser = page.waitForFileChooser(() -> page.locator(imageuploadbuttoninput).click());

        fileChooser.setFiles(Paths.get("Automation.jpg"));

        page.keyboard().press("Enter");

        Thread.sleep(4000);
        //page.wait(5000);
        page.click(nextbuttoninput);

        String header = page.locator(addmaterialheader).textContent();
         return header    ;    //return text;


    }


    public void ismaterialadded()
    {
        page.locator(mod_title).fill("mod_1");
        page.locator(mod_quiz).fill("What is u r number");
        page.locator(subtitle).fill("Sub cateogry");
        FileChooser fileChooser=page.waitForFileChooser(()-> {
            page.click(uploaddoc);
        });
        fileChooser.setFiles(Paths.get("Automation.jpg"));
        page.click(add_material_page_nxt_button);


    }

}
