package imse.SS2017.team1.database;

import imse.SS2017.team1.dao.Dao;
import imse.SS2017.team1.model.Admin;

public class ok {

	public static void main(String[] args) {
		Dao dao = new Dao();
		
		System.out.println("Chef-Admin wird generiert!");
		Admin admin = new Admin();
		admin.setEmailAddress("admin@hotmail.com");
		admin.setFirstName("main");
		admin.setLastName("admin");
		admin.setManagerEmailAddress("admin@hotmail.com");
		admin.setPassword("admin");
		admin.setVerified(true);
		dao.save(admin);

	}

}
