package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	private String password;

	private int superadmin;

	private String username;

	//bi-directional many-to-one association to Quiz
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<Quiz> quizzes;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSuperadmin() {
		return this.superadmin;
	}

	public void setSuperadmin(int superadmin) {
		this.superadmin = superadmin;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Quiz> getQuizzes() {
		return this.quizzes;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	public Quiz addQuizzes(Quiz quizzes) {
		getQuizzes().add(quizzes);
		quizzes.setUser(this);

		return quizzes;
	}

	public Quiz removeQuizzes(Quiz quizzes) {
		getQuizzes().remove(quizzes);
		quizzes.setUser(null);

		return quizzes;
	}

}