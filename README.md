**Features of the framework:** Its a Hybrid framework which can serve both UI and API automation
**1. Design patterns used:**                 
    A. Mono State SIngleton design pattern for reading property file               
    B. POM with page factory.
**3. Test Data techniques:**      
    **A. for UI automation:** Reading the test data as Map<String, Map<String, String>> where the first String is the name of the test case     
    **B. For API Automation:** custom data provider using excel. The execution can be controlled via iteration column 
**4. Reporting:** Event firing webdriver event + testng listeners     
    A. Testng Reporter to capture the details     
    B. Runtime log creation based on the suite name    
    C.Runtime Excel report generation based on the suite name. 

**Important:** As I have set a runtime parameter in the POM.xml file. One should do the below setting in Eclipse for the project to workGoto Window-->Preferences-->Search for TestNG-->Maven and uncheck all the checkboxes
 

Thanks and regards,
Mohammed Zabiulla
Lead SDET
