package com.bbc.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.bbc.steps.GeneralStepDefs.currentScenario;
import static com.bbc.steps.GeneralStepDefs.getCurrentScenario;
import static com.bbc.utils.BasePage.driver;

public class ScreenshotUtils {
    final String USER_DIR = System.getProperty("user.dir");
    public String folderName=null;
    public String DateString = null;
    String screenshotDir;
    String screenshotDirCucumberReport;
    SimpleDateFormat sdf;
    Calendar cal;
    String strDate;

    public ScreenshotUtils (WebDriver sdriver){
        this.screenshotDir= this.USER_DIR+"\\src\\test\\resources\\evidences\\";
        this.screenshotDirCucumberReport = this.USER_DIR+"";
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver,15);
        PageFactory.initElements(finder,this);
        driver = sdriver;
    }

    public void takeScreenshot(){
        String temp = String.valueOf(currentScenario.getLine());
        this.folderName= getCurrentScenario().getName();
        this.DateString = this.getDateTimeStamp();
        File dir = new File(this.screenshotDir+this.folderName+" (Line "+temp+")");
        dir.mkdir();
        try{
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(screenshotDir+this.folderName+" (Line "+temp+")"+"\\"+this.DateString+".png"));
        }
        catch (Exception e){
            System.out.println("SCREENSHOT ERROR");
        }
    }

    public String getDateTimeStamp(){
        return this.getCurrentDate();
    }

    private String getCurrentDate(){
        this.cal = Calendar.getInstance();
        this.sdf = new SimpleDateFormat("ddMMyyyy_HHmmss");
        this.strDate=this.sdf.format(this.cal.getTime());
        return this.strDate;
    }
}
