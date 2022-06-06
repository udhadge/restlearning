package zensar.selenium.testclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import zensar.framework.BaseDriver;
import zensar.pageObject.SearchPage;

public class SeleniumTest1 {

	BaseDriver bd = BaseDriver.getInstance();
	WebDriver driver=bd.getDriver();
	SearchPage search = new SearchPage(driver);
	
	@BeforeClass
	public void beforeClass() {
		
	}
	
	@Test
	public void test1() throws Exception {
		System.out.println("Test1 is running");
		search.openPage();
		Thread.sleep(15000);
	}
	
	
	@AfterClass
	public void cleanUp() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
