package com.crm.comcast.organizationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.JavaUtility;

@Listeners(com.crm.comcast.genericutility.ListnersIMP.class)
public class CreateORganizationTest extends BaseClass{

	@Test(groups = "smokeTest")
	public void createOrgTest() throws Throwable {
		
		/*read test script data*/
		int ranDomNum =  JavaUtility.getRanDomNum();
		 String orgName = eLib.getExcelData("org", 1, 2) + ranDomNum;
		 

	
		 
		/*step 2 : navigate to Orgnization Page*/ 
		   driver.findElement(By.linkText("Organizations")).click();
		  
		/*step 3 : navigate to create Orgnization Page*/ 
		   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		   
		/*step 4 : create new Orgnization*/
		   driver.findElement(By.name("accountname")).sendKeys(orgName);
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   
		/*step 5 : create new Verify*/  
		   String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			  if(actSuccessFullMsg.contains(orgName)) {
				  System.out.println(orgName + "==>Orgnization created successfully==>PASS");
			  }else {
				  System.out.println(orgName + "==>Orgnization not created ==>Fail");

			  }
			  
			  

			  

	}
	
	@Test(groups="regressionTest")
	public void createOrgwithType() throws Throwable {
		/*read test script data*/
		int ranDomNum =  JavaUtility.getRanDomNum();
		 String orgName = eLib.getExcelData("org", 7, 2) + ranDomNum;
		 String orgType = eLib.getExcelData("org", 7, 3);

	
		 
		/*step 2 : navigate to Orgnization Page*/ 
		   driver.findElement(By.linkText("Organizations")).click();
		  
		/*step 3 : navigate to create Orgnization Page*/ 
		   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		   
		/*step 4 : create new Orgnization*/
		   driver.findElement(By.name("accountname")).sendKeys(orgName);
		   WebElement wb = driver.findElement(By.name("accounttype"));
		   wLib.select(wb,orgType);
		   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   
		/*step 5 : create new Verify*/  
		   String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			  if(actSuccessFullMsg.contains(orgName)) {
				  System.out.println(orgName + "==>Orgnization created successfully==>PASS");
			  }else {
				  System.out.println(orgName + "==>Orgnization not created ==>Fail");

			  }

	}

}
