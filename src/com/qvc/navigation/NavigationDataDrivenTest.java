package com.qvc.navigation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.testmax.Exception.TestMaxException;
import com.testmax.framework.ConfigLoader;
import com.testmax.framework.WmLog;
import com.testmax.handler.BaseHandler;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.OutputType.*;

public class NavigationDataDrivenTest {
	BufferedWriter logger;
	WebDriver wd;
    String browser;
    String baseurl;
    String mainmenu;
    String submenu;
    String itemname;
    
    /*
       To use this framework to build quick browser automation tests follow these simple steps
       
        1) Register an account with www.CloudTestSoftware.com using your company email and password
        2) Login to the account using email and password
        3) Watch videos
        4) Create a sample Product -->Release -->Project -->Epic--Feature --> Scenarios
        5) Generate a Feature Template using button in Feature screen (each feature is a Test Suite)
        6) Copy Feature Template file generated to your eclipse project under ../data/module/Frontend/{YourProject} with a custom name
        7) Create a XL sheet and save as .csv similar to ../data/global/QVC_Smoke/qvc_cataegory_data.csv
        8) Create column in the XL and each column (use "_" if any space in column name) is a key to extract the value. 
        	Look example below mainmenu, submenu, itemname etc
        9) Open the page configuration file and change dataset="global:xls.Your Excel Sheet". Refer example in ../data/module/Frontend/QVC/TestNG/QVC_TestNG.xml
        10) Copy NavigationDataDrivenTest.java and rename into a new java file based on the Scenario or Feature name
        11) Generate TestNg script using any recording tool like Selenium Builder or IDE. You can also call your existing script 
            and pass the driver instance to your script
        12) Extract page name from the page configuration file and set page value in ../data/TestSuite/SampleTest.xml
        13) Select the project in eclipse --> Run Configuration --> Click Java Application --> Right Click -->
            Click New --> Click Search button (2nd) --> Search TestRunner --> select com.testmax.runner.TestRunner --> Click Run
        
     */
    
    @BeforeMethod
    public void setUp() throws Exception {
        
    	 //create a loger
        logger=BaseHandler.createActionLog();
        
    	// get  browser and baseurl value from the file
    	// ../data/TestSuite/SampleTest.xml
    	
        browser=BaseHandler.getDeclaredVariable("browser");
        baseurl=BaseHandler.getDeclaredVariable("baseurl");
        
        //extract values from dataset
    	// each row in the Excel sheet will run once.
    	// Look at the test data example in ../data/global/QVC_smoke/qvc_catagory_data.csv
        mainmenu=BaseHandler.getDeclaredVariable("mainmenu_name");
        submenu=BaseHandler.getDeclaredVariable("submenu_name");
        itemname=BaseHandler.getDeclaredVariable("item_name");
        
        wd= getWebDriver();
       
        
       
    }
    
    
    @Test
    public void Test() {
        wd.get(baseurl);
        
        // you can use any Selenium recorder like SeleniumBuilder or IDE and generate below test script
        
        findDynamicElement(By.id("liMenuHeader0000")).click();
        this.printMessage("Clicked  liMenuHeader0000 ");
        
        findDynamicElement(By.linkText(mainmenu)).click();
        this.printMessage("Clicked "+ mainmenu);
        
        findDynamicElement(By.linkText(submenu)).click();
        this.printMessage("Clicked "+ submenu);
       
        // Extract any value from the browser and pass to the handler as below
        // I just hard coded the value="100"
        // v_verify_item_value is key on which we store the value. You can use any key name you like
        // extract value in the assert as "junit:<key>". i.e. junit:v_verify_item_value
        // see the example in ../data/module/Frontend/QVC/TestNG/QVC_TestNG.xml
        
        BaseHandler.addTestResult("v_verify_item_value", "100");
        
        //Take a screen shot
        // pass file name same as key name of the verification to show screen shot in the report
      
		BaseHandler.getScreenShot(wd, "v_verify_item_value");
		
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
        BaseHandler.closeActionLog(logger);
    }
    
    public WebDriver getWebDriver(){
    	 // setup driver for browser
        if(browser.equalsIgnoreCase("firefox")){
          wd = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("chrome")){
        	DesiredCapabilities capability = DesiredCapabilities.chrome();
	    	
	    	if(System.getProperty("os.name").toLowerCase().contains("mac")){
	    		File file = new File(ConfigLoader.getWmRoot()+"/lib/chromedriver_mac");
		    	System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				capability.setCapability("platform", Platform.ANY);
				capability.setCapability("binary", "/Application/chrome"); //for linux "chrome.switches", "--verbose"
				capability.setCapability("chrome.switches", "--verbose");
				wd = new ChromeDriver(capability);
	    		
	    	}else{
	    		File file = new File(ConfigLoader.getWmRoot()+"/lib/chromedriver.exe");
		    	System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	    		wd= new ChromeDriver(capability);
	    	}
        }
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        
        return wd;
    }
    
    public WebElement findDynamicElement(By by) {
        WebDriverWait wait = new WebDriverWait(wd, 5000);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
    
    public void printMessage(String msg){
		WmLog.printMessage(msg);
		
			try {
				if(logger!=null){
					logger.append("\n"+this.getClass().getName()+" :" + msg);
					logger.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
}
