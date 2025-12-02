package lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lms.dto.CommentProjection;
import lms.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	@Query(value = "SELECT c.*, u.username FROM comment c "+
	        "JOIN users u ON c.userId = u.id "+
	        "WHERE c.lessonId = :lessonId "+
	        "ORDER BY c.timeCmt DESC", nativeQuery = true)
	List<CommentProjection> getAllCommentOfLesson(@Param("lessonId") Long lessonId);

	
}
