package at.ac.ac.univie.imse.SS2017.team1.database;

import java.sql.*;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;

	public void readDataBase() throws Exception {
        try {
        	
           //Class.forName("oracle.jdbc.driver.OracleDriver");
         //   z.b. MATRIKELNUMMER -> "a1424234" , PASSWORT -> "Superhansi"
         // connect = DriverManager
             //       .getConnection("jdbc:oracle:thin:@oracle-lab.cs.univie.ac.at:1521:lab","-MATRIKELNUMMER-","-PASSWORT-");
          //// statement = connect.createStatement();

            		
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