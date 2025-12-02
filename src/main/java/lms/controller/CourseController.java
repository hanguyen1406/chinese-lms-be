package lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lms.model.Course;
import lms.model.MessageResponse;
import lms.service.CourseService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/course")
public class CourseController {

	@Autowired
	CourseService courseService;

	@PostMapping
	@PreAuthorize("hasRole('ADMINISTRATOR')")
	public ResponseEntity<?> create(@RequestBody Course course) {
		try {
			courseService.save(course);
			return new ResponseEntity<Course>(course, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Khóa học đã tồn tại!"));

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCourseDetail(@PathVariable("id") Long id) {
		Course res = courseService.getById(id);
		if(res != null) {
			return ResponseEntity.ok(res);
			
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	
		}
	}

	@GetMapping()
	public ResponseEntity<?> getAll() {
		List<?> res = courseService.getAll();
		return ResponseEntity.ok(res);
	}

}
