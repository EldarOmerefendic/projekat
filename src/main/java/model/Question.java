package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashMap;
import java.util.List;


/**
 * The persistent class for the Question database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT p FROM Question p")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int points;

	private String question;

	private int time;

	//bi-directional many-to-many association to Quiz
	@ManyToMany(mappedBy="questions")
	private List<Quiz> quizzes;

	//bi-directional many-to-many association to Answer
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="auestion_answer"
		, joinColumns={
			@JoinColumn(name="question_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="answer_id")
			}
		)
	private List<Answer> answers;

	public Question() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoints() {
		return this.points;
	}

	public void setBodovi(int points) {
		this.points = points;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String Question) {
		this.question = Question;
	}

	public int getVrijeme() {
		return this.time;
	}

	public void setVrijeme(int time) {
		this.time = time;
	}

	public List<Quiz> getQuizzes() {
		return this.quizzes;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public HashMap<String, Object> toMap() {
		HashMap<String, Object> mapa = new HashMap<String, Object>();
		mapa.put("id", new Integer(id).toString());
		mapa.put("Question", question);
		mapa.put("time", new Integer(time).toString());
		mapa.put("points", new Integer(points).toString());
		mapa.put("Answers", answers);
		return mapa;
	}	
}