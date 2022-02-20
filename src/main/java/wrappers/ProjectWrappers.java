package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectWrappers extends GenericWrappers {
	@BeforeMethod
	public void openingBrowser() {
		invokeApp("Chrome", "https://www.irctc.co.in");
		clickByXpath("//button[contains(text(),'OK')]");
		threadWait(2000);
		
	}
	@AfterMethod
	public void closingBroswer() {
		closeAllBrowsers();
	}

}
