package hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
	public static void main(String[] args) {
		String jdbcurl="jdbc:mysql://localhost:3306/hibernate?useSSL=false";
		String user="root";
		String pwd="1234";
		try {
			System.out.println("Connecting to"+jdbcurl);
			Connection con=DriverManager.getConnection(jdbcurl,user,pwd);
			System.out.println("Connection Successfull");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
