package at.ac.ac.univie.imse.SS2017.team1.dao;

import java.util.List;

public interface DaoInterface {
	
	public <T> void save(T entity);

	public <T> void delete(T entity);

	public <T> T getobject(Class<T> cls, String Id);

	public <T> List<T> getobjects(Class<T> cls);
	
}
