package com.example.edu_spring.service;

import com.example.edu_spring.model.User;
import com.example.edu_spring.repository.HibernateUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final HibernateUserRepository userRepository;

    public UserService(HibernateUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }
}