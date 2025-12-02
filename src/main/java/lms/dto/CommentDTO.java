package lms.dto;

import java.util.Date;

public class CommentDTO {
	private Long id;
	private String contentCmt;
	private Date timeCmt;
	private Long userId;
	private Long lessonId;
	private Long parentId;
	private String username;

	public CommentDTO(Long id, String contentCmt, Date timeCmt, Long userId, Long lessonId, Long parentId,
			String username) {
		super();
		this.id = id;
		this.contentCmt = contentCmt;
		this.timeCmt = timeCmt;
		this.userId = userId;
		this.lessonId = lessonId;
		this.parentId = parentId;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Long getLessonId() {
		return lessonId;
	}

	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public CommentDTO() {
		super();
	}

}
