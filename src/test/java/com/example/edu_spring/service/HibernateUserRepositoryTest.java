package com.example.edu_spring.service;

import com.example.edu_spring.model.User;
import com.example.edu_spring.repository.HibernateUserRepository;
import com.example.edu_spring.config.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import com.example.edu_spring.config.HibernateUtil;

@SpringBootTest
class HibernateUserRepositoryTest {

    private SessionFactory sessionFactory;
    private HibernateUserRepository userRepository;

    @BeforeEach
    void setup() {
        sessionFactory = HibernateUtil.getSessionFactory(); // Метод для создания SessionFactory
        userRepository = new HibernateUserRepository(sessionFactory);
    }

    @Test
    void testSaveAndFindById() {
        User user = new User();
        user.setUsername("User1");
        user.setEmail("user1@example.com");

        userRepository.save(user);
        User foundUser = userRepository.findById(user.getId());

        assertNotNull(foundUser);
        assertEquals("User1", foundUser.getUsername());
    }

    @Test
    void testFindAll() {
        List<User> users = userRepository.findAll();
        assertNotNull(users);
    }
}