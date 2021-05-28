package com.crm.comcast.organizationtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

@Listeners(com.crm.comcast.genericutility.ListnersIMP.class)
public class CreateORganizationWithIndustries extends BaseClass{
	
    @Test(groups = "regressionTest")
    public void createOrhWithIndustried() throws Throwable {		
		/*read test script data*/

		 String orgName = eLib.getExcelData("org", 4, 2) + JavaUtility.getRanDomNum();
		 String industry = eLib.getExcelData("org", 4, 3); 
		 
		
		/*step 2 : navigate to Orgnization Page*/ 
		   driver.findElement(By.linkText("Organizations")).click();
		  
		/*step 3 : navigate to create Orgnization Page*/ 
		   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		   
		/*step 4 : create new Orgnization*/
		   driver.findElement(By.name("accountname")).sendKeys(orgName);
		   WebElement iwb = driver.findElement(By.name("industry"));
           wLib.select(iwb, industry);
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   
		/*step 5 : Verify orgname & industries*/  
		   String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			  if(actSuccessFullMsg.contains(orgName)) {
				  System.out.println(orgName + "==>Orgnization created successfully==>PASS");
			  }else {
				  System.out.println(orgName + "==>Orgnization not created ==>Fail");

			  }
			  
			  String actIndustryMsg = driver.findElement(By.id("dtlview_Industry")).getText();
			  if(actIndustryMsg.contains(industry)) {
				  System.out.println(orgName + "==>Orgnization created with industry successfully==>PASS");
			  }else {
				  System.out.println(orgName + "==>Orgnization not created with industry==>Fail");

			  }

			  

	}

}
