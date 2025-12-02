package lms.dto;
import java.util.Date;

public interface CommentProjection {
    Long getId();
    String getContentCmt();
    Date getTimeCmt();
    Long getUserId();
    String getUsername();
    Long getLessonId();
    Long getParentId();
}
