 package atm;

import java.util.Scanner;

public class Wthdraw {
	
	public double performWithdraw(Scanner sc)
	{
		System.out.println("Enter amount to withdraw");
		double withamount=sc.nextDouble();
		
		if(withamount>0)
		{
			if(balance>0 && withamount<balance)
			{
				
			}
		}
	} 

}
