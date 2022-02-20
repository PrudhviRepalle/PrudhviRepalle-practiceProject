package testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.Test;

import utils.ReadDataFromExcel;
import wrappers.GenericWrappers;
import wrappers.ProjectWrappers;

public class TC001 extends ProjectWrappers {
	
	@Test(dataProvider = "IRCTC",dataProviderClass = ReadDataFromExcel.class,groups = {"Regression"})
	public void irctcRegistration(String username,String password, String confpassword, String seqans) {
		
		clickByXpath(".//a[@aria-label='Click here to register your account with I.R.C.T.C.']");
		threadWait(10000);
		enterByXpath("//input[@id='userName']", username);
		enterByXpath("//input[@id='usrPwd']",password );
		enterByXpath("//input[@id='cnfUsrPwd']",confpassword);
		clickByXpath("//*[@formcontrolname='prefLang']");
		clickByXpath("//li[@aria-label='English']");
		clickByXpath("//*[@formcontrolname='secque']");
		clickByXpath("//Li[@aria-label='Who was your Childhood hero?']");
		enterByXpath("//*[@placeholder='Security Answer']",seqans);
		clickByXpath("//button[@label='Continue']");
		threadWait(5000);
		enterByXpath("//input[@id='firstName']", "Prudhvi");
		enterByXpath("//input[@id='middleName']","test" );
		enterByXpath("//input[@id='lastname']", "Repalle");
		clickByXpath("//*[@formcontrolname='occupation']");
		clickByXpath("//Li[@aria-label='PRIVATE']");
		threadWait(2000);
		clickByXpath("//p-calendar[@formcontrolname='dob']");
		threadWait(2000);
		selectVisibileTextByXpath("//body/app-root[1]/app-home[1]/div[3]/div[1]/app-user-registration[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/p-tabview[1]/div[1]/div[1]/p-tabpanel[2]/div[1]/div[1]/div[6]/p-calendar[1]/span[1]/div[1]/div[1]/div[1]/div[1]/select[1]", "October");
		threadWait(2000);
		selectVisibileTextByXpath("//body/app-root[1]/app-home[1]/div[3]/div[1]/app-user-registration[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/p-tabview[1]/div[1]/div[1]/p-tabpanel[2]/div[1]/div[1]/div[6]/p-calendar[1]/span[1]/div[1]/div[1]/div[1]/div[1]/select[2]", "1991");
		threadWait(2000);
		clickByXpath("//a[text()='29']");
		threadWait(2000);
		clickByXpath("(//label[text()='Married'])[1]");
		threadWait(2000);
		selectVisibileTextByXpath("//body/app-root[1]/app-home[1]/div[3]/div[1]/app-user-registration[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/p-tabview[1]/div[1]/div[1]/p-tabpanel[2]/div[1]/div[1]/div[8]/select[1]", "India");
		clickByXpath("//div[@aria-label='Male']");
		enterByXpath("//input[@name='email']", "Prudhvi.technical@gmail.com");
		enterByXpath("//input[@name='mobile']", "8978855016");
		selectValueByXpath("//body/app-root[1]/app-home[1]/div[3]/div[1]/app-user-registration[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/p-tabview[1]/div[1]/div[1]/p-tabpanel[2]/div[1]/div[1]/div[13]/select[1]", "94" );
		clickByXpath("//button[@label='Continue']");
		threadWait(5000);
		enterByXpath("//input[@id='resAddress1']","TESTBLOCK:302" );
		enterByXpath("//input[@id='resAddress2']",  "TestStreet");
		enterByXpath("//input[@id='resAddress3']", "testarea");
		enterByXpath("//input[@name='resPinCode']", "534211");
		enterByXpath("//input[@id='resState']", "AndhraPradesh");
		selectValueByXpath("//body/app-root[1]/app-home[1]/div[3]/div[1]/app-user-registration[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/p-tabview[1]/div[1]/div[1]/p-tabpanel[3]/div[1]/div[1]/div[6]/select[1]", "West Godavari");
		threadWait(2000);
		selectValueByXpath("//body/app-root[1]/app-home[1]/div[3]/div[1]/app-user-registration[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/p-tabview[1]/div[1]/div[1]/p-tabpanel[3]/div[1]/div[1]/div[7]/select[1]", "Tanuku Old Town S.O");
		threadWait(2000);
		enterByXpath("//input[@id='resPhone']" , "8978855016");
		clickByXpath("//p-radiobutton[@id='yes']");
		clickByXpath("//*[@id=\"ui-tabpanel-2\"]/div/div[12]/span[1]/input");
		
	}
}
