package lesson18;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try(final Connection	c = DriverManager.getConnection("jdbc:oracle:this://localhost:1521","vassya","petya")) {
			
			try(final Statement	stmt = c.createStatement()) {
				
				try(final ResultSet	rs = stmt.executeQuery("select 1, 100 from dual")) {
					while (rs.next()) {
						System.err.println("F: "+rs.getString(1));
					}
				}
			}
			
			try(final PreparedStatement	pstmt = c.prepareStatement("insert into x(y) values (?)")) {
				pstmt.setInt(1,100);
				pstmt.executeUpdate();
				pstmt.setInt(1,120);
				pstmt.executeUpdate();
			}
			
			final DatabaseMetaData	m = c.getMetaData();
			
		
		}
	}

}
