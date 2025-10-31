package lms.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ScoreQuiz")
public class ScoreQuiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Long quizId;
	private Long userId;
	private double score;
	private Date date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ScoreQuiz() {
		super();
	}

	public ScoreQuiz(long id, Long quizId, Long userId, double score, Date date) {
		super();
		this.id = id;
		this.quizId = quizId;
		this.userId = userId;
		this.score = score;
		this.date = date;
	}

}
