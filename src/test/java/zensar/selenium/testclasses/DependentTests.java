package zensar.selenium.testclasses;

import org.testng.annotations.Test;

public class DependentTests {

	@Test(dependsOnMethods = {"xyz"})
	public void abc() {
		System.out.println("abc is running, depends on xyz");
	}
	
	@Test
	public void xyz() {
		System.out.println("xyz is running");
	}
	
	@Test(priority=1)
	public void qwe() {
		System.out.println("priority 1");
	}
	
	@Test(priority=2)
	public void asd() {
		System.out.println("priority 2");
	}
}
