package lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.model.Quiz;
import lms.repository.QuizRepository;

@Service
@Transactional
public class QuizService {
	
	@Autowired
	private QuizRepository quizRepository;
	
	
	public Quiz save(Quiz quiz) {
		return quizRepository.save(quiz);
	}
	public List<?> getAllQuizInfo(){
		return quizRepository.getAllQuizInfo();
	}
	
}
