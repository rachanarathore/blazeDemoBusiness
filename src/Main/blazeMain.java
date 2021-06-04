package Main;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class blazeMain {
public static void main(String [] args) {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\rathodr\\eclipse-workspace\\blazeDemo\\chromedriver");
	WebDriver driver;
	driver = new ChromeDriver();
     driver.get("https://blazedemo.com/");   
     Scenarios sc=new Scenarios(driver);
     sc.callScenarios();
     sc.scenario1();
     sc.scenario2();
}
}
