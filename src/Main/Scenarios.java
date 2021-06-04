package Main;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Scenarios {
	static WebDriver driver = null;

	public static void verifyCostsInPurchasePage() {
		try {
			String cost=driver.findElement(By.xpath("//div[@class='container']/table/tbody/tr[1]/td[6]")).getText();
			String costAtPurchasePage= driver.findElement(By.xpath("//p/em")).getText();
			if(cost.equals(costAtPurchasePage)) {
				System.out.println("Cost is Matched");
			}else {
				System.out.println("Cost does not match");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void verifyCostsInConfirmationPage() {
		try {
			String cost=driver.findElement(By.xpath("//div[@class='container']/table/tbody/tr[1]/td[6]")).getText();
			String costAtConfirmationPage=driver.findElement(By.xpath("//td[text()='Amount']/following-sibling::td")).getText();
			if(costAtConfirmationPage.contains(cost))
				System.out.println("Cost is matched");
			else
				System.out.println("Cost is not matched");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Scenarios(WebDriver driver) {
		this.driver=driver;
	}
	//Book flight tickets
	public static void callScenarios() {
		HashMap<String, String> hmap= new HashMap<String,String>();
	     hmap.put("Name", "John");
	     hmap.put("Address", "123 main st");
	     hmap.put("City", "ABC");
	     hmap.put("State", "val");
	     hmap.put("Zip Code", "123456");
	     hmap.put("Credit Card Number", "123456789");
	     hmap.put("Name on Card", "John");
	     blazeBusiness bb=new blazeBusiness(driver);
	     bb.selectSrcDest("Paris", "Buenos Aires");
	    bb.bookTickets(hmap);
	    bb.findConfirmationId();
	}
	
	//Verify cost in purchase and reserve page
	public static void scenario1() {
		HashMap<String, String> hmap= new HashMap<String,String>();
	     hmap.put("Name", "John");
	     hmap.put("Address", "123 main st");
	     hmap.put("City", "ABC");
	     hmap.put("State", "val");
	     hmap.put("Zip Code", "123456");
	     hmap.put("Credit Card Number", "123456789");
	     hmap.put("Name on Card", "John");
	     blazeBusiness bb=new blazeBusiness(driver);
	     bb.selectSrcDest("Paris", "Buenos Aires");
		    bb.bookTickets(hmap);
	}
	
	//verify cost in reserve page and confirmation page
	public static void scenario2() {
		HashMap<String, String> hmap= new HashMap<String,String>();
	     hmap.put("Name", "John");
	     hmap.put("Address", "123 main st");
	     hmap.put("City", "ABC");
	     hmap.put("State", "val");
	     hmap.put("Zip Code", "123456");
	     hmap.put("Credit Card Number", "123456789");
	     hmap.put("Name on Card", "John");
	     blazeBusiness bb=new blazeBusiness(driver);
	     bb.selectSrcDest("Paris", "Buenos Aires");
		    bb.bookTickets(hmap);
		    bb.findConfirmationId();
		    verifyCostsInConfirmationPage();
	}
}
