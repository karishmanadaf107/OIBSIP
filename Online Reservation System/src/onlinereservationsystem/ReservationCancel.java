package onlinereservationsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ReservationCancel {
	
	static void cancelReservation(Connection connection,Scanner scanner) throws SQLException
	{
		System.out.println("enter your PNR number");
		String PNR=scanner.next();
		
		String reservationDetails="select * from reservations where pnr=? ";
		try(PreparedStatement preparedStatement=connection.prepareStatement(reservationDetails))
		{
			preparedStatement.setString(1, PNR);
			
			try(ResultSet resultset=preparedStatement.executeQuery())
			{
				if(resultset.next())
				{
					System.out.println("Reservation Details");
					System.out.println("Train Number: "+resultset.getInt("trainno"));
					System.out.println("Class type: "+resultset.getString("classType"));
					System.out.println("Date of journey"+resultset.getString("dateOfJourney"));
					System.out.println("From place"+resultset.getString("fromPlace"));
					System.out.println("To place"+resultset.getString("toPlace"));
					System.out.println("Are you sure you want to cancey this reservation? (yes/no)");
					String confirmation=scanner.next();
					
					if(confirmation.equalsIgnoreCase("yes"))
					{
						String delete="delete from reservations where pnr=?";
						try(PreparedStatement preparedStatement1=connection.prepareStatement(delete))
						{
							preparedStatement1.setString(1,PNR);
							preparedStatement1.executeUpdate();
							System.out.println("Reservation cancelled successfully");
							
							
						}
					}
					else
					{
						System.out.println("cancellation aborted");
					}
					 
				}
				else
				{
					System.out.println("Invalid PNR please try again");
				}
			 
			}
		}
		
		
	}

}
