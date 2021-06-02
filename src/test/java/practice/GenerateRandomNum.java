package practice;

import java.util.Random;

public class GenerateRandomNum {

	public static void main(String[] args) {
		
		//test 
	
         String orgName = "Skillrary_"+GenerateRandomNum.getRandomData();
         System.out.println(orgName);
    
       
	}
	
	
	public static int getRandomData() {
		Random ram = new Random();
		int randomNum = ram.nextInt(10);
        return randomNum;
	}
	

}
