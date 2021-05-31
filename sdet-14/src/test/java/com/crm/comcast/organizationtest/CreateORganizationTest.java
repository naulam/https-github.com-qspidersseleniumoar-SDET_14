package com.crm.comcast.organizationtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.objectrepository.CreateNewOrganizationPage;
import com.crm.comcast.objectrepository.HomePage;
import com.crm.comcast.objectrepository.OrganizationInfoPage;
import com.crm.comcast.objectrepository.OrganizationsPage;

@Listeners(com.crm.comcast.genericutility.ListnersIMP.class)
public class CreateORganizationTest extends BaseClass{

	@Test(groups = "smokeTest")
	public void createOrgTest() throws Throwable {
		
		/*read test script data*/
		int ranDomNum =  JavaUtility.getRanDomNum();
		 String orgName = eLib.getExcelData("org", 1, 2) + ranDomNum;
		 	 
		/*step 2 : navigate to Orgnization Page*/ 
		   //driver.findElement(By.linkText("Organizations")).click();
		 
		 HomePage hp = new HomePage(driver);
		 hp.navigateOrg();
		 
		/*step 3 : navigate to create Orgnization Page*/ 
		   //driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		 
		 OrganizationsPage org = new OrganizationsPage(driver);
		 org.createOrg();
		   
		/*step 4 : create new Orgnization*/
		   //driver.findElement(By.name("accountname")).sendKeys(orgName);
		   //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		 cno.createOrganization(orgName);
		   
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
		 //String orgType = eLib.getExcelData("org", 7, 3);

	
		 
		/*step 2 : navigate to Organization Page*/ 
		  OrganizationsPage org = new OrganizationsPage(driver);
		  org.createOrg();
		  
		/*step 3 : navigate to create Organization Page*/ 
		   CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		   cno.createOrganization(orgName);
		   
		/*step 5 : create new Verify*/ 
		   OrganizationInfoPage oif = new OrganizationInfoPage(driver);
		   String actSuccessFullMsg = oif.getSuccessfulMsg().getText();
		   
		   Assert.assertTrue(actSuccessFullMsg.contains(orgName));
		   

	}

}
