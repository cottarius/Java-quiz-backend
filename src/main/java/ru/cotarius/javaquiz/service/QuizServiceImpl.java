package ru.cotarius.javaquiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cotarius.javaquiz.entity.QuizQuestion;
import ru.cotarius.javaquiz.repository.QuizQuestionRepository;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizQuestionRepository quizQuestionRepository;

    @Override
    public List<QuizQuestion> getAllQuestions() {
        return quizQuestionRepository.findAll();
    }

    @Override
    public List<QuizQuestion> getQuizQuestions() {
        List<QuizQuestion> allQuestions = quizQuestionRepository.findAll();
        
        // Перемешиваем вопросы и берем первые 10
        Collections.shuffle(allQuestions);
        
        return allQuestions.stream()
                .limit(10)
                .toList();
    }

    @Override
    public boolean checkAnswer(Long questionId, String answer) {
        QuizQuestion question = quizQuestionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Вопрос не найден"));
        
        return question.getCorrectAnswer().equals(answer);
    }
} 