package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.model.Question;
import lms.repository.QuestionRepository;

@Service
@Transactional
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public Question save(Question ques) {
		return questionRepository.save(ques);
	}

	public List<?> getAllQuesOfQuiz(Long quizId) {
		Optional<List<Question>> res = questionRepository.getAllQuesOfQuiz(quizId);
		if (res.isPresent()) {
			return res.get();
		} else
			return null;
	}

}
