package onlinereservationsystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Login {
	
	static boolean login(Connection connection,Scanner sc) throws SQLException {
//	
//	Scanner sc=new Scanner(System.in);
	System.out.print("Enter user name");
	String username=sc.next();
	
	System.out.println("enter password");
	String password=sc.next();
	
	String query="select * from signup where username=? AND password=?";
	
	
	try(PreparedStatement statement=connection.prepareStatement(query))
	{
		statement.setString(1,username);
		statement.setString(2, password);
		try(ResultSet resultset=statement.executeQuery())
		
		{
			if(resultset.next())
			{
				
			String usern=resultset.getString("username");
			String pwd=	resultset.getString("password");
			if(username.equals(usern) && password.equals(pwd))
			{
				
				System.out.println("login successful");
				return true;
			}
			else
			{
				System.out.println("loginfailed");
				return false;
			}   
		}
		
		
	}
	}
	return false;
	}
}
	
	
	
	
	
	
	
	
	


	
