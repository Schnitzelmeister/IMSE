package imse.SS2017.team1.database;

import java.sql.*;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;

	public void readDataBase() throws Exception {
        try {
        	
           //Class.forName("oracle.jdbc.driver.OracleDriver");
            		
           Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/imse", "root", "tarik1983");
                			
           Statement statement=connect.createStatement();
                    
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

	private void close() {
		try {

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}