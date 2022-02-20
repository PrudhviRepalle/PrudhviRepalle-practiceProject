package testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import wrappers.GenericWrappers;
import wrappers.ProjectWrappers;

public class TC004 extends ProjectWrappers{	
		
	@Test(groups = {"Regression"})
 public void saloonMandatoryCheck() {	
	
	threadWait(5000);
	moveToElementByXpath("//a[@aria-label='Menu Holiday']");
	threadWait(1000);
	moveToElementByXpath("(//span[text()='Stays'])[1]");
	threadWait(3000);
	clickByXpath("(//span[text()='Lounge'])[1]");
	threadWait(3000);
	switchToLastWindow();
	threadWait(4000);
	clickByXpath("//i[@class='fas fa-align-left']");
	threadWait(2000);
	clickByXpath("//a[text()='Charter']");
	threadWait(5000);
	clickByXpath("//a[@id='enquiry-tab']");
	threadWait(2000);
	enterByXpath("//input[@placeholder='Name of Applicant']", "Prudhvi");
	enterByXpath("//input[@placeholder='Name of Organisation']", "TrainingInstitute");
	enterByXpath("//input[@placeholder='Address']", "tanuku");	
	enterByXpath("//input[@placeholder='Mobile*']", "8978855016");
	enterByXpath("//input[@placeholder='Email']", "Prudhvi12@gmail.com");
	selectValueByXpath("//select[@name='requestFor']", "Saloon Charter");
	enterByXpath("//input[@placeholder='Originating Station*']", "Hyderabad");
	enterByXpath("//input[@placeholder='Destination Station*']", "Vizag");
	clickByXpath("//input[@placeholder='Date of Departure']");
	threadWait(1000);
	clickByXpath("//span[text()='22']");
	clickByXpath("//input[@name='checkOutDate']");
	clickByXpath("(//span[text()='24'])[2]");
	enterByXpath("//input[@placeholder='Number and type of coaches required']","3");
	enterByXpath("//textarea[@placeholder='Purpose of Charter']", "Personal work ");
	enterByXpath("//textarea[@placeholder='Additional Services Required']", "Not required");
	clickByXpath("//button[@type='Submit']");
   }
}
