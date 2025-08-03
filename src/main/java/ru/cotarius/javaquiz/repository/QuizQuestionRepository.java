package ru.cotarius.javaquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cotarius.javaquiz.entity.QuizQuestion;

import java.util.List;

@Repository
public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {
    
    /**
     * Получить все вопросы викторины.
     */
    List<QuizQuestion> findAll();
    
    /**
     * Получить случайные вопросы викторины.
     */
    List<QuizQuestion> findTop10ByOrderById();
} 