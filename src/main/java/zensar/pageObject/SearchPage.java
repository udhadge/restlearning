package zensar.pageObject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {

	WebDriver driver;
	
	public SearchPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void openPage() {
		driver.get("https://www.google.co.in/");
	}
	
	public void countLinks() {
		List<WebElement> l = driver.findElements(By.xpath("//a"));
		System.out.println(l.size());
		
		for(WebElement w: l) {
			System.out.println(w.getText());
		}
	}
	
	public void ddselect() {
		Select s = new Select(driver.findElement(By.xpath("//sf")));
		s.selectByValue("tt");
	}
	
	public void searchTerm(String searchTerm) {
		WebElement searchField= driver.findElement(By.xpath("//input[@aria-label='Search']"));
		searchField.sendKeys(searchTerm);
		searchField.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//span[text()='Images']")).click();
		
		driver.findElements(null);
		//div[@id="islrg"]//div/a	
	}
	
	public void imageSrcDownload() throws IOException {
		WebElement logo = driver.findElement(By.id("wp_thbn_48"));
		String logoSrc = logo.getAttribute("src");
		System.out.println(logoSrc);
		URL imageURL = new URL(logoSrc);
		BufferedImage saveImage = ImageIO.read(imageURL);
		ImageIO.write(saveImage, "png", new File("logo-image.png"));
	}
}
