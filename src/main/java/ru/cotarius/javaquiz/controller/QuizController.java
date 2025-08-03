package ru.cotarius.javaquiz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cotarius.javaquiz.entity.QuizQuestion;
import ru.cotarius.javaquiz.payload.response.ApiResponse;
import ru.cotarius.javaquiz.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class QuizController {

    private final QuizService quizService;

    /**
     * Получить все вопросы викторины.
     */
    @GetMapping("/questions")
    public ResponseEntity<List<QuizQuestion>> getAllQuestions() {
        List<QuizQuestion> questions = quizService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    /**
     * Получить 10 случайных вопросов для викторины.
     */
    @GetMapping("/questions/random")
    public ResponseEntity<List<QuizQuestion>> getQuizQuestions() {
        List<QuizQuestion> questions = quizService.getQuizQuestions();
        return ResponseEntity.ok(questions);
    }

    /**
     * Проверить правильность ответа.
     */
    @PostMapping("/check-answer")
    public ResponseEntity<ApiResponse> checkAnswer(@RequestParam Long questionId, 
                                                  @RequestParam String answer) {
        boolean isCorrect = quizService.checkAnswer(questionId, answer);
        
        String message = isCorrect ? "Правильный ответ!" : "Неправильный ответ!";
        ApiResponse response = new ApiResponse(message);
        
        return ResponseEntity.ok(response);
    }
} 