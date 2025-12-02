package lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lms.dto.LessonDTO;
import lms.model.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
	@Query(value = "SELECT * FROM lesson WHERE lesson.courseId = :courseId", nativeQuery = true)
	Optional<List<Lesson>> getAllLessonOfCourse(@Param("courseId") Long courseId);

	
}
