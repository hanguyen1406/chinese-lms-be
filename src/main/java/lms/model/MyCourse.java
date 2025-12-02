package lms.model;

import javax.persistence.*;

@Entity
@Table(name = "my_course")
public class MyCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long courseId;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public MyCourse(Long id, Long courseId, Long userId, double completionProgress, int status) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.userId = userId;
		this.completionProgress = completionProgress;
		this.status = status;
	}

	private Long userId;
	private double completionProgress;
	private int status;
	

	

	public double getCompletionProgress() {
		return completionProgress;
	}

	public void setCompletionProgress(double completionProgress) {
		this.completionProgress = completionProgress;
	}

}
