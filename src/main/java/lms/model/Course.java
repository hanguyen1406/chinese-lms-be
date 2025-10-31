package lms.model;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String name;

	@Column(length = 1000000)
	private String thumbnailUrl;

	@Column(length = 100000)
	private String description;

	private int numRating = 5;
	private int numLesson = 0;
	private Long quizId;

	public Course(long idCourse, String nameCourse, String thumbnailUrl, String description, int numRating,
			int numLesson, Long quizId) {
		super();
		this.id = idCourse;
		this.name = nameCourse;
		this.thumbnailUrl = thumbnailUrl;
		this.description = description;
		this.numRating = numRating;
		this.numLesson = numLesson;
		this.quizId = quizId;
	}

	public Course() {
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

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumRating() {
		return numRating;
	}

	public void setNumRating(int numRating) {
		this.numRating = numRating;
	}

	public int getNumLesson() {
		return numLesson;
	}

	public void setNumLesson(int numLesson) {
		this.numLesson = numLesson;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

}
