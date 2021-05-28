package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertinsPractice {
	
	@Test
	public void hardAssertionTest() {
		Assert.assertEquals("Nithesh", "Nithesh HS");
		System.out.println("Continue after hard assert");
		
	}
	@Test
	public void SoftAssertionTest() {
		
		SoftAssert sa=new SoftAssert();
		System.out.println("inside the soft Assertion method");
		sa.assertEquals("Nithesh", "Nithesh HS");
		System.out.println("After comparing the firstName");
		sa.assertTrue(false);
		System.out.println("After assert fails");
		sa.assertAll();
	}

}
