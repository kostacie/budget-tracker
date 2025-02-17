package ru.kostacie.budgettracker.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kostacie.budgettracker.dto.UserDto;
import ru.kostacie.budgettracker.model.User;
import ru.kostacie.budgettracker.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "Пользователи", description = "API для управления пользователями")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    @Operation(summary = "Получить пользователя", description = "Показывает пользователя")
    public ResponseEntity<User> getUser(@PathVariable UUID id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Создать пользователя", description = "Добавляет нового пользователя в систему")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDto request) {
        return ResponseEntity.ok(userService.createUser(request));
    }
}
