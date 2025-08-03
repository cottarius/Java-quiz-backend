package ru.cotarius.javaquiz.service;

import ru.cotarius.javaquiz.entity.QuizQuestion;

import java.util.List;

public interface QuizService {
    
    /**
     * Получить все вопросы викторины.
     */
    List<QuizQuestion> getAllQuestions();
    
    /**
     * Получить 10 случайных вопросов для викторины.
     */
    List<QuizQuestion> getQuizQuestions();
    
    /**
     * Проверить правильность ответа.
     */
    boolean checkAnswer(Long questionId, String answer);
} 