package com.example.edu_spring.repository;

import com.example.edu_spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateUserRepository {

    private final SessionFactory sessionFactory;

    public HibernateUserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }
    }

    public User findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    public List<User> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from User", User.class).list();
        }
    }

    public void update(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(user);
            transaction.commit();
        }
    }

    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.remove(user);
            }
            transaction.commit();
        }
    }
}