package ru.cotarius.javaquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.cotarius.javaquiz.entity.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("SELECT q FROM Question q WHERE " +
            "LOWER(q.question) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(q.answer) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Question> searchByText(@Param("searchTerm") String searchTerm);

}
