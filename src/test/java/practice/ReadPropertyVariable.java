package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadPropertyVariable {
	
	@Test
	public void runPropertyVariable(){
		
		String url=System.getProperty("URL");
		System.out.println("url: "+url);
		String browser=System.getProperty("BROWSER");
		System.out.println("browser: "+browser);
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			 driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Enter valid browser name!!!");
		}
		
		driver.get(url);
	}

}
