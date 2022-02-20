package testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wrappers.GenericWrappers;
import wrappers.ProjectWrappers;

public class TC005 extends ProjectWrappers {
		@Test(groups = {"Regression"})
	 public void accommodationGSTValidation() {
		
			threadWait(5000);
			moveToElementByXpath("//a[@aria-label='Menu Holiday']");
			threadWait(1000);
			moveToElementByXpath("(//span[text()='Stays'])[1]");
			threadWait(3000);
			clickByXpath("(//span[text()='Lounge'])[1]");
			threadWait(3000);
			switchToLastWindow();
			threadWait(4000);
			selectVisibileTextByXpath("//select[@name='city']", "NEW DELHI");
			threadWait(2000);
			selectVisibileTextByXpath("//select[@name='laungecity']", "IRCTC EXECUTIVE LOUNGE, PF-1");
			selectValueByXpath("//select[@name='selPassangers']","3");
			threadWait(2000);
			clickByXpath("//input[@name='acservicecheckindate']");
			clickByXpath("//span[@class='act active-red']");
			threadWait(2000);
			selectValueByXpath("//select[@name='checkInTime']", "03:00");
			threadWait(2000);
			selectValueByXpath("//select[@name='checkOutTime']", "09:00");
			threadWait(3000);
			clickByXpath("/html/body/app-root/accommodation/div[2]/div[2]/div/form/div[11]/button[2]");
			threadWait(2000);
			clickByXpath("//a[@id='profile-tab']");
			threadWait(3000);
			enterByXpath("//input[@id='modalLRInput12']", "Prudhvi@gmail.com");
			enterByXpath("//input[@placeholder='Enter Your Mobile Number']", "8978855000");
			clickByXpath("//*[@id=\"profile\"]/div/form/div[3]/button");
			threadWait(3000);
			selectValueByXpath("//select[@name='gstGet']", "Yes");
			threadWait(2000);
			enterByXpath("//input[@placeholder='Gst Number']", "12231415");
			enterByXpath("(//input[@placeholder='Name'])[1]", "Prudhvi");
			enterByXpath("(//input[@placeholder='Age'])[1]", "30");
			selectValueByXpath("//tbody/tr[1]/td[4]/select[1]", "Male");
			enterByXpath("(//input[@placeholder='Name'])[2]", "female");
			enterByXpath("(//input[@placeholder='Age'])[2]", "30");
			selectValueByXpath("/html/body/app-root/acpassangers/div/form/div/div/div/div/div[1]/div/table/tbody/tr[2]/td[4]/select", "Female");
			enterByXpath("(//input[@placeholder='Name'])[3]", "Male");
			enterByXpath("(//input[@placeholder='Age'])[3]", "30");
			selectValueByXpath("/html/body/app-root/acpassangers/div/form/div/div/div/div/div[1]/div/table/tbody/tr[3]/td[4]/select","Female" );
			selectValueByXpath("//select[@name='state']", "ANDHRA PRADESH");
			clickByXpath("//button[@type='submit'][2]");
			threadWait(3000);
			verifyTextByXpath("/html/body/app-root/acpassangers/andiv/form/div/div/div/div/div[2]/form/div[2]/sp", "Please enter valid GSTIN");
									
	 }

}
