package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.model.Question;
import lms.model.UserDetailsImpl;
import lms.repository.QuestionRepository;
import lms.security.SecurityUtils;

@Service
@Transactional
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public Question save(Question ques) {
		return questionRepository.save(ques);
	}

	public List<?> getAllQuesOfQuiz(Long quizId) {
		Optional<List<?>> res = null;
		UserDetailsImpl userDetails = SecurityUtils.getCurrentUser();
		if(userDetails.getUsername() == "admin") {
			res = questionRepository.getAllQuesOfQuiz(quizId);
		} else {
			res = questionRepository.getAllQuesOfQuizTest(quizId);
		}
		
		if (res.isPresent()) {
			return res.get();
		} else
			return null;
	}

}
