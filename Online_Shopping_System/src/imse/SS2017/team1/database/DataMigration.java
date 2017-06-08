package imse.SS2017.team1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.Category;

public class DataMigration {
	
	public static void main(String args[]) throws Exception{
	
		Connection connect = null;
		Statement statement = null;
		Dao dao = new Dao();
		Category category = new Category();

			try {

				Class.forName("com.mysql.jdbc.Driver");
				connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/imse",
						"root", "born2kil");
				statement = connect.createStatement();
				
				ResultSet resultset = statement.executeQuery("SELECT * FROM category");
				
				try {
					while(resultset.next()){
			            int numColumns = resultset.getMetaData().getColumnCount();
			            for ( int i = 1 ; i <= numColumns ; i+=2 ) {
			            	category.setCategoryId((Integer) resultset.getObject(i));
			            	category.setCategoryName((String) resultset.getObject(i+1));
			            	dao.save(category);
			            }
					}
				} catch (Exception e){
					throw e;
				}

			} catch (Exception e) {
				throw e;
			} finally {
				
				if (statement != null) {
					statement.close();
				}

				if (connect != null) {
					connect.close();
				}
				
			}
		}
	
	
}
