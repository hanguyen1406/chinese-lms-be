package lms.model;

import javax.persistence.*;

@Entity
@Table(name = "lesson")
public class Lesson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLesson;
	private String nameLesson;
	private String contentLesson;
	@Column(length = 1000000)
	private String linkVideo;
	private Long courseId;

	public Lesson(long idLesson, String nameLesson, String contentLesson, String linkVideo, Long courseId) {
		super();
		this.idLesson = idLesson;
		this.nameLesson = nameLesson;
		this.contentLesson = contentLesson;
		this.linkVideo = linkVideo;
		this.courseId = courseId;
	}

	public Lesson() {
		super();
	}

	public long getIdLesson() {
		return idLesson;
	}

	public void setIdLesson(long idLesson) {
		this.idLesson = idLesson;
	}

	public String getNameLesson() {
		return nameLesson;
	}

	public void setNameLesson(String nameLesson) {
		this.nameLesson = nameLesson;
	}

	public String getContentLesson() {
		return contentLesson;
	}

	public void setContentLesson(String contentLesson) {
		this.contentLesson = contentLesson;
	}

	public String getLinkVideo() {
		return linkVideo;
	}

	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

}
