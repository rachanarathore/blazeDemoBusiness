package Main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class blazeBusiness {
	static WebDriver driver;

	public static void bookTickets(HashMap<String, String> passengerDet) {
		try {
		Set set = passengerDet.entrySet();
		Iterator iterator= set.iterator();
		while(iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry)iterator.next();
			String text=driver.findElement(By.tagName(mentry.getKey().toString())).getText();
			if(text.equals(mentry.getKey()))
			{
				String path="//label[text()='"+ mentry.getKey() +"']/../div/input";
				driver.findElement(By.xpath(path)).sendKeys(mentry.getValue().toString());
			}
		}Scenarios.verifyCostsInPurchasePage();
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void selectSrcDest(String src,String dest) {
		WebElement start=driver.findElement(By.className("fromPort"));
		Select select =new Select(start);
		select.selectByValue(src);
		WebElement destination=driver.findElement(By.className("toPort"));
		Select select1 =new Select(destination);
		select1.selectByValue(src);
		driver.findElement(By.xpath("//input[@type='submit']")).click();	
		findFligths();
	}
	
	public static void findFligths()
	{
		try {
		WebElement findflight=driver.findElement(By.xpath("//*[text()=\"Flights from Paris to Buenos Aires: \"]"));	
		if(findflight.isDisplayed())
		{
			driver.findElement(By.xpath("//form[@name='VA43']/parent::tr/td/input")).click();
		}else {
			System.out.println("Page not found");
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String findConfirmationId() {
		String confirmationId = null;
		try {
			confirmationId=driver.findElement(By.xpath("//td[text()='Id']/following-sibling::td")).getText();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return confirmationId;
	}
	
	public blazeBusiness(WebDriver driver) {
		this.driver=driver;
	}
}
