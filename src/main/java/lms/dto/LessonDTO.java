package lms.dto;


public class LessonDTO {
	private long id;
	private String nameLesson;
	private String contentLesson;
	private String linkVideo;
	private Long courseId;
	private int position;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public LessonDTO() {
		super();
	}

	public LessonDTO(long id, String nameLesson, String contentLesson, String linkVideo, Long courseId, int position) {
		super();
		this.id = id;
		this.nameLesson = nameLesson;
		this.contentLesson = contentLesson;
		this.linkVideo = linkVideo;
		this.courseId = courseId;
		this.position = position;
	}
}
