package ru.cotarius.javaquiz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.cotarius.javaquiz.entity.Question;
import ru.cotarius.javaquiz.service.QuestionService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")  // Разрешить запросы с React-приложени
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/spring/")
    public List<Question> getSpringQuestions() {
        return questionService.getSpringQuestions();
    }

    @GetMapping("/hibernate/")
    public List<Question> getHibernateQuestions() {
        return questionService.getHibernateQuestions();
    }

    @GetMapping("/sql/")
    public List<Question> getSqlQuestion() {
        return questionService.getSqlQuestions();
    }

    @GetMapping("/all/")
    public List<Question> getAllQuestions() {
        return questionService.findAll();
    }

    @GetMapping("/primary/")
    public List<Question> getPrimaryQuestions() {
        return questionService.getPrimaryQuestions();
    }

    @GetMapping("/core1/")
    public List<Question> getCore1Questions() {
        return questionService.getCore1Questions();
    }

    @GetMapping("/core2/")
    public List<Question> getCore2Questions() {
        return questionService.getCore2Questions();
    }

    @GetMapping("/core3/")
    public List<Question> getCore3Questions() {
        return questionService.getCore3Questions();
    }

    @GetMapping("/patterns/")
    public List<Question> getPatternsQuestions() {
        return questionService.getPatternsQuestions();
    }

    @GetMapping("/search")
    public List<Question> searchQuestions(
            @RequestParam String query,
            @RequestParam(defaultValue = "false") boolean searchInAnswers) {
        return questionService.searchQuestions(query, searchInAnswers);
    }

    /**
     * Отображает главную страницу приложения.
     *
     * @return имя представления главной страницы
     */
    @GetMapping(value = "/index")
    public String mainPage() {
        return "index";
    }
}
