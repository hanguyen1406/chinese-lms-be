package lms.model;

import javax.persistence.*;

@Entity
@Table(name = "my_course")
public class MyCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCourse;
	private Long idUser;
	private double completionProgress;

	public MyCourse(long idCourse, Long idUser, double completionProgress) {
		super();
		this.idCourse = idCourse;
		this.idUser = idUser;
		this.completionProgress = completionProgress;
	}

	public MyCourse() {
		super();
	}

	public long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(long idCourse) {
		this.idCourse = idCourse;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public double getCompletionProgress() {
		return completionProgress;
	}

	public void setCompletionProgress(double completionProgress) {
		this.completionProgress = completionProgress;
	}

}
