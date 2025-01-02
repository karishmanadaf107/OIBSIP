package guessingnumber;
import java.util.Scanner;
import java.util.Random;

public class GuessingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("WELCOME TO GUESS THE NUMBER!!!!!");
		Scanner sc=new Scanner(System.in);
		Random rn=new Random();
		
		
		
		int totalScore = 0,rounds = 1,points=100;
		while(true)
		{
			
			int attempts=0,number,maxAttempts=5;
			boolean guessed=false;
			System.out.println("round "+rounds);
			int generatedRandomNumber=rn.nextInt(100)+1;
			
			while(attempts<maxAttempts)
			{
			
		System.out.println("Guess the number between 1 to 100");
		number=sc.nextInt();
		attempts++;
		if(number==generatedRandomNumber)
		{
			System.out.println("CONGRATULATIONS YOU HAVE GUESSED THE RIGHT NUMBER"+generatedRandomNumber);
			guessed=true;
			break;
		}
		else if(number<generatedRandomNumber)
		{

			System.out.println("the  number is  less, TRY AGAIN !");
		}
		
		else if(number>generatedRandomNumber)
		{

			System.out.println("the  number is  high, TRY AGAIN !");
		}
		
		
		}
			points=points-20;
			if(!guessed)
			{
				System.out.println("SORRY YOU HAVE GUESSED THE WRONG NUMBER"+generatedRandomNumber);
			}
			
			totalScore=totalScore+points;
			
			System.out.println("your scored points "+points+ " in the " +rounds+ " round");
			System.out.println("your total scoreis "+totalScore);
			System.out.println("do you want to play another round(yes/no)?");
			String choice=sc.next();
			if(!choice.equalsIgnoreCase("yes"))
			{
				
				break;
			}


rounds++;
		}
	
		
		System.out.println("THANK YOU FOR PLAYING,YOUR TOTAL SCORE IS "+totalScore);
		sc.close();

		
		
		

		
	}

}
