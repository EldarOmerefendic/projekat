package service;

import java.util.List;

import dao.QuizDAO;
import model.Quiz;
import model.Question;

public class QuizService {
	
	private QuizDAO QuizDAO;
	
	public QuizService(QuizDAO QuizDAO) {
		this.QuizDAO = QuizDAO;
	}
	
	public boolean create(Quiz quiz) {		
		return QuizDAO.save(quiz);	
	}
	
	public boolean save(Quiz quiz) {		
		return QuizDAO.merge(quiz);	
	}
	
	public boolean removeQuestion(int questionId) {		
		return QuizDAO.deleteQuestionById(questionId);	
	}
	
	public boolean remove(int quizId) {
		return QuizDAO.deleteById(quizId);
	}
	
	public List<Quiz> findAll() {
		return QuizDAO.findAll();
	}
	
	public List<Quiz> findAllActive() {
		return QuizDAO.findAllActive();
	}
	
	public Quiz findById(int quizId) {
		return QuizDAO.findById(quizId);
	}
	
	public List<Quiz> findByUserId(int userId) {
		return QuizDAO.findByUserId(userId);
	}
	
	public Question findQuestionById(int questionId) {
		return QuizDAO.findQuestionById(questionId);
	}
		
}