package ru.cotarius.javaquiz.service;

import ru.cotarius.javaquiz.entity.User;
import ru.cotarius.javaquiz.payload.request.RegisterRequest;

public interface UserService {
    void registerUser(RegisterRequest request);
    User findByEmail(String email);
}