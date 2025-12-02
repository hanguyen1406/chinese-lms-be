package lms.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.dto.CommentDTO;
import lms.model.Comment;
import lms.model.Lesson;
import lms.model.MessageResponse;
import lms.model.UserDetailsImpl;
import lms.security.SecurityUtils;
import lms.service.LessonService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/lesson")
public class LessonController {

	@Autowired
	LessonService lessonService;

	@PostMapping
	@PreAuthorize("hasRole('ADMINISTRATOR')")
	public ResponseEntity<?> create(@RequestBody Lesson lesson) {
		try {
			lessonService.save(lesson);
			return new ResponseEntity<Lesson>(lesson, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Bài giảng đã tồn tại!"));

	}

	@GetMapping("/lessonOfCourse/{id}")
	public ResponseEntity<?> getLessonOfCourse(@PathVariable("id") Long id) {
		List<Lesson> res = lessonService.getLessonOfCourse(id);
		if (res != null) {
			return ResponseEntity.ok(res);

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		}
	}

	@GetMapping("/comments/{id}")
	public ResponseEntity<?> allCommentOfLesson(@PathVariable("id") Long id) {
		List<?> res = lessonService.getAllCommentOfLesson(id);
		return ResponseEntity.ok(res);
	}

	@PostMapping("/comment")
	public ResponseEntity<?> commentLesson(@RequestBody Comment comment) {

		CommentDTO res = lessonService.commentLesson(comment);
		if (res != null) {

			return ResponseEntity.ok(res);

		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new MessageResponse("Có lỗi xảy ra trên server!"));

		}
	}

}
