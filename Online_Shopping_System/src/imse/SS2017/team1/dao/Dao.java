package imse.SS2017.team1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Dao implements DaoInterface {
	EntityManagerFactory entitymanagerfactory;

	public Dao(){
		System.out.println("DAO constructor wurde aufgerufen");
	}
	
	@Override
	public <T> void save(T entity) {
		System.out.println("Dao save methode wurde gestartet");
		entitymanagerfactory=Persistence.createEntityManagerFactory("Online_Shopping_System");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		EntityTransaction tx = entitymanager.getTransaction();
		try {
			tx.begin();
			entitymanager.persist(entity);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw ex;
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}
	}

	@Override
	public <T> void delete(T entity) {
		entitymanagerfactory = Persistence.createEntityManagerFactory("Online_Shopping_System");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		EntityTransaction tx = entitymanager.getTransaction();
		try {
			tx.begin();
			entitymanager.remove(entitymanager.merge(entity));
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw ex;
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}
	}

	@Override
	public <T> T getobject(Class<T> cls, Integer Id) {
		entitymanagerfactory = Persistence.createEntityManagerFactory("Online_Shopping_System");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		try {
			return (T) entitymanager.find(cls, String.valueOf(Id));
		} finally {
			entitymanager.close();
		}
	}
	
	@Override
	public <T> T getobject(Class<T> cls, String Id) {
		entitymanagerfactory = Persistence.createEntityManagerFactory("Online_Shopping_System");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		try {
			return (T) entitymanager.find(cls, Id);
		} finally {
			entitymanager.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getobjects(Class<T> cls) {
		entitymanagerfactory = Persistence.createEntityManagerFactory("Online_Shopping_System");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		return entitymanager.createQuery("SELECT a FROM " + cls.getName() + " a").getResultList();
	}

	@Override
	public <T> boolean isEmailTaken(Class<T> cls, String email) {
		entitymanagerfactory = Persistence.createEntityManagerFactory("Online_Shopping_System");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		
		if(null == entitymanager.find(cls, email))
			return false;
		else
			return true;
	}
	
	@Override
	public <T> T getUser(Class<T> cls, String email) {
		entitymanagerfactory = Persistence.createEntityManagerFactory("Online_Shopping_System");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		try {
			return (T) entitymanager.find(cls, email);
		} finally {
			entitymanager.close();
		}
	}
}







