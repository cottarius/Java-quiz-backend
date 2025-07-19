package ru.cotarius.javaquiz.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cotarius.javaquiz.entity.User;
import ru.cotarius.javaquiz.payload.request.AuthRequest;
import ru.cotarius.javaquiz.payload.request.RegisterRequest;
import ru.cotarius.javaquiz.security.JwtService;
import ru.cotarius.javaquiz.service.TelegramBotService;
import ru.cotarius.javaquiz.service.UserService;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final UserService userService;
    private final JwtService jwtService;
    private final TelegramBotService telegramBotService;

    @Value("${telegram.chat_id}")
    private String chatId;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = (User) auth.getPrincipal();
        String token = jwtService.generateToken(user);
        log.info("Пользователь {} успешно вошел в систему", user.getUsername());
        telegramBotService.sendMessage(user.getUsername() + " зашел на Java Quizzer", chatId);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        userService.registerUser(request); // реализовать создание пользователя и шифрование пароля
        return ResponseEntity.ok(Map.of("message", "User created"));
    }
}