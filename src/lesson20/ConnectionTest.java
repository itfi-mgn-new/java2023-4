package lesson20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try(final Connection	conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?connectTimeout=0","postgres","sasa21")) {
			System.err.println("Connected");
		}
	}

}
