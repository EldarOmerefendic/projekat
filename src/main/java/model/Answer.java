package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the answer database table.
 * 
 */
@Entity
@NamedQuery(name="Answer.findAll", query="SELECT o FROM Answer o")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int correct;

	private String tekst;
	
	public Answer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTacan() {
		return this.correct;
	}

	public void setTacan(int correct) {
		this.correct = correct;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

}