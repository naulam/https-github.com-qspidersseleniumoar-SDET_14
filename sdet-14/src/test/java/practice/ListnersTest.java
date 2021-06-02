package practice;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;

@Listeners(com.crm.comcast.genericutility.ListnersIMP.class)
public class ListnersTest extends BaseClass{
	
	@Test
	public void listnerTest() {
		
		System.out.println("listning");
		Assert.assertTrue(false);
	}
	
	@Test
	public void listenTest2() {
		System.out.println("listning");
		Assert.assertTrue(false);
	}

}
