package lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lms.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	@Query(value = "SELECT * FROM question WHERE question.quizId = :quizId", nativeQuery = true)
	Optional<List<?>> getAllQuesOfQuiz(@Param("quizId") Long quizId);

	@Query(value = "SELECT id, content, a, b, c, d, quizId, image_url "
			+ "FROM question WHERE question.quizId = :quizId", nativeQuery = true)
	Optional<List<?>> getAllQuesOfQuizTest(@Param("quizId") Long quizId);

	
}
