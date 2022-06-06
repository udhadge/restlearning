package zensar.selenium.testclasses;

import org.testng.ITestListener;
import org.testng.ITestNGMethod;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class ListnersBlog implements ITestListener {
public void onTestStart(ITestResult result) {
		
		System.out.println("New Test Started" +result.getName());
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Successfully Finished: " +result.getName());
		System.out.println(result.getTestClass());
		System.out.println(result.getStatus());
		//System.out.println(result);
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Failed: " +result.getName());
		System.out.println(result.getTestClass());
		System.out.println(result.getStatus());
		
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test Skipped" +result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		System.out.println("Test Failed but within success percentage" +result.getName());
		
	}

	public void onStart(ITestContext context) {
		
		
		System.out.println("This is onStart method" +context.getOutputDirectory());
		
	}

	public void onFinish(ITestContext context) {
			
		System.out.println("This is onFinish method" +context.getPassedTests());
		System.out.println("This is onFinish method" +context.getFailedTests());
		
		IResultMap tests = context.getPassedTests();
		
		for (ITestResult result : tests.getAllResults()) {
			ITestNGMethod method = result.getMethod();

			//int methodId = getId(result);

			String cname = method.getTestClass().getName();
			System.out.print(" class name" + ":"+ cname);
			System.out.print(" method name" + ":"+ method.getMethodName());
			Set<ITestResult> resultSet = tests.getResults(method);
			
						
			//System.out.println(resultSet);
			//generateForResult(result, method, resultSet.size());
			//m_out.println("<p class=\"totop\"><a href=\"#summary\">back to summary</a></p>");

		}
	}
}

