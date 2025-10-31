package lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quiz")
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private long quesNum;
	private int timeQuiz;

	public Quiz(long id, String name, long quesNum, int timeQuiz) {
		super();
		this.id = id;
		this.name = name;
		this.quesNum = quesNum;
		this.timeQuiz = timeQuiz;
	}

	public Quiz() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getQuesNum() {
		return quesNum;
	}

	public void setQuesNum(long quesNum) {
		this.quesNum = quesNum;
	}

	public int getTimeQuiz() {
		return timeQuiz;
	}

	public void setTimeQuiz(int timeQuiz) {
		this.timeQuiz = timeQuiz;
	}

}
