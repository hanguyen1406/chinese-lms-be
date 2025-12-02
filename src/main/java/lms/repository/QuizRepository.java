package lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lms.dto.QuizProjection;
import lms.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

	@Query(value = "SELECT qz.*, COUNT(q.id) AS numOfQues, c.name AS courseName FROM quiz qz "
			+ "LEFT JOIN question q ON q.quizId = qz.id "
			+ "INNER JOIN course c ON c.id = qz.courseId GROUP BY qz.id", nativeQuery = true)
	List<QuizProjection> getAllQuizInfo();

}
