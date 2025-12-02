package lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.model.Course;
import lms.repository.CourseRepository;

@Service
@Transactional
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
		
	public Course save(Course course) {
    	return courseRepository.save(course);
    }
	
	public Course getById(Long id) {
		return courseRepository.findById(id)
	            .orElse(null); // nếu không tồn tại trả về null
    }
	
	public List<?> getAll(){
		return courseRepository.getAllCourseInfo();
	}

	
}
