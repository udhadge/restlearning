package zensar.selenium.testclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import zensar.framework.BaseDriver;
import zensar.pageObject.SearchPage;

public class SeleniumTest {

	BaseDriver bd = BaseDriver.getInstance();
	WebDriver driver=bd.getDriver();
	SearchPage search = new SearchPage(driver);
	
	@BeforeClass
	public void beforeClass() {
		
	}
	
	@Test
	public void test1() throws IOException {
		System.out.println("Test1 is running");
		search.openPage();
	}
	
	@Test
	public void test2() throws IOException {
		System.out.println("Test1 is running");
		search.openPage();
		search.countLinks();
		search.searchTerm("Zensar");
		//search.imageSrcDownload();
	}
	
	@Test
	public void test3() throws IOException {
		System.out.println("Test1 is running");
		search.openPage();
	}
	
	@Test
    @Parameters ({"val1", "val2"})
    public void Sum(int v1, int v2) {
    	int finalsum = v1 + v2;
        System.out.println("The final sum of the given values is " + finalsum);
    }
	
	@AfterClass
	public void cleanUp() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
