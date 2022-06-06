package zensar.selenium.testclasses;

import org.testng.annotations.*;

public class TestNGAnnotations {

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	@Test
	public void Test() {
		System.out.println("test");
	}
	
	
}
