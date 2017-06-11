package imse.SS2017.team1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import imse.SS2017.team1.model.Address;

public class Dao implements DaoInterface {
	EntityManagerFactory entitymanagerfactory;
	EntityManager entitymanager;

	public Dao() {
		entitymanagerfactory = Persistence.createEntityManagerFactory("Online_Shopping_System");
		entitymanager = entitymanagerfactory.createEntityManager();
	}

	@Override
	public <T> void save(T entity) {
		EntityTransaction tx = entitymanager.getTransaction();
		try {
			tx.begin();
			entitymanager.persist(entity);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw ex;
		}
	}
	
	public void close() {
		entitymanager.close();
		entitymanagerfactory.close();
	}
/*
	public <T> Integer saveAddress(Address entity) {
		EntityTransaction tx = entitymanager.getTransaction();
		try {
			tx.begin();
			entitymanager.persist(entity);
			tx.commit();
			return entity.getAdressId();
		} catch (RuntimeException ex) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw ex;
		}
	}
*/
	@Override
	public <T> void delete(T entity) {
		EntityTransaction tx = entitymanager.getTransaction();
		try {
			tx.begin();
			entitymanager.remove(entitymanager.merge(entity));
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null && tx.isActive())
				tx.rollback();
			throw ex;
		}
	}

	@Override
	public <T> T getobject(Class<T> cls, Integer Id) {
		try {
			return (T) entitymanager.find(cls, Id);
		} finally {
			;
		}
	}

	@Override
	public <T> T getobject(Class<T> cls, String Id) {
		try {
			return (T) entitymanager.find(cls, Id);
		} finally {
			;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getobjects(Class<T> cls) {
		return entitymanager.createQuery("SELECT a FROM " + cls.getSimpleName() + " a").getResultList();
	}

	@Override
	public <T> void updateEntity(Object entity) {
		EntityTransaction tx = entitymanager.getTransaction();
		System.out.println("updateEntity has been called");
		try {
			tx.begin();
			entitymanager.merge(entity);
			System.out.println("after merge");
			tx.commit();
		} finally {
			;
		}
	}
}
