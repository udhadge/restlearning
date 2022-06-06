package zensar.selenium.testclasses;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameters {

	@Test
	@Parameters("sd")
	public void ptest() {
		
	}
	

	@DataProvider(name="utk")
	public Object[][] dpm(){
		return new Object[][] {{"utk"},{"jai"},{"roy"}};
	}
		
	@Test(dataProvider ="utk")
	public void printValues(String value) {
		System.out.println("Value of string:"+value);
	}
}
