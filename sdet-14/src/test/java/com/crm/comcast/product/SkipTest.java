package com.crm.comcast.product;


import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTest {

	@Test(groups = {"smokeTest"})
	public void test() {
		throw new SkipException("This method is skipped");
	}
}
