# CTestOne
Cloud Test Software Open source software test automation tool with recording plugin


Find details about [CloudTestSoftware](http://www.CloudTestSoftware.com  target=_blank)

Install CloudTest Software's [ CTO Recording Tool](https://chrome.google.com/webstore/search/CloudTestSoftware)

CTO recording tool is used to create automation script using XML and it does not required any code like TestNG or Junit using Selenium.

CloudTestSoftware has built an automation framework which can create injectors and also can be built complex automation tests using browser, mobile, web service, database, Java Script, Java, Python  etc. If you want to build simple TestNg / Junit Tests or Selenium WebDriver tests please refer to the last section of this document.

If you find any issue, please create a ticket using ISSUEs. Also please use [ CTO Group](https://groups.google.com/forum/#!forum/cloud-test-software--software-automation-as-a-service) to discuss any issues.


## Steps for browser Automation Tests using CTO recording tool (No Coding needed)

To use this framework to build quick browser automation tests using TestNg or Junit follow these simple steps

    1) Register an account with www.CloudTestSoftware.com using your company email and password
    2) Login to the account using email and password
    3) Watch videos
    4) Create a sample Product -->Release -->Project -->Epic--Feature --> Scenerios
    5) Generate a Feature Template using button in Feature screen (each feature is a Test Suite)
    6) Copy Feature Template file generated to your eclipse project under 
        ../data/module/Frontend/{YourProject} with a custom name
    7) Create a XL sheet and save as .csv similar to ../data/global/QVC_Smoke/qvc_cataegory_data.csv
    8) Create column in the XL and each column (use "_" if any space in column name) 
       is a key to extract the value.  Look example below mainmenu, submenu, itemname etc
    9) Open the page configuration file and change dataset="global:xls.Your Excel Sheet". 
        Refer example in ../data/module/Frontend/QVC/Smoke/QVC_Navigation.xml
    10) Install CTestOne (CTO) recoder as chrome plugin using this link 
         [ CTO Recording Tool](https://chrome.google.com/webstore/search/CloudTestSoftware)
    11) Generate XML script using this recording tool and save into a file with .xml and copy the 
        file to the ../data/taglib/injector folder or create your own folder structure under folder INJECTOR
    12) Change "Give_Me_Unique_Name" and "Give_Me_Injector_NameTest1" to a meaningful name which 
        related to the feature or scenarios you like to test
    13) Change appropriate injector name in the Feature Template script you generated in step 6)
    14) Compare with the sample example givin in
        ../data/module/Frontend/QVC/Smoke/QVC_Navigation.xml
    15) Extract page name from the page configuration file and set page value 
        in ../data/TestSuite/SampleTest.xml to run
    16) Select the project in eclipse --> Run Configuration --> Click Java Application --> Right Click -->
        Click New --> Click Search button (2nd) --> Search TestRunner --> 
        select com.testmax.runner.TestRunner --> Click Run

## Steps for Selenium WebDriver Tests using TestNG or Junit

 To use this framework to build quick browser automation tests using TestNg or Junit follow these simple steps
       
        1) Register an account with www.CloudTestSoftware.com using your company email and password
        2) Login to the account using email and password
        3) Watch videos
        4) Create a sample Product -->Release -->Project -->Epic--Feature --> Scenerios
        5) Generate a Feature Template using button in Feature screen (each feature is a Test Suite)
        6) Copy Feature Template file generated to your eclipse project under 
            ../data/module/Frontend/{YourProject} with a custom name
        7) Create a XL sheet and save as .csv similar to ../data/global/QVC_Smoke/qvc_cataegory_data.csv
        8) Create column in the XL and each column (use "_" if any space in column name) 
           is a key to extract the value.  Look example below mainmenu, submenu, itemname etc
        9) Open the page configuration file and change dataset="global:xls.Your Excel Sheet". 
            Refer example in ../data/module/Frontend/QVC/TestNG/QVC_TestNG.xml
        10) Copy NavigationDataDrivenTest.java and rename into a new java file based on the Scenario or Feature name
        11) Generate TestNg script using any recording tool like Selenium Builder or IDE. 
            You can also call your existing script and pass the driver instance to your script
        12) Extract page name from the page configuration file and set page value 
            in ../data/TestSuite/SampleTest.xml
        13) Select the project in eclipse --> Run Configuration --> Click Java Application --> Right Click -->
            Click New --> Click Search button (2nd) --> Search TestRunner --> 
            select com.testmax.runner.TestRunner --> Click Run
  
