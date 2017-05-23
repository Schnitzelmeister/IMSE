package at.ac.ac.univie.imse.SS2017.team1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import at.ac.ac.univie.imse.SS2017.team1.model.Customer;

public class DatabaseAccess<T>{
	
	Connection connection;
	Statement statement;
	
	public DatabaseAccess() {
		// ESTABLISH RDBMS CONNECTION
		try{
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ourshop?user=root&password=");
			statement = connection.createStatement();
		} catch (SQLException e) {
			throw new IllegalArgumentException("Die Verbindung zur Datenbank konnte nicht erstellt werden");
		}
		// ESTABLISH RDBMS CONNECTION
	}
	
	public void create(T entity){
		if(entity instanceof Customer){
			
		}
	}
	
	public void update(T entity){
		
	}
	
	public void delete(T entity){
		
	}
	
	/*
	public T getObjectByClassAndId(Class<T> cls, String id){
		
	}
	*/
	
	public List<T> getAllObjectsByClass(){
		List<T> allObjects = new ArrayList<T>();
		return allObjects;
	}
	
	public boolean isEmailInUse(String email) throws SQLException{
		String queryCustomer = "SELECT emailAddress FROM customer WHERE emailAdresse LIKE "+email;
		String queryAdmin = "SELECT emailAddress FROM admin WHERE emailAdresse LIKE "+email;
		
		ResultSet resultCustomer = statement.executeQuery(queryCustomer);
		ResultSet resultAdmin = statement.executeQuery(queryAdmin);
		
		if(resultCustomer.next())
			return true;
		else
			return false;
	}
}
