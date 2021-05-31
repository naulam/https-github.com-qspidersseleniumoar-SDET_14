package com.crm.comcast.organizationtest;

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
public class CreateORganizationWithIndustries extends BaseClass{
	
    @Test(groups = "regressionTest")
    public void createOrhWithIndustried() throws Throwable {		
		/*read test script data*/

		 String orgName = eLib.getExcelData("org", 4, 2) + JavaUtility.getRanDomNum();
		 String industry = eLib.getExcelData("org", 4, 3); 
		 
		
		/*step 2 : navigate to Orgnization Page*/ 
		 HomePage hp = new HomePage(driver);
		 hp.navigateOrg();
		  
		/*step 3 : navigate to create Orgnization Page*/ 
		 OrganizationsPage org = new OrganizationsPage(driver);
		 org.createOrg();
		   
		/*step 4 : create new Orgnization*/
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createOrgWithIndustry(orgName, industry);
		   
		/*step 5 : Verify orgname & industries*/
		   OrganizationInfoPage oif = new OrganizationInfoPage(driver);
		   String actSuccessFullMsg = oif.getSuccessfulMsg().getText();
		   Assert.assertTrue(actSuccessFullMsg.contains(orgName));
			  
			  

	}

}
