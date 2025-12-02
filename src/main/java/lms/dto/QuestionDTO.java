package lms.dto;

public class QuestionDTO {
	private long id;
	private String content;
	private String a;
	private String b;
	private String c;
	private String d;

	public QuestionDTO() {
		super();
	}

	public QuestionDTO(long id, String content, String a, String b, String c, String d, String answer,
			String explanation, Long quizId, String image_url) {
		super();
		this.id = id;
		this.content = content;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.answer = answer;
		this.explanation = explanation;
		this.quizId = quizId;
		this.image_url = image_url;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	private String answer;
	private String explanation;
	private Long quizId;
	private String image_url;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
