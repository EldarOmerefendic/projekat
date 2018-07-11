package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashMap;
import java.util.List;


/**
 * The persistent class for the quiz database table.
 * 
 */
@Entity
@NamedQuery(name="Quiz.findAll", query="SELECT k FROM Quiz k")
public class Quiz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int isActive;

	private String quizName;

	@Column(name="user_id", nullable=false, length=11,
	        updatable=false, insertable=false)
	private int user_id;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-many association to Question
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name="quiz_question"
		, joinColumns={
			@JoinColumn(name="quiz_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="question_id")
			}
		)
	private List<Question> questions;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="quiz", cascade = CascadeType.ALL)
	private List<Result> results;

	public Quiz() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsActive() {
		return this.isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getQuizName() {
		return this.quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Question> getPitanja() {
		return this.questions;
	}

	public void setPitanja(List<Question> questions) {
		this.questions = questions;
	}

	public List<Result> getResulti() {
		return this.results;
	}

	public void setResulti(List<Result> results) {
		this.results = results;
	}

	public Result addResulti(Result results) {
		getResulti().add(results);
		results.setQuiz(this);

		return results;
	}

	public Result removeResulti(Result results) {
		getResulti().remove(results);
		results.setQuiz(null);

		return results;
	}
	
	public HashMap<String, String> toMap() {
		HashMap<String, String> mapa = new HashMap<String, String>();
		mapa.put("id", new Integer(id).toString());
		mapa.put("quizName", quizName);
		mapa.put("isActive", new Integer(isActive).toString());
		mapa.put("userId", new Integer(user.getId()).toString());
		return mapa;
	}

}