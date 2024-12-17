package onlinereservationsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;



public class MainMethod {
	

    final static String DB_USER="root";
    final static String DB_PASSWORD="Root";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
//		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String DB_URL="jdbc:mysql://localhost:3306/onlinereservationsystem";
		
		Scanner scanner=new Scanner(System.in);
		   System.out.println("WELCOME TO ONLINE RESERVATION SYSTEM");
		
		   System.out.println("choose the action");
		
		System.out.println("\n 1. Signup");
		
		System.out.println("\n 2. for login ,reservation and cancelreservation");
		
		int opt=scanner.nextInt();
		Connection connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		
		
		switch(opt)
		{
		case 1:
			
			Signup.signup(connection,scanner);
			
		break;
		
		case 2:
		{
		
		try(Connection connection1=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD))
		{
			if(Login.login(connection1,scanner))
			{
				boolean exit=false;
				while(!exit)
				{
					
					System.out.println("\n 1.Make a Reservation");
					System.out.println("\n 2. cancel Reservation");
					System.out.println("\n 3.EXIT");
					System.out.println("\n Enter your choice");
					int choice=scanner.nextInt();
					
					switch(choice)
					{
					
					
					case 1:Reservation.makeReservation(scanner,connection1);
					break;
					
					case 2:ReservationCancel.cancelReservation(connection1,scanner);
					break;
					
					case 3: exit=true;
					break;
					
					default: System.out.println("invalid choice please try again");
					}
					
					
					
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			scanner.close();
		}
		}
		break;

	}

	}
}
