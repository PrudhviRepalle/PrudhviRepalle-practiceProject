package testng_topics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {
	
	@BeforeSuite(groups = {"Regression","Functional","smoke"})
	public void m1() {
		System.out.println("Before suite is executed");
	}
	@BeforeTest(groups = {"Regression","Functional","smoke"})
	public void m2() {
		System.out.println("Before test is executed");
	}
	@BeforeClass(groups = {"Regression","Functional","smoke"})
	public void m3() {
		System.out.println("Before class is executed");
	}
	@BeforeMethod(groups = {"Regression","Functional","smoke"})
	public void m4() {
		System.out.println("Before method is executed");
	}
	@Test(priority = 1,enabled = true,groups = {"Regression","smoke"})
	public void m5() {
		System.out.println("Test 1 is executed");
	}
	@Test(groups = {"smoke"})
	public void m6() {
		System.out.println("Test 2 is executed");
	}
	@Test(priority = 1,enabled = false,groups = {"Regression"})
	public void m11() {
		System.out.println("Test 3 is executed");
	}
	@Test(groups = "Functional")
	public void m12() {
		System.out.println("Test 4 is executed");
	}
	@AfterSuite (groups = {"Regression","Functional","smoke"})
	public void m7() {
		System.out.println("After suite is executed");
	}
	@AfterTest(groups = {"Regression","Functional","smoke"})
	public void m8() {
		System.out.println("After test is executed");
	}
	@AfterClass(groups = {"Regression","Functional","smoke"})
	public void m9() {
		System.out.println("After class is executed");
	}
	@AfterMethod(groups = {"Regression","Functional","smoke"})
	public void m10() {
		System.out.println("After method is executed");
	}
}
