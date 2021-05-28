package practice;

import java.util.Date;

import org.testng.annotations.Test;

public class GetCurrentSystemDateAndTime {
	
	@Test
	public void getDateAndTime() {
		//Fri May 28 13:37:00 IST 2021
		Date date = new Date();
		System.out.println(date.toString().replace(" ", "_").replace(":", "_"));
		
	}

}
