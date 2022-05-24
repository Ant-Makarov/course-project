package com.fintech.courseproject.serviceTest;

import com.fintech.courseproject.entity.User;
import com.fintech.courseproject.repository.UserRepository;
import com.fintech.courseproject.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @ParameterizedTest
    @MethodSource("getUsers")
    void shouldRegisterNewUser(List<User> existingUsers) {
        doReturn(existingUsers).when(userRepository).findAll();
        doReturn(User.builder()
        .fullName("Max")
        .email("max@gmail.com")
        .phoneNumber("0991234567")
        .build())
        .when(userRepository).save(eq(User.builder()
                                .fullName("Max")
                                .email("max@gmail.com")
                                .phoneNumber("0991234567")
                                .build()));
        User user = userService.saveUser(User.builder()
                .fullName("Max")
                .email("max@gmail.com")
                .phoneNumber("0991234567")
                .build());
        verify(userRepository, times(1)).findAll();
        verify(userRepository, times(1)).save(eq(User.builder()
        .fullName("Max")
        .email("max@gmail.com")
        .phoneNumber("0991234567")
        .build()));

        assertThat(existingUsers.contains(user)).isFalse();
        assertThat(user.getEmail()).isEqualTo("max@gmail.com");
        assertThat(user.getFullName()).isEqualTo("Max");
        assertThat(user.getPhoneNumber()).isEqualTo("0991234567");
    }

    @ParameterizedTest
    @MethodSource("getUsers")
    void shouldNotRegisterNewUserIfAlreadyExists(List<User> existingUsers) {
        doReturn(existingUsers).when(userRepository).findAll();

    }
    private static Stream<Arguments> getUsers() {
        return Stream.of(Arguments.of(Stream.of(
                User.builder()
                        .fullName("Alex")
                        .email("alex@gmail.com")
                        .phoneNumber("0961234567")
                        .build(),
                User.builder()
                        .fullName("Oleh")
                        .email("oleh@gmail.com")
                        .phoneNumber("0967654321")
                        .build(),
                User.builder()
                        .fullName("Mariya")
                        .email("mariya@gmail.com")
                        .phoneNumber("0961237654")
                        .build()
        ).collect(Collectors.toList())));
    }
}
