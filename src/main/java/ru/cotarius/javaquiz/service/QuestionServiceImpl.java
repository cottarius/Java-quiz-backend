package ru.cotarius.javaquiz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cotarius.javaquiz.entity.Question;
import ru.cotarius.javaquiz.entity.Theme;
import ru.cotarius.javaquiz.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    /**
     * Ищет вопрос по его идентификатору.
     *
     * @param id идентификатор вопроса
     * @return {@link Optional} с вопросом, если найден
     */
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    /**
     * Возвращает список всех вопросов.
     *
     * @return список всех вопросов
     */
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    /**
     * Возвращает список главных (важных) вопросов.
     *
     * @return список важных вопросов
     */
    public List<Question> getPrimaryQuestions() {
        List<Question> primaryQuestions = new ArrayList<>();
        for (Question question : questionRepository.findAll()) {
            if (question.isImpotent()) {
                primaryQuestions.add(question);
            }
        }
        return primaryQuestions;
    }

    /**
     * Возвращает список вопросов, соответствующих указанной теме.
     *
     * @param theme тема вопроса
     * @return список вопросов по теме
     */
    public List<Question> getQuestionsFromTheme(Theme theme) {
        List<Question> questions = new ArrayList<>();
        for (Question question : questionRepository.findAll()) {
            if (question.getTheme().equals(theme)) {
                questions.add(question);
            }
        }
        return questions;
    }

    /** @return вопросы по теме Hibernate/JDBC */
    public List<Question> getHibernateQuestions() {
        return getQuestionsFromTheme(Theme.HIBERNATE_JDBC);
    }

    /** @return вопросы по Java Core - часть 1 */
    public List<Question> getCore1Questions() {
        return getQuestionsFromTheme(Theme.CORE1);
    }

    /** @return вопросы по Java Core - коллекции/Stream API */
    public List<Question> getCore2Questions() {
        return getQuestionsFromTheme(Theme.CORE2_COLLECTIONS);
    }

    /** @return вопросы по Java Core - многопоточность */
    public List<Question> getCore3Questions() {
        return getQuestionsFromTheme(Theme.CORE3_MULTITHREADING);
    }

    /** @return вопросы по паттернам и алгоритмам */
    public List<Question> getPatternsQuestions() {
        return getQuestionsFromTheme(Theme.PATTERNS_ALGORITHMS);
    }

    /** @return вопросы по sql и базам данных */
    public List<Question> getSqlQuestions() {
        return getQuestionsFromTheme(Theme.SQL_DATABASE);
    }

    /** @return вопросы по Spring Framework */
    public List<Question> getSpringQuestions() { return getQuestionsFromTheme(Theme.SPRING); }

    public List<Question> searchQuestions(String searchText, boolean searchInAnswers) {
        if (searchText == null || searchText.trim().isEmpty()) {
            return Collections.emptyList();
        }

        String searchTerm = searchText.toLowerCase().trim();

        return questionRepository.findAll()
                .stream()
                .filter(question ->
                        question.getQuestion().toLowerCase().contains(searchTerm) ||
                                (searchInAnswers &&
                                        question.getAnswer() != null &&
                                        question.getAnswer().toLowerCase().contains(searchTerm)))
                .collect(Collectors.toList());
    }
}
