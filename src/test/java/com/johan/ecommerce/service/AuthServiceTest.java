package com.johan.ecommerce.service;

import com.johan.ecommerce.service.entity.User;
import com.johan.ecommerce.service.repository.UserRepository;
import com.johan.ecommerce.service.security.JwtUtil;
import com.johan.ecommerce.service.service.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private BCryptPasswordEncoder encoder;

    @InjectMocks
    private AuthService authService;

    @Test
    void shouldGenerateTokenWhenCredentialsAreValid() {

        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword("hashedPassword");

        when(userRepository.findAll())
                .thenReturn(List.of(user));

        when(encoder.matches(
                "password123",
                "hashedPassword"))
                .thenReturn(true);

        when(jwtUtil.generateToken("test@test.com"))
                .thenReturn("jwt-token");

        String token =
                authService.login(
                        "test@test.com",
                        "password123"
                );

        assertEquals(
                "jwt-token",
                token
        );
    }
}