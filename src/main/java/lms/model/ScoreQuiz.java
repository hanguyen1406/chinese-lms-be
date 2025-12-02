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
	private Date started_at;
	private Date finished_at;
	

	public Date getStarted_at() {
		return started_at;
	}

	public void setStarted_at(Date started_at) {
		this.started_at = started_at;
	}

	public Date getFinished_at() {
		return finished_at;
	}

	public void setFinished_at(Date finished_at) {
		this.finished_at = finished_at;
	}

	public ScoreQuiz(long id, Long quizId, Long userId, double score, Date started_at, Date finished_at) {
		super();
		this.id = id;
		this.quizId = quizId;
		this.userId = userId;
		this.score = score;
		this.started_at = started_at;
		this.finished_at = finished_at;
	}

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

	

	public ScoreQuiz() {
		super();
	}

	
}
