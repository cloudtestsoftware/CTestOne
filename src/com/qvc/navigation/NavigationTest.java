package com.qvc.navigation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.testmax.handler.BaseHandler;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class NavigationTest {
    FirefoxDriver wd;
    String mainmenu="Fashion";
    String submenu="Accessories";
    String itemname="Belts";
    String baseurl;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        baseurl=BaseHandler.getDeclaredVariable("baseurl");
    }
    
    
    @Test
    public void Test() {
        wd.get("http://www.qvc.com/");
        wd.findElement(By.id("liMenuHeader0000")).click();
        wd.findElement(By.linkText(mainmenu)).click();
        wd.findElement(By.linkText(submenu)).click();
        wd.findElement(By.linkText(itemname)).click();
        BaseHandler.addTestResult("v_verify_item_value", "100");
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
