package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Result;

public class ResultDAO extends AbstractDAO {
	
	public  ResultDAO() {
		
	}
	
	public List<Result> findAll() {
		EntityManager em = createEntityManager();
		Query q = em.createQuery("SELECT u FROM Result u ORDER BY u.bodovi DESC");
		List<Result> resultList = q.getResultList();
		em.close();
		return resultList;
	}
	
	public boolean save(Result result) {
		EntityManager em = createEntityManager();		
			em.getTransaction().begin();
			em.persist(result);
			em.getTransaction().commit();			
			em.close();
		return true;
	}
}