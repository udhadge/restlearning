package zensar.selenium.testclasses;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(zensar.selenium.testclasses.ListnersBlog.class)
public class GroupTest1 {

	@Test(groups="smoke")
	public void test11() {
		
	}
	
	@Test(groups="smoke")
	public void test21() {
		
	}
	
	@Test(groups="smoke")
	public void test31() {
		
	}
	
	@Test(groups="regression")
	public void test41() {
		
	}
	
	@Test(groups="regression")
	public void test51() {
		Assert.assertEquals("abc", "dfg");
	}	
}
