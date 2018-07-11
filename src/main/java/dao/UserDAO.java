package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.User;

public class UserDAO extends AbstractDAO {
	
	public UserDAO() {}
	
	public List<User> findAll() {
		EntityManager em = createEntityManager();
		Query q = em.createQuery("SELECT u FROM User u");
		@SuppressWarnings("unchecked")
		List<User> resultList = q.getResultList();
		em.close();
		return resultList;
	}
	
	public User findByUsername(String username) {
		EntityManager em = createEntityManager();
		try {
			Query q = em.createQuery("SELECT u FROM User u WHERE u.username = :username").setParameter("username", username);
			User user = (User) q.getSingleResult();
			return user;					
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		} finally {		
			if (em!= null) {
				em.close();
			}
		}		
		return null;
	}
	
	public boolean deleteById(int userId) {
		EntityManager em = createEntityManager();
		try {
			Query q = em.createQuery("SELECT u FROM User u WHERE u.id = :userId").setParameter("userId", userId);
			User user = (User) q.getSingleResult();
			if(user.getSuperadmin()==1) {
				return false;
			}
			System.out.println("DELETING: " + user.getUsername() + " - " + user.getId());
			em.getTransaction().begin();
			em.remove(user);			
			em.getTransaction().commit();
			return true;					
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		} finally {		
			if (em!= null) {
				em.close();
			}
		}		
		return false;
	}
	
	public boolean save(User user) {
		EntityManager em = createEntityManager();		
		try {
			Query q = em.createQuery("SELECT u FROM User u WHERE u.username = :username").setParameter("username", user.getUsername());
			q.getSingleResult();
			return false;
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();			
		} finally {		
			if (em!= null) {
				em.close();
			}
		} 
		return true;
	}
}