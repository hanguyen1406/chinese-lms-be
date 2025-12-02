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
import lms.model.Question;
import lms.model.Quiz;
import lms.model.UserDetailsImpl;
import lms.security.SecurityUtils;
import lms.service.LessonService;
import lms.service.QuestionService;
import lms.service.QuizService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
	QuestionService questionService;

	@PostMapping
	@PreAuthorize("hasRole('ADMINISTRATOR')")
	public ResponseEntity<?> create(@RequestBody Question ques) {
		try {
			questionService.save(ques);
			return new ResponseEntity<Question>(ques, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Có lỗi xảy ra trên server!"));

	}

	@GetMapping("/quesOfQuiz/{id}")
	public ResponseEntity<?> getAll(@PathVariable("id") Long id) {
		try {
			Thread.sleep(2000);
			List<?> res = questionService.getAllQuesOfQuiz(id);
			return ResponseEntity.ok(res);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
}
