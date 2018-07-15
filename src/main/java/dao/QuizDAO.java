package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Quiz;
import model.Question;

public class QuizDAO extends AbstractDAO {
	
	public QuizDAO() {
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Quiz> findAll() {
		EntityManager em = createEntityManager();
		Query q = em.createQuery("SELECT u FROM Quiz u");
		List<Quiz> resultList = q.getResultList();
		em.close();
		return resultList;
	}
	
	public List<Quiz> findAllActive() {
		EntityManager em = createEntityManager();
		Query q = em.createQuery("SELECT u FROM Quiz u WHERE u.isActive = :isActive").setParameter("isActive", 1);
		List<Quiz> resultList = q.getResultList();
		em.close();
		return resultList;
	}
	
	public List<Quiz> findByUserId(int userId) {
		EntityManager em = createEntityManager();
		Query q = em.createQuery("SELECT u FROM Quiz u WHERE u.user_id = :userId").setParameter("userId", userId);
		List<Quiz> resultList = (List<Quiz>)q.getResultList();
		em.close();
		return resultList;
	}
	
	public Quiz findById(int quizId) {
		EntityManager em = createEntityManager();
		try {
			Query q = em.createQuery("SELECT u FROM Quiz u WHERE u.id = :quizId").setParameter("quizId", quizId);
			Quiz quiz = (Quiz) q.getSingleResult();
			return quiz;					
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		} finally {		
			if (em!= null) {
				em.close();
			}
		}		
		return null;
	}
	
	public Question findQuestionById(int questionId) {
		EntityManager em = createEntityManager();
		try {
			Query q = em.createQuery("SELECT u FROM Question u WHERE u.id = :questionId").setParameter("questionId", questionId);
			Question p = (Question) q.getSingleResult();
			return p;					
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		} finally {		
			if (em!= null) {
				em.close();
			}
		}		
		return null;
	}
	
	public boolean deleteById(int quizId) {
		EntityManager em = createEntityManager();
		try {
			Query q = em.createQuery("SELECT u FROM Quiz u WHERE u.id = :quizId").setParameter("quizId", quizId);
			Quiz quiz = (Quiz) q.getSingleResult();
			System.out.println("DELETING: " + quiz.getQuizName() + " - " + quiz.getId());
			em.getTransaction().begin();
			em.remove(quiz);			
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
	
	public boolean deleteQuestionById(int questionId) {
		EntityManager em = createEntityManager();
		try {
			Query q = em.createQuery("SELECT u FROM Question u WHERE u.id = :questionId").setParameter("questionId", questionId);
			Question question = (Question) q.getSingleResult();
			System.out.println("DELETING: " + question.getQuestion() + " - " + question.getId());
			em.getTransaction().begin();
			em.remove(question);			
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
	
	public boolean save(Quiz quiz) {
		EntityManager em = createEntityManager();		
		em.getTransaction().begin();
		em.persist(quiz);
		em.getTransaction().commit();			
		em.close();
		return true;
	}
	
	public boolean merge(Quiz quiz) {
		EntityManager em = createEntityManager();		
		em.getTransaction().begin();
		em.merge(quiz);
		em.getTransaction().commit();			
		em.close();
		return true;
	}
}