package lms.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length = 1000000)
	private String contentCmt;
	private Date timeCmt;
	private Long userId;
	private Long courseId;

	public Comment() {
		super();
	}

	public Comment(long id, String contentCmt, Date timeCmt, Long userId, Long courseId) {
		super();
		this.id = id;
		this.contentCmt = contentCmt;
		this.timeCmt = timeCmt;
		this.userId = userId;
		this.courseId = courseId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContentCmt() {
		return contentCmt;
	}

	public void setContentCmt(String contentCmt) {
		this.contentCmt = contentCmt;
	}

	public Date getTimeCmt() {
		return timeCmt;
	}

	public void setTimeCmt(Date timeCmt) {
		this.timeCmt = timeCmt;
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
