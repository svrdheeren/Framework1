package utilities;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExcelUtility
{	
	WebDriver driver;
	@Parameters("browser")
	@Test
    public void Driver(String browser) throws Exception
    {
    	ReportUtility rptutil = new ReportUtility();
    	rptutil.CreateReport();
    	keyDriver KD = new keyDriver(rptutil); 
    	XSSFWorkbook WB = new XSSFWorkbook(System.getProperty("user.dir")+"\\src\\test\\java\\webApp\\WebApp.xlsx");
    	int SC = WB.getNumberOfSheets();
    	for (int j =0; j<SC; j++){
    		XSSFSheet WS = WB.getSheetAt(j);
	    	//System.setProperty("webdriver.chrome.driver","E:\\Selenium Tutorial\\chromedriver_win32\\chromedriver.exe");
			//WebDriver driver = new ChromeDriver();
	    	this.setDriver(browser);
	    	int RC = WS.getLastRowNum()- WS.getFirstRowNum();
	    	XSSFRow WR = WS.getRow(0);
	    	XSSFRow WR1 = null;
	    	String Error = null;
	    	int CC = WR.getLastCellNum();
	    	//rptutil.LogTest(WS.getSheetName());
	    	rptutil.LogTest(WS.getSheetName());
	    	for(int row=1;row<=RC;row++){
	    		WR1 = WS.getRow(row);
	   			String Action = String.valueOf(WR1.getCell(0));
	   			String Object = String.valueOf(WR1.getCell(1));
	   			String Type = String.valueOf(WR1.getCell(2));
	   			String Value = String.valueOf(WR1.getCell(3));
	   			Error = KD.PerformAction(rptutil, Action, Object, Type, Value, driver);
	   			if (Error != null && !Error.isEmpty()) {
	   				break;
					}
	    	}
	    	if (Error != null && !Error.isEmpty()) {
			//		System.out.println("TestCase: " + WS.getSheetName() + " Failed "
			//				+ "with Error: " + Error);
	    		rptutil.LogTestRes("Failed", "TestCase: " + WS.getSheetName() + " Failed "
							+ "with Error: " + Error);
	    		}
			else{
			//		System.out.println("TestCase: " + WS.getSheetName() + " Passed");
				rptutil.LogTestRes("Passed","TestCase: " + WS.getSheetName() + " Passed");
				}    
	    	WB.close();
	    	driver.quit();
    	}
    	rptutil.FlushReport();
	}
	public void setDriver(String browser){
		System.out.println("browser: " + browser);
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
}
