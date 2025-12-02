package lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lms.dto.CourseProjection;
import lms.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	@Query(value = "SELECT course.* FROM course WHERE course.name = :name", nativeQuery = true)
	Optional<Course> findByName(@Param("name") String name);

	@Query(value =
	        "SELECT c.id, " +
	        "c.name, " +
	        "c.thumbnailUrl, " +
	        "c.description, " +
	        "c.level, " +
	        "c.published, " +
	        "c.start_date, " +
	        "c.end_date, " +
	        "COALESCE(AVG(r.numStar), 0) numRating, " +
	        "COALESCE(COUNT(DISTINCT l.id), 0) numLesson " +
	        "FROM course c " +
	        "LEFT JOIN rating r ON r.courseId = c.id " +
	        "LEFT JOIN lesson l ON l.courseId = c.id " +
	        "GROUP BY c.id, c.name, c.thumbnailUrl, c.description, " +
	        "c.level, c.published, c.start_date, c.end_date",
	        nativeQuery = true)
	List<CourseProjection> getAllCourseInfo();


	
}
