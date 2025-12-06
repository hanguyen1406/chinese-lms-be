package lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lms.model.ScoreQuiz;
import lms.model.UserDetailsImpl;
import lms.repository.ScoreQuizRepository;
import lms.security.SecurityUtils;

@Service
@Transactional
public class ScoreQuizService {

	@Autowired
	private ScoreQuizRepository scoreQuizRepository;

	public ScoreQuiz save(ScoreQuiz ques) {
		return scoreQuizRepository.save(ques);
	}

	public ScoreQuiz checkDoingQuiz(Long quizId) {
		UserDetailsImpl userDetails = SecurityUtils.getCurrentUser();
		Optional<ScoreQuiz> data = scoreQuizRepository.checkDoingQuiz(quizId, userDetails.getId());
		return data.orElse(null);
	}

}
