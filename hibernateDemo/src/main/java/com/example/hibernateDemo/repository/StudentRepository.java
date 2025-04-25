package com.example.hibernateDemo.repository;

import com.example.hibernateDemo.model.Student;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

public class StudentRepository {
    public Student save(Student student) {
        // save the record to the database
        Configuration config = new Configuration();
        config.addAnnotatedClass(Student.class);
        config.configure();

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
       session.save(student);

        session.getTransaction().commit();
        return null;
    }

    public List<Student> getRecords() {


        Configuration config = new Configuration();
        config.addAnnotatedClass(Student.class);
        config.configure();

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query query = session.createQuery("from Student");

        return  query.getResultList();

    }
}
