package ru.cotarius.javaquiz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    /**
     * Уникальный идентификатор вопроса.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Текст вопроса.
     */
    private String question;

    /**
     * Ответ на вопрос.
     */
    private String answer;

    /**
     * Тема вопроса.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "theme")
    private Theme theme;

    /**
     * Важность вопроса.
     */
    @Column(name = "is_impotent")
    private boolean isImpotent;
}
