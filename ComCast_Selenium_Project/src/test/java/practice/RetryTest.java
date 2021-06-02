package practice;

import org.junit.Assert;
import org.testng.annotations.Test;

public class RetryTest {
	
	@Test(retryAnalyzer = com.crm.comcast.genericutility.RetryAnalyzer.class)
	public void retryTest() {
		System.out.println("sucess");
		//Assert.assertTrue(false);
	}

}
