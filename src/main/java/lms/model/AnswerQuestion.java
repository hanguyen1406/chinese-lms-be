package lms.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "answer_question")
public class AnswerQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long userId;

	@Column(nullable = false)
	private Long quizId;

	@Column(nullable = false)
	private Long questionId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public Date getAnsweredAt() {
		return answeredAt;
	}

	public void setAnsweredAt(Date answeredAt) {
		this.answeredAt = answeredAt;
	}

	public AnswerQuestion() {
		super();
	}

	public AnswerQuestion(Long id, Long userId, Long quizId, Long questionId, String userAnswer, Date answeredAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.quizId = quizId;
		this.questionId = questionId;
		this.userAnswer = userAnswer;
		this.answeredAt = answeredAt;
	}

	@Column(nullable = false)
	private String userAnswer; // a,b,c,d

	private Date answeredAt;
}