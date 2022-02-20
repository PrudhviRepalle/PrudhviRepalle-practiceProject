package testcases;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wrappers.GenericWrappers;
import wrappers.ProjectWrappers;

public class TC003 extends ProjectWrappers{

	
	@Test(groups = {"Regression"})
	public void  ftrSignup() {
		
		threadWait(5000);
		clickByXpath("//a[@aria-label='Menu Train']//strong[contains(text(),'TRAINS')]");
		threadWait(3000);
		clickByXpath("//a[@aria-label='Sub Menu of Train, FTR Coach or Train Booking. Website will be opened in new tab']//span[@class='list_text']");
		threadWait(3000);
		switchToLastWindow();
		threadWait(2000);
		clickByXpath("//a[contains(text(),'New User? Signup')]");
		threadWait(2000);
		enterByXpath("//input[@id='userId']", "PrudhviRepalle016");
		enterByXpath("//input[@id='password']","Prudh8978855016" );
		enterByXpath("//input[@id='cnfPassword']","Prudh8978855016" );
		threadWait(2000);
		selectValueByXpath("//select[@id='secQstn']","6" );
		enterByXpath("//input[@id='secAnswer']","YAMAHA" );
		threadWait(2000);
		clickByXpath("//input[@id='dateOfBirth']");
		selectVisibileTextByXpath("//select[@class='ui-datepicker-month']", "Oct");
		threadWait(2000);
		selectVisibileTextByXpath("//select[@class='ui-datepicker-year']", "1991");
		threadWait(2000);
		clickByXpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[3]");
        clickByXpath("//input[@id='gender0']");
        clickByXpath("//input[@id='maritalStatus0']");
        enterByXpath("//input[@id='email']", "prudhvi.technical@gmail.com");
        selectValueByXpath("(//select[@id='occupation'])[1]", "Professional");
        enterByXpath("//input[@id='fname']", "Prudhvi");
        enterByXpath("//input[@id='mname']", "moddle");
        enterByXpath("//input[@id='lname']", "Repalle");
        selectVisibileTextByXpath("//select[@id='natinality']","Indian");
        enterByXpath("//input[@id='flatNo']","2-3" );
        enterByXpath("//input[@id='street']","papireddy colony" );
        enterByXpath("//input[@id='area']","chandanagar" );
        enterByXpath("//input[@id='area']", "chandanagar");
        selectVisibileTextByXpath("//select[@id='country']", "India");
        enterByXpath("//input[@id='mobile']", "8978855016");
        enterByXpath("//input[@id='pincode']", "500019");
        enterByXpath("//input[@id='pincode']", "Keys.TAB");
        closeBrowser();
        	
	}

}
