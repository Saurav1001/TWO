package WebDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	
public static void main(String[] args) throws InterruptedException{
		
		try {
			Connection connect = DriverManager.getConnection(null, null, null);
			//also add sql dependency in pom.xml
			if(connect.isClosed()) {
				System.out.println("no connection");
			}else
				System.out.println("connection is there");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
