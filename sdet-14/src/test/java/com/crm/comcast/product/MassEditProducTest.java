package com.crm.comcast.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
/**
 * 
 * @author Nitheesha
 *
 */
@Listeners(com.crm.comcast.genericutility.ListnersIMP.class)
public class MassEditProducTest extends BaseClass {
	
	@Test
	public void massEditTest() {
	
		driver.findElement(By.linkText("Products")).click();
		
		List<WebElement> keyboards=driver.findElements(By.xpath("//a[@title='Products' and text()='Keyboard']/ancestor::td/preceding-sibling::td/input[@type='checkbox']"));
		for(int i=0;i<keyboards.size();i++) {
			keyboards.get(i).click();
		}
		
		driver.findElement(By.xpath("//input[@value='Mass Edit']")).click();
		WebElement massEdit = driver.findElement(By.xpath("//td[text()='Mass Edit - Records Fields']"));
		
		wLib.waitForElemnetToBeVisible(driver, massEdit);
		
		driver.findElement(By.xpath("//td[text()='Product Name ']/input[@type='checkbox']")).click();
		
		driver.findElement(By.name("productname")).sendKeys("Mobile");
	}

}
