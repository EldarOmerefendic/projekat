package model;

import java.io.Serializable;
import java.util.HashMap;

import javax.persistence.*;


/**
 * The persistent class for the Result database table.
 * 
 */
@Entity
@NamedQuery(name="Result.findAll", query="SELECT r FROM Result r")
public class Result implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String points;

	private int date;

	private String email;

	private String name;

	//bi-directional many-to-one association to Quiz
	@ManyToOne(fetch=FetchType.LAZY)
	private Quiz quiz;

	public Result() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBodovi() {
		return this.points;
	}

	public void setBodovi(String points) {
		this.points = points;
	}

	public int getDatum() {
		return this.date;
	}

	public void setDatum(int date) {
		this.date = date;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Quiz getQuiz() {
		return this.quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	public HashMap<String, String> toMap() {
		HashMap<String, String> mapa = new HashMap<String, String>();
		mapa.put("id", new Integer(id).toString());
		mapa.put("quiz", quiz.getQuizName());		
		mapa.put("points", new Integer(points).toString());
		mapa.put("email", email);
		return mapa;
	}

}