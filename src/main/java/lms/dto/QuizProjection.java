package lms.dto;

public interface QuizProjection {
	Long getId();
	String getName();
	String getCourseName();
	Integer getTimeQuiz();
	Integer getCourseId();
	Integer getNumOfQues();
}
