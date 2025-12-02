package lms.dto;

import java.util.Date;

public interface CourseProjection {
	Long getId();
    String getName();
    String getThumbnailUrl();
    String getDescription();
    String getLevel();
    Boolean getPublished();
    Date getStart_date();
    Date getEnd_date();
    Double getNumRating();
    Long getNumLesson();
}
