package com.example.edu_spring.repository;

import com.example.edu_spring.model.User;
import com.example.edu_spring.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private HibernateUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testSaveUser() {
        User user = new User();
        user.setUsername("JohnDoe");
        user.setEmail("john@example.com");

        userService.save(user);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testFindAll() {
        when(userRepository.findAll()).thenReturn(List.of(new User(), new User()));

        List<User> users = userService.findAll();

        assertEquals(2, users.size());
        verify(userRepository, times(1)).findAll();
    }
}