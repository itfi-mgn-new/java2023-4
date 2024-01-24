package lesson20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try(final Connection	conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?connectTimeout=0","postgres","postgres")) {
			System.err.println("Connected");
			
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			
			try(final Statement	stmt = conn.createStatement()) {
				System.err.println("REsult="+stmt.executeUpdate("create table if not exists z (y integer)"));
				
				try(final PreparedStatement	pstmt = conn.prepareStatement("insert into z(y) values(?)")) {
					pstmt.setInt(1, 100);
					System.err.println("REsult="+pstmt.executeUpdate());
					pstmt.setInt(1, 200);
					System.err.println("REsult="+pstmt.executeUpdate());
				}
//				System.err.println("REsult="+stmt.executeUpdate("insert into z(y) values(100)"));
//				System.err.println("REsult="+stmt.executeUpdate("insert into z(y) values(200)"));
				
				
				
				
				System.err.println("REsult="+stmt.executeUpdate("insert into z(y) select y from z"));

				try(final ResultSet	rs = stmt.executeQuery("select *, 100 as col2 from z")) {
					final ResultSetMetaData meta = rs.getMetaData();
					
					for(int index = 1; index <= meta.getColumnCount(); index++) {
						System.err.println("Col ["+index+"]="+meta.getColumnName(index));
					}
					
					
					while (rs.next()) {
						System.err.println("Y="+rs.getInt("y")+"/"+rs.getInt(1));
					}
				}
				System.err.println("REsult="+stmt.executeUpdate("delete from z"));
			}
			
			conn.commit();
		}
	}
}
