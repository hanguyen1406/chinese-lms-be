package lms.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rating")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 1000000)
	private String content;
	private int numStar;
	private Date timeRating;
	private Long userId;
	private Long courseId;

	public Rating(long id, String content, int numStar, Date timeRating, Long userId, Long courseId) {
		super();
		this.id = id;
		this.content = content;
		this.numStar = numStar;
		this.timeRating = timeRating;
		this.userId = userId;
		this.courseId = courseId;
	}

	public Rating() {
		super();
	}

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

	public int getNumStar() {
		return numStar;
	}

	public void setNumStar(int numStar) {
		this.numStar = numStar;
	}

	public Date getTimeRating() {
		return timeRating;
	}

	public void setTimeRating(Date timeRating) {
		this.timeRating = timeRating;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

}
