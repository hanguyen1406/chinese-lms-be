package lms.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lms.model.Lesson;
import lms.model.ScoreQuiz;

@Repository
public interface ScoreQuizRepository extends JpaRepository<ScoreQuiz, Long> {
	@Query(value = "SELECT * FROM scorequiz "
			+ "WHERE scorequiz.quizId = :quizId "
			+ "AND scorequiz.userId = :userId "
			+ "AND NOW() < scorequiz.finished_at", nativeQuery = true)
	Optional<ScoreQuiz> checkDoingQuiz(@Param("quizId") Long quizId, @Param("userId") Long userId);
}
