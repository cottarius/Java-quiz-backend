package ru.cotarius.javaquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cotarius.javaquiz.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);  // ✅ заменено с username на email
    boolean existsByEmail(String email);       // (если используешь при регистрации)
}