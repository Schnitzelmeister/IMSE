package imse.SS2017.team1.dao;

import java.util.List;

public interface DaoInterface {
	
	public <T> void save(T entity);

	public <T> void delete(T entity);

	public <T> T getobject(Class<T> cls, Integer Id);

	public <T> List<T> getobjects(Class<T> cls);
	
	public <T> boolean isEmailTaken(Class<T> cls, String email);
	
}
