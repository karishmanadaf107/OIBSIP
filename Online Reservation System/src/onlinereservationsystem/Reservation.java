package onlinereservationsystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Reservation {
	
	static void makeReservation(Scanner scanner,Connection connection) throws SQLException
	{
		
		System.out.println("enter train number");	
		String trainno=scanner.next();
		
		String trainname="select trainname from trains where trainno=?";
		
		try(PreparedStatement preparedStatement=connection.prepareStatement(trainname))
		{
			preparedStatement.setString(1,trainno );
			
			try(ResultSet resultset=preparedStatement.executeQuery())
			{
				if(resultset.next())
				{				
//				
					
					String PNR="PNR"+System.currentTimeMillis();
					System.out.println("PNR"+System.currentTimeMillis());
					

					System.out.println("enter class type");
					String classType=scanner.next();
					
					System.out.println("enter date of journey in dd-mm-yyyy format");
					String dateofJourney=scanner.next();
					
					
					System.out.println("enter from destination");
					String fromDestination=scanner.next();
					
					System.out.println("enter to destination");
					String toDestination=scanner.next();
					
					
					System.out.println("enter your name");
					String name=scanner.next();
					
					
					System.out.println("enter gender");
					String gender=scanner.next();
					
					
					System.out.println("enter age");
					int age=scanner.nextInt();
					
					
					System.out.println("enter address");
					String address=scanner.next();
					
					String trainame=resultset.getString("trainname");
					System.out.println(trainame);
					
					
					
					
					
					
					

					
//					System.out.println("enter PNR number");
//					String PNR=scanner.next();
					
				
					String reservation="insert into reservations (pnr,trainNo,classType,dateOfJourney,fromPlace,toPlace,name,gender,age,address,trainname) values(?,?,?,?,?,?,?,?,?,?,?)";
					
					try(PreparedStatement preparedStatement1=connection.prepareStatement(reservation))
					{
						preparedStatement1.setString(1, PNR);
						preparedStatement1.setString(2, trainno);
					
						preparedStatement1.setString(3,classType);
						preparedStatement1.setDate(4, Date.valueOf(dateofJourney));
						preparedStatement1.setString(5,fromDestination);
						preparedStatement1.setString(6, toDestination);
						preparedStatement1.setString(7,name);
						preparedStatement1.setString(8,gender);
						preparedStatement1.setLong(9,age);
						preparedStatement1.setString(10,address);
						preparedStatement1.setString(11,trainame);
//						
						
						
						
						preparedStatement1.executeUpdate();
						System.out.println("Reservation Successful! your PNR is"+PNR);
					}
					
					
				}
			else
			{
				System.out.println("Invalid train number please try again");
		}
			}
		}
		
		}

}
