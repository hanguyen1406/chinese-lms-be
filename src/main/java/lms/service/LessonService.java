package lms.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.dto.CommentDTO;
import lms.dto.LessonDTO;
import lms.model.Comment;
import lms.model.Lesson;
import lms.model.UserDetailsImpl;
import lms.repository.CommentRepository;
import lms.repository.LessonRepository;
import lms.security.SecurityUtils;

@Service
@Transactional
public class LessonService {

	@Autowired
	private LessonRepository lessonRepository;
	@Autowired
	private CommentRepository commentRepository;

	public Lesson save(Lesson lesson) {
		return lessonRepository.save(lesson);
	}

	public List<Lesson> getLessonOfCourse(Long courseId) {
		Optional<List<Lesson>> res = lessonRepository.getAllLessonOfCourse(courseId);
		if (res.isPresent()) {
			return res.get();
		} else
			return null;
	}

	public List<?> getAllCommentOfLesson(Long lessonId) {
		List<?> listComment = commentRepository.getAllCommentOfLesson(lessonId);
		return listComment;
	}

	public CommentDTO commentLesson(Comment cmt) {
		// kiểm tra lesson có tồn tại không
		if (cmt.getLessonId() != null && lessonRepository.existsById(cmt.getLessonId())
				&& !cmt.getContentCmt().isEmpty()) {
			// kiểm tra có parentId ko cho comment phản hồi
			UserDetailsImpl userDetails = SecurityUtils.getCurrentUser();
			cmt.setUserId(userDetails.getId());
			cmt.setTimeCmt(new Date());
			Comment comment = commentRepository.save(cmt);
			CommentDTO commentDTO = new CommentDTO();
			BeanUtils.copyProperties(comment, commentDTO);
			commentDTO.setUsername(userDetails.getUsername());
			return commentDTO;

		}
		return null;
	}

	public Lesson getById(Long id) {
		return lessonRepository.findById(id).orElse(null); // nếu không tồn tại trả về null
	}

}
