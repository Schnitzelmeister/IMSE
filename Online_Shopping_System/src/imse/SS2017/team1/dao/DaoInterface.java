package imse.SS2017.team1.dao;

import java.util.List;

import imse.SS2017.team1.model.Address;
import imse.SS2017.team1.model.User;

public interface DaoInterface {
	
	public <T> void save(T entity);

	public <T> Integer saveAddress(Address entity);
	
	public <T> void delete(T entity);

	public <T> T getobject(Class<T> cls, Integer Id);
	
	public <T> T getobject(Class<T> cls, String Id);

	public <T> List<T> getobjects(Class<T> cls);
	
	//public <T> boolean isEmailTaken(Class<T> cls, String email);
	
	//public <T> T getUser(Class<T> cls, String email);
	
	public <T> void updateEntity(Object entity);
}
