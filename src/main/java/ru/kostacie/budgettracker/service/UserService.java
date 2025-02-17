package ru.kostacie.budgettracker.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kostacie.budgettracker.dto.UserDto;
import ru.kostacie.budgettracker.model.User;
import ru.kostacie.budgettracker.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(UserDto request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .build();
        return userRepository.save(user);
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }
}
