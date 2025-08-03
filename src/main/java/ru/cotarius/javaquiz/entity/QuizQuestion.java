package ru.cotarius.javaquiz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "quiz_questions")
@AllArgsConstructor
@NoArgsConstructor
public class QuizQuestion {

    /**
     * Уникальный идентификатор вопроса викторины.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Текст вопроса.
     */
    @Column(nullable = false)
    private String question;

    /**
     * Правильный ответ.
     */
    @Column(name = "correct_answer", nullable = false)
    private String correctAnswer;

    /**
     * Первый неправильный ответ.
     */
    @Column(name = "wrong_answer", nullable = false)
    private String wrongAnswer;

    /**
     * Второй неправильный ответ.
     */
    @Column(name = "wrong_answer_2", nullable = false)
    private String wrongAnswer2;

    /**
     * Третий неправильный ответ.
     */
    @Column(name = "wrong_answer_3", nullable = false)
    private String wrongAnswer3;
} 