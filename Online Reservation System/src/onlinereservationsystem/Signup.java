   package onlinereservationsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Signup {
	static void signup(Connection connection,Scanner scanner) throws SQLException {
	//	
//		Scanner sc=new Scanner(System.in);

		System.out.println("enter username");
		String username=scanner.next();
		
		
		System.out.println("enter password");
		String password=scanner.next();
		
		
		
		
		System.out.println("enter email id");
		String email=scanner.next();
		
		String signup="insert into signup(username,password)values(?,?,?)";

	
		
		
		try(PreparedStatement statement=connection.prepareStatement(signup))
		{
			statement.setString(1,username);
			statement.setString(2, password);
			statement.setString(3, email);
			statement.executeUpdate();
			
				
					System.out.println("signup successful");
					
				}
			
			
		}
		
		
		
		
		}
		
		



