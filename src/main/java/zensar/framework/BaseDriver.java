package zensar.framework;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseDriver {

	private static WebDriver driver;
	
	private BaseDriver(){
		init();
	}
	
	public static BaseDriver getInstance() {
		return new BaseDriver();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void init() {
		startChrome();
	}
	
	public void startChrome() {
		/*
		String driverLocation = "D:\\eclipse_api_workspace\\rest\\Drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverLocation);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-popup-blocking");//version
		options.addArguments("version");
		//options.addArguments("--incognito");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
				
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.merge(capabilities);
		
		driver = new ChromeDriver(options);
		*/
		
		String nodeURL = "http://localhost:4444";
        System.out.println("Chrome Browser Initiated");
        DesiredCapabilities capabilities = new DesiredCapabilities();          
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        
        try {
        driver = new RemoteWebDriver(new URL(nodeURL),capabilities);
        }
        catch(Exception e) {
        	System.out.println(e);
        }
	}
	
	public void clickElement(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}
	
	
}
