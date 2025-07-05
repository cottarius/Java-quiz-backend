package ru.cotarius.javaquiz.service;

import ru.cotarius.javaquiz.entity.Question;
import ru.cotarius.javaquiz.entity.Theme;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<Question> searchQuestions(String searchText, boolean searchInAnswers);

    List<Question> findAll();

    Optional<Question> findById(Long id);

    /**
     * Возвращает список главных (важных) вопросов.
     *
     * @return список важных вопросов
     */
    List<Question> getPrimaryQuestions();

    /**
     * Возвращает список вопросов, соответствующих указанной теме.
     *
     * @param theme тема вопроса
     * @return список вопросов по теме
     */
    List<Question> getQuestionsFromTheme(Theme theme);

    /**
     * @return вопросы по теме Hibernate/JDBC
     */
    List<Question> getHibernateQuestions();

    /**
     * @return вопросы по Java Core - часть 1
     */
    List<Question> getCore1Questions();

    /**
     * @return вопросы по Java Core - коллекции/Stream API
     */
    List<Question> getCore2Questions();

    /**
     * @return вопросы по Java Core - многопоточность
     */
    List<Question> getCore3Questions();

    /**
     * @return вопросы по паттернам и алгоритмам
     */
    List<Question> getPatternsQuestions();

    /**
     * @return вопросы по sql и базам данных
     */
    List<Question> getSqlQuestions();

    /**
     * @return вопросы по Spring Framework
     */
    List<Question> getSpringQuestions();
}
