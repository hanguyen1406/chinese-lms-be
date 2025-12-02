package lms.dto;

import java.util.Date;
import java.util.List;

public class CourseInfoDTO {
	private long id;
	private String name;
	private String thumbnailUrl;
	private String description;
	private String level;
	private Boolean published;
	private Date start_date;
	private Date end_date;
	private List<LessonDTO> lesson;

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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public List<LessonDTO> getLesson() {
		return lesson;
	}

	public void setLesson(List<LessonDTO> lesson) {
		this.lesson = lesson;
	}

	public CourseInfoDTO(long id, String name, String thumbnailUrl, String description, String level, Boolean published,
			Date start_date, Date end_date, List<LessonDTO> lesson) {
		super();
		this.id = id;
		this.name = name;
		this.thumbnailUrl = thumbnailUrl;
		this.description = description;
		this.level = level;
		this.published = published;
		this.start_date = start_date;
		this.end_date = end_date;
		this.lesson = lesson;
	}

	public CourseInfoDTO() {
		super();
	}

}
